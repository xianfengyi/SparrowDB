grammar SparrowSQL;

tokens {
    DELIMITER
}

singleStatement
    : statement EOF
    ;

statement
    : query                                                            #statementDefault
    ;

query
    :  queryNoWith
    ;

queryNoWith:
      queryTerm
      (ORDER BY sortItem (',' sortItem)*)?
      (OFFSET offset=INTEGER_VALUE (ROW | ROWS)?)?
      (LIMIT limit=INTEGER_VALUE)?
    ;

queryTerm
    : queryPrimary                                                             #queryTermDefault
    ;

queryPrimary
    : querySpecification                   #queryPrimaryDefault
    | TABLE qualifiedName                  #table
    | VALUES expression (',' expression)*  #inlineTable
    | '(' queryNoWith  ')'                 #subquery
    ;

sortItem
    : expression ordering=(ASC | DESC)?
    ;

querySpecification
    : SELECT setQuantifier? selectItem (',' selectItem)*
      (FROM relation (',' relation)*)?
      (WHERE where=booleanExpression)?
      (GROUP BY groupBy)?
    ;

groupBy
    : setQuantifier? groupingElement (',' groupingElement)*
    ;

groupingElement
    : groupingSet                                            #singleGroupingSet
    ;

groupingSet
    : '(' (expression (',' expression)*)? ')'
    | expression
    ;

setQuantifier
    : DISTINCT
    | ALL
    ;

selectItem
    : expression (AS? identifier)?  #selectSingle
    | qualifiedName '.' ASTERISK    #selectAll
    | ASTERISK                      #selectAll
    ;

relation
    : left=relation
      ( CROSS JOIN right=sampledRelation
      | joinType JOIN rightRelation=relation joinCriteria
      | NATURAL joinType JOIN right=sampledRelation
      )                                           #joinRelation
    | sampledRelation                             #relationDefault
    ;

joinType
    : INNER?
    | LEFT OUTER?
    | RIGHT OUTER?
    | FULL OUTER?
    ;

joinCriteria
    : ON booleanExpression
    ;

sampledRelation
    : aliasedRelation (
        TABLESAMPLE sampleType '(' percentage=expression ')'
      )?
    ;

sampleType
    : BERNOULLI
    | SYSTEM
    ;

aliasedRelation
    : relationPrimary (AS? identifier columnAliases?)?
    ;

columnAliases
    : '(' identifier (',' identifier)* ')'
    ;

relationPrimary
    : qualifiedName                                                   #tableName
    | '(' query ')'                                                   #subqueryRelation
    | '(' relation ')'                                                #parenthesizedRelation
    ;

expression
    : booleanExpression
    ;

booleanExpression
    : predicated                                                   #booleanDefault
    | NOT booleanExpression                                        #logicalNot
    | left=booleanExpression operator=AND right=booleanExpression  #logicalBinary
    | left=booleanExpression operator=OR right=booleanExpression   #logicalBinary
    ;

// workaround for:
//  https://github.com/antlr/antlr4/issues/780
//  https://github.com/antlr/antlr4/issues/781
predicated
    : valueExpression predicate[$valueExpression.ctx]?
    ;

predicate[ParserRuleContext value]
    : comparisonOperator right=valueExpression                            #comparison
    | NOT? BETWEEN lower=valueExpression AND upper=valueExpression        #between
    | NOT? IN '(' expression (',' expression)* ')'                        #inList
    | NOT? IN '(' query ')'                                               #inSubquery
    | IS NOT? NULL                                                        #nullPredicate
    | IS NOT? DISTINCT FROM right=valueExpression                         #distinctFrom
    ;

valueExpression
    : primaryExpression                                                                 #valueExpressionDefault
    | operator=(MINUS | PLUS) valueExpression                                           #arithmeticUnary
    | left=valueExpression operator=(ASTERISK | SLASH | PERCENT) right=valueExpression  #arithmeticBinary
    | left=valueExpression operator=(PLUS | MINUS) right=valueExpression                #arithmeticBinary
    | left=valueExpression CONCAT right=valueExpression                                 #concatenation
    ;

primaryExpression
    : NULL                                                                                #nullLiteral
    | identifier string                                                                   #typeConstructor
    | number                                                                              #numericLiteral
    | booleanValue                                                                        #booleanLiteral
    | string                                                                              #stringLiteral
    | identifier                                                                          #columnReference
    ;

