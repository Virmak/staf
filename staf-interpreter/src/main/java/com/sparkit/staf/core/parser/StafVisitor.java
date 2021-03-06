// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.core.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StafParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StafVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StafParser#staf_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaf_file(StafParser.Staf_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#suite_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite_name(StafParser.Suite_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#documentation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentation(StafParser.DocumentationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#imports_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports_section(StafParser.Imports_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#import_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stat(StafParser.Import_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#import_obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_obj(StafParser.Import_objContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#vars_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars_section(StafParser.Vars_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#test_cases_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_cases_section(StafParser.Test_cases_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#test_case_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_case_declaration(StafParser.Test_case_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#test_case_before}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_case_before(StafParser.Test_case_beforeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#test_case_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_case_body(StafParser.Test_case_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#test_case_priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_case_priority(StafParser.Test_case_priorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keywords_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords_section(StafParser.Keywords_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_declaration(StafParser.Keyword_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_body(StafParser.Keyword_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(StafParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#run_keyword_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun_keyword_if(StafParser.Run_keyword_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#run_keyword_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun_keyword_else(StafParser.Run_keyword_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#exit_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_loop(StafParser.Exit_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#exit_loop_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_loop_condition(StafParser.Exit_loop_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_call(StafParser.Keyword_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_call_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_call_arguments(StafParser.Keyword_call_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_return_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_return_stat(StafParser.Keyword_return_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_name(StafParser.Keyword_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#reserved_keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReserved_keyword(StafParser.Reserved_keywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyword_declaration_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword_declaration_arguments(StafParser.Keyword_declaration_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(StafParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#for_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stat(StafParser.For_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#for_stat_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stat_body(StafParser.For_stat_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(StafParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryLiteral(StafParser.DictionaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePair(StafParser.KeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(StafParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#complex_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex_object(StafParser.Complex_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#scalar_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar_object(StafParser.Scalar_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#variable_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_reference(StafParser.Variable_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(StafParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(StafParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#dot_item_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_item_access(StafParser.Dot_item_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#brackets_item_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackets_item_access(StafParser.Brackets_item_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(StafParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(StafParser.MulopContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(StafParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(StafParser.BinopContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(StafParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(StafParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link StafParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(StafParser.BoolContext ctx);
}