

grammar SuffixCalculator;
program: 
	stat * EOF  //Zero or more repetitions of stat   (da print da gramatica)
	;
stat:
	expr? NEWLINE // Optative expr
	;
	
	// ter expr: expr(e o 1 operando) espr(e o segundo operando) op e parecido a ter x = x(0) + x(1); como uma variavel = variavel + qualquer coisa
expr:
	expr expr op=('*'|'/'|'+'|'-')  #ExprSuffix // calcula a conta
	| Number						#ExprNumber // devolve o valor da
	;
Number : [0-9]+('.'[0-9]+)?;
NEWLINE : '\r'? '\n';
WS:  [ \t] + -> skip;


