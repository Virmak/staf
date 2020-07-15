package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.IStatementBlock;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidArgsNumberKeywordCallException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedKeywordException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
public class KeywordDeclaration implements IStatementBlock {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private String keywordName;
    private List<String> argsList;
    private List<IStatement> statementList;
    private AbstractStafObject returnObject;
    private String file;
    private int lineNumber;
    private List<StatementReport> reports;

    public KeywordDeclaration() {
    }

    public Object execute(StatementBlockExecutor statementBlockExecutor, MemoryMap globalSymTable,
                          KeywordLibrariesRepository keywordLibrariesRepository,
                          Object[] params) throws Throwable {
        reports = new ArrayList<>();
        MemoryMap localMemory = new MemoryMap();
        evaluateArgs(globalSymTable, localMemory, keywordLibrariesRepository, params);
        reports = statementBlockExecutor.execute(this, null, globalSymTable, localMemory, keywordLibrariesRepository);
        KeywordCall keywordCall = statementBlockExecutor.getCallStack().pop(globalSymTable.getSessionId());
        keywordCall.setStatementReports(reports);
        if (returnObject != null) {
            return returnObject.evaluate(globalSymTable, localMemory, keywordLibrariesRepository);
        }
        return null;
    }

    private void evaluateArgs(MemoryMap globalSymbolsTable,
                              MemoryMap localSymTable,
                              KeywordLibrariesRepository keywordLibrariesRepository,
                              Object[] params) throws Throwable {

        if (params.length != argsList.size())
            throw new InvalidArgsNumberKeywordCallException(argsList.size(), params.length, keywordName);

        for (int i = 0; i < params.length; i++) {
            localSymTable.setVariableValue(argsList.get(i), params[i]);
            AbstractStafObject stafObject = (AbstractStafObject) params[i];
            StafTypes type;
            try {
                type = stafObject.getType();
            } catch (NullPointerException e) {
                throw new UndefinedVariableException((String) params[i]);
            }
            if (type == StafTypes.VAR_REF) {
                AbstractStafObject valObj = (AbstractStafObject) globalSymbolsTable.getVariableValue(stafObject.getValue().toString());
                if (valObj == null) {
                    throw new UndefinedVariableException(stafObject.getValue().toString());
                }
                localSymTable.setVariableValue(argsList.get(i), valObj);
            } else if (stafObject.getType() == StafTypes.KEYWORD_CALL) {
                KeywordCall keywordCall = (KeywordCall) stafObject.getValue();
                if (keywordLibrariesRepository.isKeywordDeclared(keywordCall.getKeywordName())) {
                    localSymTable.setVariableValue(argsList.get(i),
                            keywordLibrariesRepository.invokeKeyword(globalSymbolsTable, keywordCall, keywordCall.getArgumentsList().toArray()));
                } else {
                    throw new UndefinedKeywordException(keywordCall.getKeywordName());
                }
            } else {
                localSymTable.setVariableValue(argsList.get(i), params[i]);
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
