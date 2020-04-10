package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class ListItemAccess extends AbstractStafObject {
    protected AbstractStafObject listVariable;
    protected AbstractStafObject indexObject;

    public ListItemAccess(AbstractStafObject listVariable, AbstractStafObject indexObject) {
        this.listVariable = listVariable;
        this.indexObject = indexObject;
        this.type = StafTypes.LIST_ITEM_REF;
    }

    public AbstractStafObject getListVariable() {
        return listVariable;
    }

    public void setListVariable(AbstractStafObject listVariable) {
        this.listVariable = listVariable;
    }

    public AbstractStafObject getIndexObject() {
        return indexObject;
    }

    public void setIndexObject(AbstractStafObject indexObject) {
        this.indexObject = indexObject;
    }

    @Override
    public Object evaluate(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafList actualList = (StafList) listVariable.evaluate(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        AbstractStafObject actualIndexObject = (AbstractStafObject) indexObject.evaluate(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        return actualList.getList().get((Integer)actualIndexObject.getValue());
    }
}