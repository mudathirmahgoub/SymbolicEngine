grammar Smt;

// parser rules

model : '(' 'model' definitions* ')' ;

definitions : '(' 'define-fun' variable '(' ')' type  value ')';

variable : Identifier;

type : 'Int' | 'Bool';

value: Integer |  '(' '-' Integer ')';

// lexer rules
Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Integer : Digit+ ;

Digit : '0'..'9' ;

Whitespace :  [ \t\r\n]+ -> skip ;