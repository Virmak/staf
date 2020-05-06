package com.sparkit.interpreter.runtime.exceptions;

import com.sparkit.interpreter.compiler.ast.statement.IStatement;

public class StafRuntimeException extends Exception {
    private String keywordName;
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

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public IStatement getStatement() {
        return statement;
    }

    public void setStatement(IStatement statement) {
        this.statement = statement;
    }
}
