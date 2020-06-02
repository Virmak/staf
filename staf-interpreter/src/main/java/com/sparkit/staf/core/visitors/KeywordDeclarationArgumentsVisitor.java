package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

import java.util.ArrayList;
import java.util.List;

public class KeywordDeclarationArgumentsVisitor extends StafBaseVisitor<List<String>> {
    @Override
    public List<String> visitKeyword_declaration_arguments(StafParser.Keyword_declaration_argumentsContext ctx) {
        List<String> arguments = new ArrayList<>();
        for (StafParser.VariableContext variableContext: ctx.variable()) {
            arguments.add(variableContext.getText());
        }
        return arguments;
    }
}
