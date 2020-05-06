package com.sparkit.interpreter.runtime.evaluator;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.StafVariable;
import com.sparkit.interpreter.runtime.SymbolsTable;
import com.sparkit.interpreter.runtime.exceptions.UndefinedVariableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StafVariableEvaluator implements IStafObjectEvaluator<StafVariable> {
    @Autowired
    private SymbolsTable globalSymTable;

    @Override
    public AbstractStafObject evaluate(StafVariable object, SymbolsTable localSymTable)
            throws UndefinedVariableException {
        AbstractStafObject returnObject = null;
        if (localSymTable != null) {
            returnObject = localSymTable.getSymbolValue(object.getValue().toString());
        }
        if (returnObject == null) {
            returnObject = globalSymTable.getSymbolValue(object.getValue().toString());
        }
        if (returnObject instanceof StafVariable) {
            return evaluate(object, localSymTable);
        }
        return returnObject;
    }
}
