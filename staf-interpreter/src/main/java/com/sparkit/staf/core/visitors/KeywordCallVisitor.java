package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.TokenPosition;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class KeywordCallVisitor extends StafBaseVisitor<KeywordCall> {
    @Autowired
    private KeywordCallArgumentsVisitor keywordCallArgumentsVisitor;
    @Autowired
    private StafFileVisitor stafFileVisitor;
    @Autowired
    private StatementBlockExecutor blockExecutor;

    @Override
    public KeywordCall visitKeyword_call(StafParser.Keyword_callContext ctx) {
        KeywordCall keywordCall = new KeywordCall(blockExecutor);
        String keywordNameWithSpaces = ctx.keyword_name().IDENTIFIER().stream().map(ParseTree::getText)
                .collect(Collectors.joining(" "));
        keywordCall.setKeywordName(keywordNameWithSpaces);
        TokenPosition tokenPosition = new TokenPosition(
                ctx.keyword_name().getStart().getLine(),
                ctx.keyword_name().getStart().getCharPositionInLine(),
                ctx.keyword_name().getStart().getStartIndex(),
                ctx.keyword_name().getStop().getStopIndex(),
                stafFileVisitor.getFilePath());
        keywordCall.setPosition(tokenPosition);
        StafParser.Keyword_call_argumentsContext keywordCallContext = ctx.keyword_call_arguments();
        if (keywordCallContext != null) {
            keywordCall.setArgumentsList(keywordCallArgumentsVisitor.visitKeyword_call_arguments(ctx.keyword_call_arguments()));
        }
        return keywordCall;
    }
}
