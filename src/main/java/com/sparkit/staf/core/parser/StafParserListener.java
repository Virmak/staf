// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.core.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StafParserParser}.
 */
public interface StafParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StafParserParser#staf_file}.
	 * @param ctx the parse tree
	 */
	void enterStaf_file(StafParserParser.Staf_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#staf_file}.
	 * @param ctx the parse tree
	 */
	void exitStaf_file(StafParserParser.Staf_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#suite_name}.
	 * @param ctx the parse tree
	 */
	void enterSuite_name(StafParserParser.Suite_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#suite_name}.
	 * @param ctx the parse tree
	 */
	void exitSuite_name(StafParserParser.Suite_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#imports_section}.
	 * @param ctx the parse tree
	 */
	void enterImports_section(StafParserParser.Imports_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#imports_section}.
	 * @param ctx the parse tree
	 */
	void exitImports_section(StafParserParser.Imports_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#import_stat}.
	 * @param ctx the parse tree
	 */
	void enterImport_stat(StafParserParser.Import_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#import_stat}.
	 * @param ctx the parse tree
	 */
	void exitImport_stat(StafParserParser.Import_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#import_obj}.
	 * @param ctx the parse tree
	 */
	void enterImport_obj(StafParserParser.Import_objContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#import_obj}.
	 * @param ctx the parse tree
	 */
	void exitImport_obj(StafParserParser.Import_objContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#vars_section}.
	 * @param ctx the parse tree
	 */
	void enterVars_section(StafParserParser.Vars_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#vars_section}.
	 * @param ctx the parse tree
	 */
	void exitVars_section(StafParserParser.Vars_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#test_cases_section}.
	 * @param ctx the parse tree
	 */
	void enterTest_cases_section(StafParserParser.Test_cases_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#test_cases_section}.
	 * @param ctx the parse tree
	 */
	void exitTest_cases_section(StafParserParser.Test_cases_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#test_case_declaration}.
	 * @param ctx the parse tree
	 */
	void enterTest_case_declaration(StafParserParser.Test_case_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#test_case_declaration}.
	 * @param ctx the parse tree
	 */
	void exitTest_case_declaration(StafParserParser.Test_case_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#test_case_body}.
	 * @param ctx the parse tree
	 */
	void enterTest_case_body(StafParserParser.Test_case_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#test_case_body}.
	 * @param ctx the parse tree
	 */
	void exitTest_case_body(StafParserParser.Test_case_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keywords_section}.
	 * @param ctx the parse tree
	 */
	void enterKeywords_section(StafParserParser.Keywords_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keywords_section}.
	 * @param ctx the parse tree
	 */
	void exitKeywords_section(StafParserParser.Keywords_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_declaration}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_declaration(StafParserParser.Keyword_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_declaration}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_declaration(StafParserParser.Keyword_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_body}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_body(StafParserParser.Keyword_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_body}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_body(StafParserParser.Keyword_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(StafParserParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(StafParserParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_call}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_call(StafParserParser.Keyword_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_call}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_call(StafParserParser.Keyword_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_call_arguments}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_call_arguments(StafParserParser.Keyword_call_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_call_arguments}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_call_arguments(StafParserParser.Keyword_call_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_return_stat}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_return_stat(StafParserParser.Keyword_return_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_return_stat}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_return_stat(StafParserParser.Keyword_return_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_name}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_name(StafParserParser.Keyword_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_name}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_name(StafParserParser.Keyword_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyword_declaration_arguments}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_declaration_arguments(StafParserParser.Keyword_declaration_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyword_declaration_arguments}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_declaration_arguments(StafParserParser.Keyword_declaration_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(StafParserParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(StafParserParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#for_stat}.
	 * @param ctx the parse tree
	 */
	void enterFor_stat(StafParserParser.For_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#for_stat}.
	 * @param ctx the parse tree
	 */
	void exitFor_stat(StafParserParser.For_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#for_stat_body}.
	 * @param ctx the parse tree
	 */
	void enterFor_stat_body(StafParserParser.For_stat_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#for_stat_body}.
	 * @param ctx the parse tree
	 */
	void exitFor_stat_body(StafParserParser.For_stat_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(StafParserParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(StafParserParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictionaryLiteral(StafParserParser.DictionaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictionaryLiteral(StafParserParser.DictionaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValuePair(StafParserParser.KeyValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValuePair(StafParserParser.KeyValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(StafParserParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(StafParserParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#variable_reference}.
	 * @param ctx the parse tree
	 */
	void enterVariable_reference(StafParserParser.Variable_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#variable_reference}.
	 * @param ctx the parse tree
	 */
	void exitVariable_reference(StafParserParser.Variable_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(StafParserParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(StafParserParser.PrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(StafParserParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(StafParserParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#list_item_access}.
	 * @param ctx the parse tree
	 */
	void enterList_item_access(StafParserParser.List_item_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#list_item_access}.
	 * @param ctx the parse tree
	 */
	void exitList_item_access(StafParserParser.List_item_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#dictionary_item_access}.
	 * @param ctx the parse tree
	 */
	void enterDictionary_item_access(StafParserParser.Dictionary_item_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#dictionary_item_access}.
	 * @param ctx the parse tree
	 */
	void exitDictionary_item_access(StafParserParser.Dictionary_item_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(StafParserParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(StafParserParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(StafParserParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(StafParserParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParserParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(StafParserParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParserParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(StafParserParser.BoolContext ctx);
}