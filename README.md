# Sparrow DB
A simple database, small but complete, so call Sparrow DB

## 总体架构
![总体架构](https://github.com/xianfengyi/photos/blob/main/sparrowdb/%E6%80%BB%E4%BD%93%E6%9E%B6%E6%9E%84.png)

## SQL Language

### SQL语句
目前，主要支持创建表、删除表、插入数据、删除数据、更新数据、查询数据这些基本的操作。
#### 创建表
```sql
CREATE TABLE [ IF NOT EXISTS ]
table_name (
  { column_name data_type [ COMMENT comment ] }
  [, ...]
)
[ COMMENT table_comment ]
```
#### 删除表
```sql
DROP TABLE  [ IF EXISTS ] table_name
```
#### 插入数据
```sql
INSERT INTO table_name ( field1, field2,...fieldN )
VALUES( value1, value2,...valueN );
```
#### 删除数据
```sql
DELETE FROM table_name [ WHERE condition ]
```
#### 更新数据
```sql
UPDATE table_name SET field1=new-value1, field2=new-value2 [WHERE Clause]
```
#### 查询数据
```sql
SELECT column_name,column_name
FROM table_name
[WHERE Clause]
[LIMIT N][ OFFSET M]
```
### 语法设计
SQL语法采用Antlr4设计，部分语法如下：
```antlrv4
grammar SparrowSQL;

tokens {
    DELIMITER
}

singleStatement
    : statement EOF
    ;

statement
    : query                                                            #statementDefault
    | CREATE TABLE (IF NOT EXISTS)? qualifiedName
            '(' tableElement (',' tableElement)* ')'
             (COMMENT string)?                                         #createTable
    | DROP TABLE (IF EXISTS)? qualifiedName                            #dropTable
    | INSERT INTO qualifiedName columnAliases? query                   #insertInto
    | DELETE FROM qualifiedName (WHERE booleanExpression)?             #delete
    ;
```

### SQL Parser
SQL parser 将SQL语法转化为AST, 可以通过Antlr4 Visitor模式实现，核心Parse逻辑如下：
```java
public class SqlParser {

    public Statement createStatement(String sql) {
        return (Statement) invokeParser("statement", sql, SparrowSQLParser::singleStatement);
    }

    private Node invokeParser(String name, String sql, Function<SparrowSQLParser, ParserRuleContext> parseFunction) {
        try {
            SparrowSQLLexer lexer = new SparrowSQLLexer(new CaseInsensitiveStream(CharStreams.fromString(sql)));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            SparrowSQLParser parser = new SparrowSQLParser(tokenStream);

            // Override the default error strategy to not attempt inserting or deleting a token.
            // Otherwise, it messes up error reporting
            parser.setErrorHandler(new DefaultErrorStrategy() {
                @Override
                public Token recoverInline(Parser recognizer) throws RecognitionException {
                    if (nextTokensContext == null) {
                        throw new InputMismatchException(recognizer);
                    } else {
                        throw new InputMismatchException(recognizer, nextTokensState, nextTokensContext);
                    }
                }
            });

            parser.removeErrorListeners();

            ParserRuleContext tree;
            try {
                // first, try parsing with potentially faster SLL mode
                parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
                tree = parseFunction.apply(parser);
            } catch (ParseCancellationException ex) {
                // if we fail, parse with LL mode
                tokenStream.reset(); // rewind input stream
                parser.reset();

                parser.getInterpreter().setPredictionMode(PredictionMode.LL);
                tree = parseFunction.apply(parser);
            }

            return new AstBuilder(new ParsingOptions()).visit(tree);
        } catch (StackOverflowError e) {
            throw new ParsingException(name + " is too large (stack overflow while parsing)");
        }
    }
}
```
## 执行器
SQL查询引擎这块采用经典的火山模型，该计算模型将关系代数中每一种操作抽象为一个 Operator，将整个 SQL 构建成一个 Operator 树，查询树自顶向下的调用next()接口，数据则自底向上的被拉取处理。
![迭代器模型](https://github.com/xianfengyi/photos/blob/main/sparrowdb/Iterator%20model.jpg)
