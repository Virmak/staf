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
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class KeywordCall extends AbstractStafObject implements IStatement, IReportableBlock {
    protected final StatementBlockExecutor blockExecutor;
    @Getter
    @Setter
    protected String keywordName;
    @Getter
    @Setter
    protected List<AbstractStafObject> argumentsList;
    @Getter
    @Setter
    protected int lineNumber;
    @Getter
    @Setter
    protected String filePath;
    @JsonIgnore
    @Getter
    @Setter
    protected List<StatementReport> statementReports;

    public KeywordCall(StatementBlockExecutor blockExecutor, String keywordName, List<AbstractStafObject> argumentsList) {
        this.blockExecutor = blockExecutor;
        this.keywordName = keywordName;
        this.argumentsList = argumentsList;
        this.type = StafTypes.KEYWORD_CALL;
    }

    public KeywordCall(StatementBlockExecutor blockExecutor) {
        this.blockExecutor = blockExecutor;
        this.type = StafTypes.KEYWORD_CALL;
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return this.execute(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
    }

    public Object[] evaluateArgumentsList(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        Object[] params = new AbstractStafObject[argumentsList.size()];
        int i = 0;
        for (AbstractStafObject arg : argumentsList) {
            Object val = arg.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
            params[i++] = val;
        }
        return params;
    }

    @Override
    public String toString() {
        if (argumentsList != null && argumentsList.isEmpty()) {
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
        return keywordName + " [" + argsString + "] at " + getFilePath() + "  at line " + lineNumber;
    }

    @Override
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable,
                          KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        blockExecutor.getCallStack().push(this, globalSymbolsTable.getSessionId());
        if (keywordLibrariesRepository.isKeywordDeclared(keywordName)) {
            Object[] params = evaluateArgumentsList(globalSymbolsTable,
                    localSymbolsTable, keywordLibrariesRepository);
            return keywordLibrariesRepository.invokeKeyword(globalSymbolsTable, this, params);
        } else {
            throw new UndefinedKeywordException(keywordName);
        }
    }
}
