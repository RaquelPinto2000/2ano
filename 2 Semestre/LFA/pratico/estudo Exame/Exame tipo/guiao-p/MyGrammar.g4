grammar MyGrammar;

main: stat*EOF;

stat:    print
       | assigment
       ;
print:'print' expr;
assigment: ID ':' expr;

expr:    'input''('expr')'               #ExprInput
       | expr '+' expr                   #ExprConcatenate
       | '(' expr'/'expr'/'expr')'       #ExprReplace
       |  ID                             #ExprID
       | String                          #ExprString
       ;
String:'"'.*?'"';
ID: [a-zA-Z0-9]+;
COMMENT: '//'.*?'\n' ->skip;
WS:[ \t\r\n] -> skip;
ERRO: .;