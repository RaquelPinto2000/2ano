grammar Calculator;

program: // main
	stat * EOF
   ;
stat:
	  expr? NEWLINE
	| assignment? NEWLINE
   ;
assignment: ID '=' expr;

expr:
	 expr op=('*'|'/'|'%') expr     #ExprMultDivMod
       | expr op=('+'|'-') expr         #ExprAddSub
       | Integer                        #ExprInteger
       | '(' expr ')'                   #ExprParent
       | '-' Integer                    #ExprNegativeNumber
       | ID                             # ExprId	
       ;
Integer: [0-9]+; //implement with long integers
NEWLINE: '\r'? '\n';
ID: [a-zA-Z]+;
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
	