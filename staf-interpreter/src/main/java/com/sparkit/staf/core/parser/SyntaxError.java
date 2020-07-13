package com.sparkit.staf.core.parser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

@Data
public class SyntaxError {
    @JsonIgnore
    private final Recognizer<?, ?> recognizer;
    @JsonIgnore
    private final Object offendingSymbol;
    private final int line;
    private final int charPositionInLine;
    private final String filePath;
    private final String message;
    @JsonIgnore
    private final RecognitionException e;
    private int start;
    private int stop;

    SyntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String filePath, String msg, RecognitionException e) {
        this.recognizer = recognizer;
        this.offendingSymbol = offendingSymbol;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.filePath = filePath;
        this.message = msg;
        this.e = e;
        if (offendingSymbol instanceof CommonToken) {
            start = ((CommonToken) offendingSymbol).getStartIndex();
            stop = ((CommonToken) offendingSymbol).getStopIndex();
        }
    }
}