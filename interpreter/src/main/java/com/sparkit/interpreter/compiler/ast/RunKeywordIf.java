package com.sparkit.interpreter.compiler.ast;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.statement.KeywordCall;

public class RunKeywordIf extends KeywordCall {
    protected AbstractStafObject condition;
    protected KeywordCall keywordCall;

    public RunKeywordIf() {
    }

    public RunKeywordIf(AbstractStafObject condition, KeywordCall keywordCall) {
        this.condition = condition;
        this.keywordCall = keywordCall;
    }

    public AbstractStafObject getCondition() {
        return condition;
    }

    public void setCondition(AbstractStafObject condition) {
        this.condition = condition;
    }

    public KeywordCall getKeywordCall() {
        return keywordCall;
    }

    public void setKeywordCall(KeywordCall keywordCall) {
        this.keywordCall = keywordCall;
    }

}
