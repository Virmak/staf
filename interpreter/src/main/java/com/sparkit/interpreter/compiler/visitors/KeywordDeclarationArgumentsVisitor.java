package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;

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
