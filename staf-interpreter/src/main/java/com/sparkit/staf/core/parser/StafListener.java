// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.core.parser;
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
	 * Enter a parse tree produced by {@link StafParser#documentation}.
	 * @param ctx the parse tree
	 */
	void enterDocumentation(StafParser.DocumentationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#documentation}.
	 * @param ctx the parse tree
	 */
	void exitDocumentation(StafParser.DocumentationContext ctx);
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
	 * Enter a parse tree produced by {@link StafParser#test_case_before}.
	 * @param ctx the parse tree
	 */
	void enterTest_case_before(StafParser.Test_case_beforeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#test_case_before}.
	 * @param ctx the parse tree
	 */
	void exitTest_case_before(StafParser.Test_case_beforeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#test_case_body}.
	 * @param ctx the parse tree
	 */
	void enterTest_case_body(StafParser.Test_case_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#test_case_body}.
	 * @param ctx the parse tree
	 */
	void exitTest_case_body(StafParser.Test_case_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#test_case_priority}.
	 * @param ctx the parse tree
	 */
	void enterTest_case_priority(StafParser.Test_case_priorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#test_case_priority}.
	 * @param ctx the parse tree
	 */
	void exitTest_case_priority(StafParser.Test_case_priorityContext ctx);
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
	 * Enter a parse tree produced by {@link StafParser#run_keyword_if}.
	 * @param ctx the parse tree
	 */
	void enterRun_keyword_if(StafParser.Run_keyword_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#run_keyword_if}.
	 * @param ctx the parse tree
	 */
	void exitRun_keyword_if(StafParser.Run_keyword_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#run_keyword_else}.
	 * @param ctx the parse tree
	 */
	void enterRun_keyword_else(StafParser.Run_keyword_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#run_keyword_else}.
	 * @param ctx the parse tree
	 */
	void exitRun_keyword_else(StafParser.Run_keyword_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#exit_loop}.
	 * @param ctx the parse tree
	 */
	void enterExit_loop(StafParser.Exit_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#exit_loop}.
	 * @param ctx the parse tree
	 */
	void exitExit_loop(StafParser.Exit_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#exit_loop_condition}.
	 * @param ctx the parse tree
	 */
	void enterExit_loop_condition(StafParser.Exit_loop_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#exit_loop_condition}.
	 * @param ctx the parse tree
	 */
	void exitExit_loop_condition(StafParser.Exit_loop_conditionContext ctx);
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
	 * Enter a parse tree produced by {@link StafParser#reserved_keyword}.
	 * @param ctx the parse tree
	 */
	void enterReserved_keyword(StafParser.Reserved_keywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#reserved_keyword}.
	 * @param ctx the parse tree
	 */
	void exitReserved_keyword(StafParser.Reserved_keywordContext ctx);
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
	 * Enter a parse tree produced by {@link StafParser#for_stat_body}.
	 * @param ctx the parse tree
	 */
	void enterFor_stat_body(StafParser.For_stat_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#for_stat_body}.
	 * @param ctx the parse tree
	 */
	void exitFor_stat_body(StafParser.For_stat_bodyContext ctx);
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
	 * Enter a parse tree produced by {@link StafParser#complex_object}.
	 * @param ctx the parse tree
	 */
	void enterComplex_object(StafParser.Complex_objectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#complex_object}.
	 * @param ctx the parse tree
	 */
	void exitComplex_object(StafParser.Complex_objectContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#scalar_object}.
	 * @param ctx the parse tree
	 */
	void enterScalar_object(StafParser.Scalar_objectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#scalar_object}.
	 * @param ctx the parse tree
	 */
	void exitScalar_object(StafParser.Scalar_objectContext ctx);
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
	 * Enter a parse tree produced by {@link StafParser#dot_item_access}.
	 * @param ctx the parse tree
	 */
	void enterDot_item_access(StafParser.Dot_item_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#dot_item_access}.
	 * @param ctx the parse tree
	 */
	void exitDot_item_access(StafParser.Dot_item_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#brackets_item_access}.
	 * @param ctx the parse tree
	 */
	void enterBrackets_item_access(StafParser.Brackets_item_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#brackets_item_access}.
	 * @param ctx the parse tree
	 */
	void exitBrackets_item_access(StafParser.Brackets_item_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(StafParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(StafParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(StafParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(StafParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(StafParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(StafParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link StafParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(StafParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link StafParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(StafParser.BinopContext ctx);
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