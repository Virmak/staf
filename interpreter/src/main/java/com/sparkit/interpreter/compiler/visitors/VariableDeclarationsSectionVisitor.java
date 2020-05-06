package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class VariableDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, Assignment>> {
    @Autowired
    private AssignmentVisitor assignmentVisitor;
    @Override
    public Map<String, Assignment> visitVars_section(StafParser.Vars_sectionContext ctx) {
        Map<String, Assignment> vars = new HashMap<>();

        for (StafParser.AssignmentContext assignmentContext : ctx.assignment()) {
            Assignment assignment = assignmentVisitor.visitAssignment(assignmentContext);
            vars.put(assignment.getObject().getValue().toString(), assignment);
        }
        return vars;
    }
}
