grammar Calculator;

program: // main
	stat * EOF
   ;
stat: expr? NEWLINE
    |   print? NEWLINE
    |   assignment? NEWLINE
   ;
assignment: expr '->' ID;    //Atribution

print: 'print' expr;   //PrintFraction 

reduce: 'reduce ' expr ';'? ;  //reduceFraction

read: 'read "' ID '"';

expr:	
         expr op expr                       #ExprMultDivMod
       | expr op expr                       #ExprFraction
       | expr op expr                       #ExprAddSub
       | '(' expr ')'                       #ExprParent
       | '-' Integer                        #ExprNegativeNumber
       | reduce                             #ExprReduce
       | read                               #ExprRead
       | Integer                            #ExprInteger
       | ID                                 #ExprId	
       ;

op: ('*'|':'|'^'|'/'|'-'|'+');
Integer: [0-9]+; //implement with long integers
NEWLINE: '\r'? '\n';
ID: [a-zA-Z]+;
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
	