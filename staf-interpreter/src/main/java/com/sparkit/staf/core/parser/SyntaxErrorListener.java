package com.sparkit.staf.core.parser;

import com.sparkit.staf.core.utils.SharedConstants;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.misc.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SyntaxErrorListener extends BaseErrorListener {
    private static final Logger logger = LoggerFactory.getLogger(SyntaxErrorListener.class);
    private final List<SyntaxError> syntaxErrors = new ArrayList<>();
    private final String filePath;

    public SyntaxErrorListener(String filePath) {
        this.filePath = filePath;
    }

    public List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        syntaxErrors.add(new SyntaxError(recognizer, offendingSymbol, line, charPositionInLine, filePath, msg, e));
        String errorMessage = "line " + line + ":" + charPositionInLine + " " + msg + " at file : " + filePath;
        logger.error(SharedConstants.SYNTAX_ERROR_AT, errorMessage);
        throw new ParseCancellationException(errorMessage);

    }

    @Override
    public String toString() {
        return Utils.join(syntaxErrors.iterator(), "\n");
    }
}
