package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class ListItemAccess extends AbstractStafObject {
    private final AbstractStafObject stafListReference;
    private final AbstractStafObject indexObject;

    public ListItemAccess(AbstractStafObject stafListReference, AbstractStafObject indexObject) {
        this.stafListReference = stafListReference;
        this.indexObject = indexObject;
        this.type = StafTypes.LIST_ITEM_REF;
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafList actualList = (StafList) stafListReference.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        AbstractStafObject actualIndexObject = (AbstractStafObject) indexObject.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        return actualList.getStafList().get((Integer) actualIndexObject.getValue());
    }
}
