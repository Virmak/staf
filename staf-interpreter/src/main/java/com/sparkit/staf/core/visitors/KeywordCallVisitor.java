package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class KeywordCallVisitor extends StafBaseVisitor<KeywordCall> {
    @Autowired
    private KeywordCallArgumentsVisitor keywordCallArgumentsVisitor;
    @Autowired
    private StafFileVisitor stafFileVisitor;

    @Override
    public KeywordCall visitKeyword_call(StafParser.Keyword_callContext ctx) {
        KeywordCall keywordCall = new KeywordCall();
        keywordCall.setFile(stafFileVisitor.getFilePath());
        keywordCall.setLineNumber(ctx.getStart().getLine());
        keywordCall.setKeywordName(ctx.keyword_name().getText().toLowerCase().replaceAll(" ", ""));
        StafParser.Keyword_call_argumentsContext keywordCallContext = ctx.keyword_call_arguments();
        if (keywordCallContext != null) {
            keywordCall.setArgumentsList(keywordCallArgumentsVisitor.visitKeyword_call_arguments(ctx.keyword_call_arguments()));
        }
        return keywordCall;
    }
}
