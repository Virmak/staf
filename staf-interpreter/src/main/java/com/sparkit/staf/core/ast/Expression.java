package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.DictionaryItemAccess;
import com.sparkit.staf.core.ast.types.ListItemAccess;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.interpreter.expression.ExpressionEvaluator;
import com.sparkit.staf.core.runtime.interpreter.expression.ExpressionEvaluatorFactory;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

@EqualsAndHashCode(callSuper = true)
@Data
public class Expression extends AbstractStafObject {
    private AbstractStafObject expressionLeftMember;
    private AbstractStafObject expressionRightMember;
    private ExpressionOperator operation;
    private boolean inverted; // tell if expr is inverted like - minus or boolean not (!)

    @Autowired
    private ExpressionEvaluatorFactory expressionEvaluatorFactory;

    public Expression(ExpressionEvaluatorFactory expressionEvaluatorFactory) {
        this.expressionEvaluatorFactory = expressionEvaluatorFactory;
        this.type = StafTypes.EXPRESSION;
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        AbstractStafObject expressionLeftMemberValue = expressionLeftMember;
        AbstractStafObject expressionRightMemberValue = expressionRightMember;
        if (expressionLeftMember instanceof Expression || expressionLeftMember instanceof StafVariable || expressionLeftMember instanceof DictionaryItemAccess
                || expressionLeftMember instanceof ListItemAccess) {
            expressionLeftMemberValue = (AbstractStafObject) expressionLeftMember.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        }
        if (expressionRightMember instanceof Expression || expressionRightMember instanceof StafVariable || expressionRightMember instanceof DictionaryItemAccess
                || expressionRightMember instanceof ListItemAccess) {
            expressionRightMemberValue = (AbstractStafObject) expressionRightMember.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        }
        ExpressionEvaluator expressionEvaluator = expressionEvaluatorFactory.getExpressionEvaluator(operation);
        return expressionEvaluator.evaluate(expressionLeftMemberValue, expressionRightMemberValue, operation);
    }
}
