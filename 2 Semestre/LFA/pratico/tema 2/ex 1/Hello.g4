grammar Hello; // define a gramatica called Hello 
main  : top*EOf; // para o final da alinea e -> so responde no final da entrada dos argumentos todos
top : greetings | bye ;
greetings : 'hello' name ; // match keyword hello followed by an identifier
bye : 'goodbye' name;
name : ID+;

ID : [a-z]+ ; // match lower-case identifiers
WS : [ \t\r\n]+ -> skip  ; // skip spaces, tabs , newlines, \r (Windows)
