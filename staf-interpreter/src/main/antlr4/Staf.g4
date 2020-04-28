grammar Staf;


staf_file
    : suite_name? imports_section?  vars_section? keywords_section?  test_cases_section? EOF
    ;

suite_name
    : TEST_SUITE string documentation?
    ;
documentation
    : '[' .*? ']'
    ;
imports_section
    : IMPORTS import_stat*
    ;

import_stat
    : IMPORT import_obj
    ;
import_obj
    : (string | IDENTIFIER)
    ;

vars_section
    : VARS assignment*
    ;

// Test cases section ***/
test_cases_section
    : TEST_CASES test_case_declaration*
    ;

test_case_declaration
    : keyword_name ':' documentation? test_case_body END
    ;

test_case_body
    : ((GIVEN | WHEN | THEN | 'AND')? statement)*
    ;
// End test cases ***/

// Keywords section ***/
keywords_section
    : KEYWORDS keyword_declaration*
    ;

keyword_declaration
    : keyword_name keyword_declaration_arguments
      documentation?
      keyword_body
      keyword_return_stat
    ;

keyword_body
    : statement*
    ;

statement
    : (assignment | keyword_call | for_stat | run_keyword_if|exit_loop)
    ;

run_keyword_if
    : RUN KEYWORD IF LPARENT expression RPARENT keyword_call
    ;

exit_loop
    :   EXIT LOOP
    ;

keyword_call
    : keyword_name keyword_call_arguments
    ;

keyword_call_arguments
    : '(' (object (',' object)*)? ')'
    ;

keyword_return_stat
    : (RETURN object) | END
    ;

keyword_name
    : IDENTIFIER (IDENTIFIER)*
    ;

keyword_declaration_arguments
    : LPARENT (variable (COMMA variable)*)? RPARENT
    ;

// End keywords section ***/

assignment
    : variable_reference EQUAL (object | NULL)
    ;

for_stat
    : FOR variable ':' (complex_object | variable_reference | keyword_call)
      for_stat_body
      ENDFOR
    ;

for_stat_body
    : statement*
    ;

listLiteral
    : '[' (object (',' object)*)? ']'
    ;

dictionaryLiteral
    : '{' (keyValuePair (',' keyValuePair)*)? '}'
    ;

keyValuePair
    : (IDENTIFIER | string) ':' object
    ;

object
    : complex_object | scalar_object | expression
    ;

complex_object
    : ( dictionaryLiteral | listLiteral)
    ;

scalar_object
    : (primitive | variable_reference | keyword_call)
    ;

variable_reference
    : variable (list_item_access | dictionary_item_access)*
    ;

primitive
    : string
    | bool
    | number
    ;

variable
    : '$' IDENTIFIER
    ;

list_item_access
    : LBRACKET expression RBRACKET
    ;

dictionary_item_access
    :  DOT IDENTIFIER
    ;

expression
    : (MINUS | NOT) expression
    | expression mulop expression
    | expression addop expression
    | expression binop expression
    | LPARENT expression RPARENT
    | scalar_object
    ;

mulop
    : MUL | DIV | MOD
    ;
addop
    : PLUS | MINUS
    ;

binop
    : AND_OP | OR | EQUAL EQUAL | LT | GT | LTE | GTE | NE
    ;

number
    : (INT | FLOAT)
    ;

string
    : SINGLE_STRING
    | DOUBLE_STRING
    ;



bool
    : TRUE
    | FALSE
    ;



SINGLE_STRING
    : '\'' ~('\'')* '\''
    ;

DOUBLE_STRING
    : '"' ~('"')* '"'
    ;

EQUAL
    : '='
    ;

COMMA
    : ','
    ;

RUN: R U N;
KEYWORD: K E Y W O R D;
IF : I F;

PLUS    : '+' ;
MINUS   : '-' ;
MUL     : '*' ;
DIV     : '/' ;
MOD     : '%' ;
LT      : '<' ;
GT      : '>' ;
LTE     : '<=';
GTE     : '>=';
NE      : '!=';
NOT     : '!';
AND_OP  : '&';
OR      : O R;

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
    : [ \t]+ -> skip
    ;

NL: ('\r\n' | '\r' | '\n') -> skip;

// RESERVED KEYWORDS

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
    : [A-Za-z0-9_]+
    ;
LOOP : L O O P;
EXIT : E X I T;



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