package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
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
