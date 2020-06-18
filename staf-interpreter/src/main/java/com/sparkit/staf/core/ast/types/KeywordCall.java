package com.sparkit.staf.core.ast.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    protected final StatementBlockExecutor blockExecutor;
    protected final KeywordLibrariesRepository keywordLibrariesRepository;
    protected String keywordName;
    protected List<AbstractStafObject> argumentsList;
    protected int lineNumber;
    protected String file;
    @JsonIgnore
    protected List<StatementReport> statementReports;

    public KeywordCall(StatementBlockExecutor blockExecutor, KeywordLibrariesRepository keywordLibrariesRepository,
                       String keywordName, List<AbstractStafObject> argumentsList) {
        this.blockExecutor = blockExecutor;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.keywordName = keywordName;
        this.argumentsList = argumentsList;
        this.type = StafTypes.KEYWORD_CALL;
    }

    public KeywordCall(StatementBlockExecutor blockExecutor, KeywordLibrariesRepository keywordLibrariesRepository) {
        this.blockExecutor = blockExecutor;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
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
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        return this.execute(globalSymbolsTable, localSymbolsTable);
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

    public Object[] evaluateArgumentsList(SymbolsTable globalSymTable, SymbolsTable localSymTable) throws Throwable {
        Object[] params = new AbstractStafObject[argumentsList.size()];
        int i = 0;
        for (AbstractStafObject arg : argumentsList) {
            Object val = arg.evaluate(globalSymTable, localSymTable);
            params[i++] = val;
        }
        return params;
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

    @Override
    public List<StatementReport> getStatementReports() {
        return statementReports;
    }

    public void setStatementReports(List<StatementReport> statementReports) {
        this.statementReports = statementReports;
    }

    @Override
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        blockExecutor.getCallStack().push(this);
        if (keywordLibrariesRepository.isKeywordDeclared(keywordName)) {
            Object[] params = evaluateArgumentsList(globalSymbolsTable,
                    localSymbolsTable);
            return keywordLibrariesRepository.invokeKeyword(globalSymbolsTable, keywordName, params);
        } else {
            throw new UndefinedKeywordException(keywordName);
        }
    }
}
