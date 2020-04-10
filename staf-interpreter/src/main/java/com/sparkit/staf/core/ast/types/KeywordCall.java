package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedKeywordException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;

import java.util.List;

public class KeywordCall extends AbstractStafObject implements IStatement, IReportableBlock {
    protected String keywordName;
    protected List<AbstractStafObject> argumentsList;
    protected int lineNumber;
    protected String file;
    protected List<StatementReport> statementReports;

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

    @Override
    public Object evaluate(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable,
                           KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        this.execute(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        return this;
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

    public Object[] evaluateArgumentsList(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable,
                                          KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        Object[] params = new AbstractStafObject[argumentsList.size()];
        int i = 0;
        for (AbstractStafObject arg : argumentsList) {
            params[i++] = arg.evaluate(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return params;
    }

    @Override
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable,
                          KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        blockExecutor.getCallStack().push(this);
        if (keywordLibrariesRepository.isKeywordDeclared(keywordName)) {
            Object[] params = evaluateArgumentsList(blockExecutor, globalSymTable,
                    localSymTable, keywordLibrariesRepository);
            return keywordLibrariesRepository.invokeKeyword(keywordName, params);
        } else {
            throw new UndefinedKeywordException(keywordName);
        }
    }

    @Override
    public String toString() {
        if (argumentsList.size() == 0) {
            return keywordName;
        }
        StringBuilder args = new StringBuilder();
        argumentsList.forEach(o -> args.append(o.toString()).append(", "));
        return keywordName + " [" + args.substring(0, args.length() - 2) + "] at " + getFile() + "  at line " + lineNumber;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return statementReports;
    }

    public void setStatementReports(List<StatementReport> statementReports) {
        this.statementReports = statementReports;
    }
}