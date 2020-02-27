package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.Assignment;

import java.util.HashMap;
import java.util.Map;

public class VariableDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, Assignment>> {
    @Override
    public Map<String, Assignment> visitVars_section(StafParser.Vars_sectionContext ctx) {
        Map<String, Assignment> vars = new HashMap<>();

        for (StafParser.AssignmentContext assignmentContext : ctx.assignment()) {
            Assignment assignment = new AssignmentVisitor().visitAssignment(assignmentContext);
            vars.put(assignment.getObject().getValue().toString(), assignment);
        }
        return vars;
    }
}
