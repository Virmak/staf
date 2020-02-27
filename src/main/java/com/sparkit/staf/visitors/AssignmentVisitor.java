package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.Assignment;
import com.sparkit.staf.types.StafObject;

public class AssignmentVisitor extends StafBaseVisitor<Assignment> {
    @Override
    public Assignment visitAssignment(StafParser.AssignmentContext ctx) {
        StafObject obj = new VariableReferenceVisitor().visitVariable_reference(ctx.variable_reference());
        StafObject val = new StafObjectVisitor().visitObject(ctx.object());
        return new Assignment(obj, val);
    }
}
