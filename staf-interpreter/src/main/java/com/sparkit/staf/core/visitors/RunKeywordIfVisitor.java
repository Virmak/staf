package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.RunKeywordIf;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

public class RunKeywordIfVisitor extends StafBaseVisitor<RunKeywordIf> {
    @Override
    public RunKeywordIf visitRun_keyword_if(StafParser.Run_keyword_ifContext ctx) {
        StafParser.ExpressionContext expressionContext = ctx.expression();
        AbstractStafObject conditionExpression = new ExpressionVisitor().visitExpression(expressionContext);
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        KeywordCall keywordCall = new KeywordCallVisitor().visitKeyword_call(keywordCallContext);
        return new RunKeywordIf(conditionExpression, keywordCall);
    }
}
