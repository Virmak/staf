package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.RunKeywordIf;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
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
