package com.sparkit.staf.core.runtime.interpreter.exceptions;

import com.sparkit.staf.core.ast.IStatement;
import lombok.Getter;

public class StafRuntimeException extends Exception {
    @Getter
    private String keywordName;
    @Getter
    private IStatement statement;

    public StafRuntimeException() {
    }

    public StafRuntimeException(String keywordName) {
        this.keywordName = keywordName;
    }

    public StafRuntimeException(String message, String keywordName) {
        super(message);
        this.keywordName = keywordName;
    }

    public StafRuntimeException(String message, Throwable cause, String keywordName) {
        super(message, cause);
        this.keywordName = keywordName;
    }

    public StafRuntimeException(Throwable cause) {
        super(cause);
    }

    public StafRuntimeException(Throwable cause, String keywordName, IStatement statement) {
        super(cause);
        this.keywordName = keywordName;
        this.statement = statement;
    }


    public StafRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String keywordName) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.keywordName = keywordName;
    }
}
