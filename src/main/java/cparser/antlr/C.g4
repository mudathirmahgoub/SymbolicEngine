// inspired by the example https://github.com/remenska/Grammars/blob/master/book-examples/examples/Cymbol.g4
// and https://github.com/antlr/grammars-v4/blob/master/tinyc/tinyc.g4

grammar C;

program : (functionDefinition | variableDefinition )+ ;

functionDefinition : type Identifier '(' arguments? ')' block;

variableDefinition : type Identifier ('=' expression)? ';';

arguments : argument (',' argument)*;

argument : type Identifier;

type: IntegerType | 'void' ;

block : '{' statement* '}';

statement
        : block
        | variableDefinition
        | If '(' expression ')' statement ('else' statement)?
        | 'return' expression? ';'
        | Identifier '=' expression ';'
        | functionCall ';'
        | PlusPlus Identifier ';'
        | Identifier PlusPlus ';'
        ;

expression
            : functionCall
            | expression '[' expression ']'
            | '-' expression
            | '!' expression
            | expression '*' expression
            | expression '/' expression
            | expression '%' expression
            | expression ('+'|'-') expression
            | expression '>' expression
            | expression '>=' expression
            | expression '<' expression
            | expression '<=' expression
            | expression '!=' expression
            | expression '==' expression
            | Identifier
            | Integer
            | BooleanConstant
            | '(' expression ')'
            ;

functionCall : Identifier '(' (expression (',' expression)*)? ')';


BooleanConstant : 'true' | 'false';

Break : 'break';
Case : 'case';
Char : 'char';
Const : 'const';
Continue : 'continue';

Do : 'do';
Double : 'double';
Else : 'else';
Enum : 'enum';


For : 'for';
Goto : 'goto';
If : 'if';

Long : 'long';


Return : 'return';
Short : 'short';
Signed : 'signed';
Sizeof : 'sizeof';

Struct : 'struct';
Switch : 'switch';

Unsigned : 'unsigned';
Void : 'void';

While : 'while';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
PlusPlus : '++';
Minus : '-';
MinusMinus : '--';
Star : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';
// '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='
StarAssign : '*=';
DivAssign : '/=';
ModAssign : '%=';
PlusAssign : '+=';
MinusAssign : '-=';
LeftShiftAssign : '<<=';
RightShiftAssign : '>>=';
AndAssign : '&=';
XorAssign : '^=';
OrAssign : '|=';

Equal : '==';
NotEqual : '!=';

Arrow : '->';
Dot : '.';

IntegerType : 'int';

Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Integer : Digit+ ;

Digit : '0'..'9' ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
