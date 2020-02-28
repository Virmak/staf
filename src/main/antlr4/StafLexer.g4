// Define a grammar
lexer grammar StafLexer;

channels { WS_CHANNEL }

SINGLE_STRING
    : '\'' ~('\'')+ '\''
    ;

DOUBLE_STRING
    : '"' ~('"')+ '"'
    ;

EQUAL
    : '='
    ;

COMMA
    : ','
    ;

LPARENT : '(';

RPARENT : ')';

LBRACKET : '[';
RBRACKET : ']';
LBRACE : '{';
RBRACE : '}';

DOT : '.';
COLON : ':';

DOLLAR : '$';

TRUE : T R U E;
FALSE : F A L S E;

INT
    : [0-9]+
    ;

FLOAT
    : [0-9]+ '.' [0-9]+;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;

SPACE
    : [ \t]+ -> channel(WS_CHANNEL)
    ;

NL: ('\r\n' | '\r' | '\n') -> channel(WS_CHANNEL);

/**** RESERVED KEYWORDS ****/
IN
    :   I N
    ;

TEST_SUITE
    : T E S T SPACE* S U I T E SPACE*
    ;

IMPORTS
    : I M P O R T S
    ;

IMPORT
    : I M P O R T
    ;

VARS
    : V A R S
    ;

KEYWORDS
    : K E Y W O R D S
    ;

TEST_CASES
    : T E S T SPACE* C A S E S
    ;

BEGIN
    : B E G I N
    ;

END
    : E N D
    ;

RETURN
    : R E T U R N
    ;

FOR
    : F O R
    ;

ENDFOR
    : E N D F O R
    ;

NULL
    : N U L L
    ;

GIVEN
    : G I V E N
    ;
WHEN
    : W H E N
    ;
THEN
    : T H E N
    ;

IDENTIFIER
    : [A-Za-z0-9]+
    ;



fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');