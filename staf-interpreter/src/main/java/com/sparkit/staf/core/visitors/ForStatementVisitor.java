package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.ForStatement;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import org.springframework.beans.factory.annotation.Autowired;

public class ForStatementVisitor extends StafBaseVisitor<ForStatement> {

    @Autowired
    private ComplexObjectVisitor complexObjectVisitor;
    @Autowired
    private VariableReferenceVisitor variableReferenceVisitor;
    @Autowired
    private KeywordCallVisitor keywordCallVisitor;
    @Autowired
    private ForStatementBodyVisitor forStatementBodyVisitor;
    @Autowired
    private StatementBlockExecutor blockExecutor;

    @Override
    public ForStatement visitFor_stat(StafParser.For_statContext ctx) {
        ForStatement forStatement = new ForStatement(blockExecutor);
        forStatement.setLoopVariable(new StafVariable(ctx.variable().getText()));

        StafParser.Complex_objectContext complexObjectContext = ctx.complex_object();
        StafParser.Variable_referenceContext variableReferenceContext = ctx.variable_reference();
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        if (complexObjectContext != null) {
            forStatement.setIterator(complexObjectVisitor.visitComplex_object(complexObjectContext));
        } else if (variableReferenceContext != null) {
            forStatement.setIterator(variableReferenceVisitor.visitVariable_reference(variableReferenceContext));
        } else if (keywordCallContext != null) {
            forStatement.setIterator(keywordCallVisitor.visitKeyword_call(keywordCallContext));
        }

        forStatement.setStatements(forStatementBodyVisitor.visitFor_stat_body(ctx.for_stat_body()));
        return forStatement;
    }
}
