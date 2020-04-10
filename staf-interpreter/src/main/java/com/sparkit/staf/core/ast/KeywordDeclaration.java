package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.IStatementBlock;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidArgsNumberKeywordCallException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.StafRuntimeException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedKeywordException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class KeywordDeclaration implements IStatementBlock {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    protected String keywordName;
    protected List<String> argsList;
    protected List<IStatement> statementList;
    protected AbstractStafObject returnObject;
    protected String file;
    protected List<StatementReport> reports;

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

    public Object execute(StatementBlockExecutor statementBlockExecutor, SymbolsTable globalSymTable,
                          KeywordLibrariesRepository keywordLibrariesRepository,
                                         Object[] params) throws Throwable {
        reports = new ArrayList<>();
        SymbolsTable localSymTable = new SymbolsTable(statementBlockExecutor);
        evaluateArgs(globalSymTable, localSymTable, keywordLibrariesRepository, params);
        reports = statementBlockExecutor.execute(this, null, globalSymTable, localSymTable, keywordLibrariesRepository);
        KeywordCall keywordCall = statementBlockExecutor.getCallStack().pop();
        keywordCall.setStatementReports(reports);
        if (returnObject != null) {
            return returnObject.evaluate(statementBlockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return null;
    }

    private void evaluateArgs(SymbolsTable globalSymTable,
                              SymbolsTable localSymTable,
                              KeywordLibrariesRepository keywordLibrariesRepository,
                              Object[] params) throws Throwable {

        if (params.length != argsList.size())
            throw new InvalidArgsNumberKeywordCallException(argsList.size(), params.length, keywordName);

        for (int i = 0; i < params.length; i++) {
            localSymTable.setSymbolValue(argsList.get(i), params[i]);
            AbstractStafObject stafObject = (AbstractStafObject) params[i];
            if (stafObject.getType() == StafTypes.VAR_REF) {
                AbstractStafObject valObj = (AbstractStafObject) globalSymTable.getSymbolValue(stafObject.getValue().toString());
                if (valObj == null) {
                    throw new UndefinedVariableException(stafObject.getValue().toString());
                }
                localSymTable.setSymbolValue(argsList.get(i), valObj);
            } else if (stafObject.getType() == StafTypes.KEYWORD_CALL) {
                KeywordCall keywordCall = (KeywordCall) stafObject.getValue();
                if (keywordLibrariesRepository.isKeywordDeclared(keywordCall.getKeywordName())) {
                    localSymTable.setSymbolValue(argsList.get(i),
                            keywordLibrariesRepository.invokeKeyword(keywordCall.getKeywordName(), keywordCall.getArgumentsList().toArray()));
                } else {
                    throw new UndefinedKeywordException(keywordCall.getKeywordName());
                }
            } else {
                localSymTable.setSymbolValue(argsList.get(i), params[i]);
            }
        }
    }

    @Override
    public List<IStatement> getStatements() {
        return statementList;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return reports;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {
        this.reports = reports;
    }
}
