parser grammar StafParser;
options { tokenVocab=StafLexer; }

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
    : VARS assignment*
    ;

/*** Test cases section ***/
test_cases_section
    : TEST_CASES test_case_declaration*
    ;

test_case_declaration
    : keyword_name ':' test_case_body END
    ;

test_case_body
    : statement*
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
    : (GIVEN | WHEN | THEN)? (assignment | keyword_call | for_stat)
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
    : LPARENT variable? (COMMA variable)* RPARENT?
    ;

/*** End keywords section ***/

assignment
    : variable_reference EQUAL (object | NULL)
    ;

for_stat
    : FOR variable IN object
      for_stat_body
      END FOR
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
    : (primitive | variable_reference | dictionaryLiteral | listLiteral| keyword_call)
    ;

variable_reference
    : variable | list_item_access | dictionary_item_access
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
    : variable ('[' object ']')
    ;

dictionary_item_access
    :   variable ('.' IDENTIFIER)+
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
