package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.Assignment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class VariableDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, Assignment>> {
    @Autowired
    private AssignmentVisitor assignmentVisitor;
    @Override
    public Map<String, Assignment> visitVars_section(StafParser.Vars_sectionContext ctx) {
        Map<String, Assignment> variablesMap = new HashMap<>();

        for (StafParser.AssignmentContext assignmentContext : ctx.assignment()) {
            Assignment assignment = assignmentVisitor.visitAssignment(assignmentContext);
            variablesMap.put(assignment.getLeftHandSide().getValue().toString(), assignment);
        }
        return variablesMap;
    }
}
