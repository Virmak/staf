// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StafParser}.
 */
public interface StafListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StafParser#staf_file}.
	 * @param ctx the parse tree
	 */
	void enterStaf_file(StafParser.Staf_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#staf_file}.
	 * @param ctx the parse tree
	 */
	void exitStaf_file(StafParser.Staf_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#suite_name}.
	 * @param ctx the parse tree
	 */
	void enterSuite_name(StafParser.Suite_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#suite_name}.
	 * @param ctx the parse tree
	 */
	void exitSuite_name(StafParser.Suite_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#imports_section}.
	 * @param ctx the parse tree
	 */
	void enterImports_section(StafParser.Imports_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#imports_section}.
	 * @param ctx the parse tree
	 */
	void exitImports_section(StafParser.Imports_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#import_stat}.
	 * @param ctx the parse tree
	 */
	void enterImport_stat(StafParser.Import_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#import_stat}.
	 * @param ctx the parse tree
	 */
	void exitImport_stat(StafParser.Import_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#import_obj}.
	 * @param ctx the parse tree
	 */
	void enterImport_obj(StafParser.Import_objContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#import_obj}.
	 * @param ctx the parse tree
	 */
	void exitImport_obj(StafParser.Import_objContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#vars_section}.
	 * @param ctx the parse tree
	 */
	void enterVars_section(StafParser.Vars_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#vars_section}.
	 * @param ctx the parse tree
	 */
	void exitVars_section(StafParser.Vars_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#test_cases_section}.
	 * @param ctx the parse tree
	 */
	void enterTest_cases_section(StafParser.Test_cases_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#test_cases_section}.
	 * @param ctx the parse tree
	 */
	void exitTest_cases_section(StafParser.Test_cases_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#test_case_declaration}.
	 * @param ctx the parse tree
	 */
	void enterTest_case_declaration(StafParser.Test_case_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#test_case_declaration}.
	 * @param ctx the parse tree
	 */
	void exitTest_case_declaration(StafParser.Test_case_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keywords_section}.
	 * @param ctx the parse tree
	 */
	void enterKeywords_section(StafParser.Keywords_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keywords_section}.
	 * @param ctx the parse tree
	 */
	void exitKeywords_section(StafParser.Keywords_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_declaration}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_declaration(StafParser.Keyword_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_declaration}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_declaration(StafParser.Keyword_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_body}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_body(StafParser.Keyword_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_body}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_body(StafParser.Keyword_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(StafParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(StafParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_call}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_call(StafParser.Keyword_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_call}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_call(StafParser.Keyword_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_call_arguments}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_call_arguments(StafParser.Keyword_call_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_call_arguments}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_call_arguments(StafParser.Keyword_call_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_return_stat}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_return_stat(StafParser.Keyword_return_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_return_stat}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_return_stat(StafParser.Keyword_return_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_name}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_name(StafParser.Keyword_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_name}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_name(StafParser.Keyword_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyword_declaration_arguments}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_declaration_arguments(StafParser.Keyword_declaration_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyword_declaration_arguments}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_declaration_arguments(StafParser.Keyword_declaration_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(StafParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(StafParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#for_stat}.
	 * @param ctx the parse tree
	 */
	void enterFor_stat(StafParser.For_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#for_stat}.
	 * @param ctx the parse tree
	 */
	void exitFor_stat(StafParser.For_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(StafParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(StafParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictionaryLiteral(StafParser.DictionaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictionaryLiteral(StafParser.DictionaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValuePair(StafParser.KeyValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValuePair(StafParser.KeyValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(StafParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(StafParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#variable_reference}.
	 * @param ctx the parse tree
	 */
	void enterVariable_reference(StafParser.Variable_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#variable_reference}.
	 * @param ctx the parse tree
	 */
	void exitVariable_reference(StafParser.Variable_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(StafParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(StafParser.PrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(StafParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(StafParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#list_item_access}.
	 * @param ctx the parse tree
	 */
	void enterList_item_access(StafParser.List_item_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#list_item_access}.
	 * @param ctx the parse tree
	 */
	void exitList_item_access(StafParser.List_item_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#dictionary_item_access}.
	 * @param ctx the parse tree
	 */
	void enterDictionary_item_access(StafParser.Dictionary_item_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#dictionary_item_access}.
	 * @param ctx the parse tree
	 */
	void exitDictionary_item_access(StafParser.Dictionary_item_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(StafParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(StafParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(StafParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(StafParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(StafParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(StafParser.BoolContext ctx);
}