string
    : STRING                                #basicStringLiteral
    ;

comparisonOperator
    : EQ | NEQ | LT | LTE | GT | GTE
    ;

booleanValue
    : TRUE | FALSE
    ;

qualifiedName
    : identifier ('.' identifier)*
    ;

identifier
    : IDENTIFIER             #unquotedIdentifier
    | QUOTED_IDENTIFIER      #quotedIdentifier
    | BACKQUOTED_IDENTIFIER  #backQuotedIdentifier
    | DIGIT_IDENTIFIER       #digitIdentifier
    ;

number
    : DECIMAL_VALUE  #decimalLiteral
    | DOUBLE_VALUE   #doubleLiteral
    | INTEGER_VALUE  #integerLiteral
    ;

ALL: 'ALL';
AND: 'AND';
AS: 'AS';
ASC: 'ASC';
BERNOULLI: 'BERNOULLI';
BETWEEN: 'BETWEEN';
BY: 'BY';
CASE: 'CASE';
CROSS: 'CROSS';
DESC: 'DESC';
DISTINCT: 'DISTINCT';
ELSE: 'ELSE';
END: 'END';
FALSE: 'FALSE';
FROM: 'FROM';
FULL: 'FULL';
GROUP: 'GROUP';
JOIN: 'JOIN';
IN: 'IN';
INNER: 'INNER';
IS: 'IS';
LEFT: 'LEFT';
LIMIT: 'LIMIT';
LIKE: 'LIKE';
NATURAL: 'NATURAL';
NOT: 'NOT';
NULL: 'NULL';
OFFSET: 'OFFSET';
ON: 'ON';
OR: 'OR';
ORDER: 'ORDER';
OUTER: 'OUTER';
RIGHT: 'RIGHT';
ROW: 'ROW';
ROWS: 'ROWS';
SELECT: 'SELECT';
SYSTEM: 'SYSTEM';
TABLE: 'TABLE';
TABLESAMPLE: 'TABLESAMPLE';
THEN: 'THEN';
TRUE: 'TRUE';
VALUES: 'VALUES';
WHEN: 'WHEN';
WHERE: 'WHERE';

EQ  : '=';
NEQ : '<>' | '!=';
LT  : '<';
LTE : '<=';
GT  : '>';
GTE : '>=';

PLUS: '+';
MINUS: '-';
ASTERISK: '*';
SLASH: '/';
PERCENT: '%';
CONCAT: '||';

STRING
    : '\'' ( ~'\'' | '\'\'' )* '\''
    ;

UNICODE_STRING
    : 'U&\'' ( ~'\'' | '\'\'' )* '\''
    ;

// Note: we allow any character inside the binary literal and validate
// its a correct literal when the AST is being constructed. This
// allows us to provide more meaningful error messages to the user
BINARY_LITERAL
    :  'X\'' (~'\'')* '\''
    ;

INTEGER_VALUE
    : DIGIT+
    ;

DECIMAL_VALUE
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

DOUBLE_VALUE
    : DIGIT+ ('.' DIGIT*)? EXPONENT
    | '.' DIGIT+ EXPONENT
    ;

IDENTIFIER
    : (LETTER | '_') (LETTER | DIGIT | '_' | '@' | ':')*
    ;

DIGIT_IDENTIFIER
    : DIGIT (LETTER | DIGIT | '_' | '@' | ':')+
    ;

QUOTED_IDENTIFIER
    : '"' ( ~'"' | '""' )* '"'
    ;

BACKQUOTED_IDENTIFIER
    : '`' ( ~'`' | '``' )* '`'
    ;

TIME_WITH_TIME_ZONE
    : 'TIME' WS 'WITH' WS 'TIME' WS 'ZONE'
    ;

TIMESTAMP_WITH_TIME_ZONE
    : 'TIMESTAMP' WS 'WITH' WS 'TIME' WS 'ZONE'
    ;

DOUBLE_PRECISION
    : 'DOUBLE' WS 'PRECISION'
    ;

fragment EXPONENT
    : 'E' [+-]? DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [A-Z]
    ;

SIMPLE_COMMENT
    : '--' ~[\r\n]* '\r'? '\n'? -> channel(HIDDEN)
    ;

BRACKETED_COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;