package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.ExpressionOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

@Component
public class ExpressionEvaluatorFactory {
    @Autowired
    private AdditionExpressionEvaluator additionExpressionEvaluator;
    @Autowired
    private SubtractionExpressionEvaluator subtractionExpressionEvaluator;
    @Autowired
    private MultiplicationExpressionEvaluator multiplicationExpressionEvaluator;
    @Autowired
    private DivisionExpressionEvaluator divisionExpressionEvaluator;
    @Autowired
    private ModuloExpressionEvaluator moduloExpressionEvaluator;
    @Autowired
    private BooleanExpressionEvaluator booleanExpressionEvaluator;

    public ExpressionEvaluator getExpressionEvaluator(ExpressionOperators operation) throws OperationNotSupportedException {
        switch (operation) {
            case PLUS:
                return additionExpressionEvaluator;
            case MINUS:
                return subtractionExpressionEvaluator;
            case MUL:
                return multiplicationExpressionEvaluator;
            case DIV:
                return divisionExpressionEvaluator;
            case MOD:
                return moduloExpressionEvaluator;
            case EQUAL:
            case NE:
            case GTE:
            case LTE:
            case GT:
            case LT:
            case AND:
            case OR:
                return booleanExpressionEvaluator;
            default:
                throw new OperationNotSupportedException();
        }
    }
}
