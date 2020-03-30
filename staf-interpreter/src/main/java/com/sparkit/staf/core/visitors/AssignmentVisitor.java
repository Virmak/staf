package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.Assignment;

public class AssignmentVisitor extends StafBaseVisitor<Assignment> {
    @Override
    public Assignment visitAssignment(StafParser.AssignmentContext ctx) {
        AbstractStafObject obj = new VariableReferenceVisitor().visitVariable_reference(ctx.variable_reference());
        AbstractStafObject val = new StafObjectVisitor().visitObject(ctx.object());
        return new Assignment(obj, val);
    }
}
