package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.ForStatement;
import com.sparkit.staf.ast.StafVariable;

public class ForStatementVisitor extends StafBaseVisitor<ForStatement> {
    @Override
    public ForStatement visitFor_stat(StafParser.For_statContext ctx) {
        ForStatement forStatement = new ForStatement();
        forStatement.setVar(new StafVariable(ctx.variable().getText(), null));

        StafParser.Complex_objectContext complexObjectContext = ctx.complex_object();
        if (complexObjectContext != null) {
            forStatement.setIterator(new ComplexObjectVisitor().visitComplex_object(complexObjectContext));
        } else {
            forStatement.setIterator(new VariableReferenceVisitor().visitVariable_reference(ctx.variable_reference()));
        }
        forStatement.setStatementList(new ForStatementBodyVisitor().visitFor_stat_body(ctx.for_stat_body()));
        return forStatement;
    }
}
