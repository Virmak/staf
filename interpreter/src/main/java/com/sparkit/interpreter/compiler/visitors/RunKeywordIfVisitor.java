package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.RunKeywordIf;
import com.sparkit.interpreter.compiler.ast.statement.KeywordCall;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class RunKeywordIfVisitor extends StafBaseVisitor<RunKeywordIf> {
    @Autowired
    private ExpressionVisitor expressionVisitor;
    @Autowired
    private KeywordCallVisitor keywordCallVisitor;

    @Override
    public RunKeywordIf visitRun_keyword_if(StafParser.Run_keyword_ifContext ctx) {
        StafParser.ExpressionContext expressionContext = ctx.expression();
        AbstractStafObject conditionExpression = expressionVisitor.visitExpression(expressionContext);
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        KeywordCall keywordCall = keywordCallVisitor.visitKeyword_call(keywordCallContext);
        return new RunKeywordIf(conditionExpression, keywordCall);
    }
}
