package com.sparkit.interpreter.runtime.evaluator;

import com.sparkit.interpreter.compiler.ast.Expression;
import com.sparkit.interpreter.compiler.ast.statement.KeywordCall;
import com.sparkit.interpreter.compiler.ast.types.*;
import com.sparkit.interpreter.runtime.SymbolsTable;
import com.sparkit.interpreter.runtime.evaluator.statement.IStatementExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StafObjectEvaluator implements IStafObjectEvaluator<AbstractStafObject> {
    @Autowired
    private IStafObjectEvaluator<DictionaryItemAccess> dictionaryItemAccessEvaluator;
    @Autowired
    private IStafObjectEvaluator<ListItemAccess> listItemAccessEvaluator;
    @Autowired
    private IStatementExecutor<KeywordCall, AbstractStafObject> keywordCallExecutor;
    @Autowired
    private IStafObjectEvaluator<StafVariable> stafVariableEvaluator;
    @Autowired
    private IStafObjectEvaluator<Expression> expressionEvaluator;
    @Autowired
    private SymbolsTable globalSymTable;

    @Override
    public AbstractStafObject evaluate(AbstractStafObject object, SymbolsTable localSymTable)
            throws Throwable {
        if (object instanceof StafVariable) {
            return stafVariableEvaluator.evaluate((StafVariable) object, localSymTable);
        } else if (object instanceof DictionaryItemAccess) {
            return dictionaryItemAccessEvaluator.evaluate((DictionaryItemAccess) object, localSymTable);
        } else if (object instanceof ListItemAccess) {
            return listItemAccessEvaluator.evaluate((ListItemAccess) object, localSymTable);
        } else if (object instanceof KeywordCall) {
            return keywordCallExecutor.execute((KeywordCall) object, localSymTable);
        } else if (object instanceof Expression) {
            return expressionEvaluator.evaluate((Expression) object, localSymTable);
        }
        return object;
    }

    private boolean isPrimitive(AbstractStafObject object) {
        return object instanceof StafInteger || object instanceof StafDouble || object instanceof StafBoolean;
    }
}
