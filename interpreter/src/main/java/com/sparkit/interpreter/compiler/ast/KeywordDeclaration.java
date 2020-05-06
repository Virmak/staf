package com.sparkit.interpreter.compiler.ast;


import com.sparkit.interpreter.Main;
import com.sparkit.interpreter.compiler.ast.statement.IStatement;
import com.sparkit.interpreter.compiler.ast.statement.StafCallable;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class KeywordDeclaration implements StafCallable {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    protected String keywordName;
    protected List<String> argsList;
    protected List<IStatement> statementList;
    protected AbstractStafObject returnObject;
    protected String file;

    public KeywordDeclaration(String keywordName, List<String> argsList, List<IStatement> statementList, AbstractStafObject returnObject) {
        this.keywordName = keywordName;
        this.argsList = argsList;
        this.statementList = statementList;
        this.returnObject = returnObject;
    }

    public KeywordDeclaration() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public AbstractStafObject getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(AbstractStafObject returnObject) {
        this.returnObject = returnObject;
    }

    public List<IStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<IStatement> statementList) {
        this.statementList = statementList;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<String> getArgsList() {
        return argsList;
    }

    public void setArgsList(List<String> argsList) {
        this.argsList = argsList;
    }

}
