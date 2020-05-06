package com.sparkit.interpreter.compiler.ast.statement;

import com.sparkit.interpreter.compiler.ast.StafTypes;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;

import java.util.List;

public class KeywordCall extends AbstractStafObject implements IStatement, StafCallable {
    protected String keywordName;
    protected List<AbstractStafObject> argumentsList;
    protected int lineNumber;
    protected String file;

    public KeywordCall(String keywordName, List<AbstractStafObject> argumentsList) {
        this.keywordName = keywordName;
        this.argumentsList = argumentsList;
        this.type = StafTypes.KEYWORD_CALL;
    }

    public KeywordCall() {
        this.type = StafTypes.KEYWORD_CALL;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<AbstractStafObject> getArgumentsList() {
        return argumentsList;
    }

    public void setArgumentsList(List<AbstractStafObject> argumentsList) {
        this.argumentsList = argumentsList;
    }


    @Override
    public String toString() {
        if (argumentsList != null && argumentsList.size() == 0) {
            return keywordName;
        }
        StringBuilder args = new StringBuilder();
        String argsString;
        if (argumentsList != null) {
            argumentsList.forEach(o -> args.append(o.toString()).append(", "));
            argsString = args.substring(0, args.length() - 2);
        } else {
            argsString = "";
        }
        return keywordName + " [" + argsString + "] at " + getFile() + "  at line " + lineNumber;
    }

}
