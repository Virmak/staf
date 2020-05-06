package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class AssignmentVisitor extends StafBaseVisitor<Assignment> {
    @Autowired
    private VariableReferenceVisitor variableReferenceVisitor;
    @Autowired
    private StafObjectVisitor stafObjectVisitor;

    @Override
    public Assignment visitAssignment(StafParser.AssignmentContext ctx) {
        AbstractStafObject obj = variableReferenceVisitor.visitVariable_reference(ctx.variable_reference());
        AbstractStafObject val = stafObjectVisitor.visitObject(ctx.object());
        return new Assignment(obj, val);
    }
}
