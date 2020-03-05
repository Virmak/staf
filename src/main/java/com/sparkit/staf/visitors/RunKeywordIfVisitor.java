package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.RunKeywordIf;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.types.KeywordCall;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;

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
