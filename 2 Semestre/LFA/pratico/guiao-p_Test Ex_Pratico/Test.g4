grammar Test;

program: stat * EOF;

stat:   print 
      | assignment
      ;

assignment: ID ':'expr;

print: 'print' expr;

expr:   'input' '(' expr ')'            #ExprInput
      | expr '+' expr                   #ExprConcatenar
      | '(' expr '/' expr '/' expr')'   #ExprSubs
      | ID                              #ExprID
      | String                          #ExprString
      ;

String: '"'.*?'"';
ID: [A-Za-z0-9]+;
COMMENT: '#' .*? '\n'->skip;
WS: [ \t\r\n] ->skip;