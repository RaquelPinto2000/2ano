grammar Calculator;
 
main: stat* EOF;

stat:   print
      | assigment
      ;

print: 'print' expr ';';
assigment: expr '->' ID ';';

expr:     <assoc=right> expr ('^') expr       #ExprPow
        | expr op = ('*'|':') expr            #ExprMulDiv
        | expr op= ('+'|'-') expr             #ExprAddSub
        | '(' expr ')'                        #ExprParent
        | 'reduce' expr  ';'?                 #ExprReduce
        | Number '/' Number                   #ExprFrac
        | 'read' '"' ler=(ID|String) '"' ';'? #ExprRead
        | Number                              #ExprNumber
        | signal=('+'|'-') expr               #ExprPosNeg
        | ID                                  #ExprID
        ;

Number: [0-9]+;
ID: [a-zA-Z]+;
String:'"' .*? '"';
WS: [ \t\r\n]+ ->skip;
COMMENT: '//'.*? '\n' -> skip;
ERRO: .;