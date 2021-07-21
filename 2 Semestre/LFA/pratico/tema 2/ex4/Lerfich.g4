grammar Lerfich;

program: // main
	line * EOF
    ;
line:   
	expr? NEWLINE
    ;
expr : 
	Integer ('-') Word # ReadLine
    ;

Integer: [0-9]+;
Word: [a-zA-Z]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;