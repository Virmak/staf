package com.sparkit.interpreter.runtime.evaluator.statement;

import com.sparkit.interpreter.compiler.ast.statement.KeywordCall;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.CallStack;
import com.sparkit.interpreter.runtime.SymbolsTable;
import com.sparkit.interpreter.runtime.evaluator.IStafObjectEvaluator;
import com.sparkit.interpreter.runtime.exceptions.UndefinedKeywordException;
import com.sparkit.interpreter.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.domain.TestResult;
import com.sparkit.staf.domain.report.StatementReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class KeywordCallExecutor implements IStatementExecutor<KeywordCall, AbstractStafObject> {
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private IStafObjectEvaluator<AbstractStafObject> objectEvaluator;
    @Autowired
    private CallStack callStack;

    @Override
    public AbstractStafObject execute(KeywordCall keywordCall, SymbolsTable localSymbolTable) throws Throwable {
        StatementReport keywordCallReport = new StatementReport();
        keywordCallReport.setResult(TestResult.Pass);
        keywordCallReport.setStart(new Date());
        callStack.push(keywordCall, keywordCallReport);
        CallStack.CallStackItem callScope = callStack.peek();
        callScope.getStatementReport().getChildReports().add(keywordCallReport);
        try {
            if (keywordLibrariesRepository.isKeywordDeclared(keywordCall.getKeywordName())) {
                Object[] params = evaluateArgumentsList(keywordCall, localSymbolTable);
                return keywordLibrariesRepository.invokeKeyword(keywordCall.getKeywordName(), params);
            } else {
                throw new UndefinedKeywordException(keywordCall.getKeywordName());
            }
        } catch (Throwable throwable) {
            keywordCallReport.setResult(TestResult.Fail);
            throw throwable;
        } finally {
            keywordCallReport.setEnd(new Date());
            keywordCallReport.setName(keywordCall.getKeywordName());
        }
    }

    private AbstractStafObject[] evaluateArgumentsList(KeywordCall keywordCall, SymbolsTable localSymbolTable)
            throws Throwable {
        AbstractStafObject[] params = new AbstractStafObject[keywordCall.getArgumentsList().size()];
        int i = 0;
        for (AbstractStafObject arg : keywordCall.getArgumentsList()) {
            params[i++] = objectEvaluator.evaluate(arg, localSymbolTable);
        }
        return params;
    }
}
