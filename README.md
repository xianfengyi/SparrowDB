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

