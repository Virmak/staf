// Define a grammar

grammar Staf;

staf_file
    : suite_name? imports_section?  vars_section? keywords_section?  test_cases_section? EOF
    ;

suite_name
    : TEST_SUITE string
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
    : VARS var_declaration*
    ;

/*** Test cases section ***/
test_cases_section
    : TEST_CASES test_case_declaration*
    ;

test_case_declaration
    : keyword_name ':' statement* END
    ;

/*** End test cases ***/

/*** Keywords section ***/
keywords_section
    : KEYWORDS keyword_declaration*
    ;

keyword_declaration
    : keyword_name keyword_declaration_arguments
      keyword_body
      keyword_return_stat
    ;

keyword_body
    : statement*
    ;

statement
    : assignement
    | keyword_call
    | for_stat
    ;

keyword_call
    : keyword_name keyword_call_arguments?
    ;

keyword_call_arguments
    : '(' (object (',' object)*)? ')'
    ;

keyword_return_stat
    : RETURN object?
    ;

keyword_name
    : IDENTIFIER (SPACE* IDENTIFIER)*
    ;

keyword_declaration_arguments
    : '(' variable? (',' variable)* ')'?
    ;

/*** End keywords section ***/


var_declaration
    : variable
    | assignement
    ;

assignement
    : variable WS* '=' WS* object
    ;

for_stat
    : FOR variable IN object
      statement*
      END FOR
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
    : (primitive | variable | list_item_access | dictionaryLiteral | listLiteral| keyword_call)
    ;
primitive
    : string
    | bool
    | number
    ;

variable
    : (('${' IDENTIFIER ('.' IDENTIFIER)* '}' | '$' IDENTIFIER ('.' IDENTIFIER)*))
    ;

list_item_access
    : variable ('[' INT ']')
    ;


number
    : (INT | FLOAT)
    ;

string
    : SINGLE_STRING
    | DOUBLE_STRING
    ;

SINGLE_STRING
    : '\'' ~('\'')+ '\''
    ;

DOUBLE_STRING
    : '"' ~('"')+ '"'
    ;

bool
    : 'true'
    | 'false'
    ;


INT
    : [0-9]+
    ;

FLOAT
    : [0-9]+ '.' [0-9]+;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;

SPACE
    : [ \t] -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

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