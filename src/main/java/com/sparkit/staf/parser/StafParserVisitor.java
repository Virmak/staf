// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StafParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StafParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StafParserParser#staf_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaf_file(StafParserParser.Staf_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#suite_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite_name(StafParserParser.Suite_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#imports_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports_section(StafParserParser.Imports_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#import_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stat(StafParserParser.Import_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#import_obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_obj(StafParserParser.Import_objContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#vars_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars_section(StafParserParser.Vars_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#test_cases_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_cases_section(StafParserParser.Test_cases_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#test_case_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_case_declaration(StafParserParser.Test_case_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#test_case_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_case_body(StafParserParser.Test_case_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keywords_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords_section(StafParserParser.Keywords_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_declaration(StafParserParser.Keyword_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_body(StafParserParser.Keyword_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(StafParserParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_call(StafParserParser.Keyword_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_call_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_call_arguments(StafParserParser.Keyword_call_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_return_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_return_stat(StafParserParser.Keyword_return_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_name(StafParserParser.Keyword_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyword_declaration_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_declaration_arguments(StafParserParser.Keyword_declaration_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(StafParserParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#for_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stat(StafParserParser.For_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#for_stat_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stat_body(StafParserParser.For_stat_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(StafParserParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryLiteral(StafParserParser.DictionaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePair(StafParserParser.KeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(StafParserParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#variable_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_reference(StafParserParser.Variable_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(StafParserParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(StafParserParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#list_item_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_item_access(StafParserParser.List_item_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#dictionary_item_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionary_item_access(StafParserParser.Dictionary_item_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(StafParserParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(StafParserParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParserParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(StafParserParser.BoolContext ctx);
}