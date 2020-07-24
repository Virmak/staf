package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DotItemAccess extends AbstractStafObject {
    private AbstractStafObject dictVariable;
    private AbstractStafObject itemIdentifier;

    public DotItemAccess(AbstractStafObject dictVariable, AbstractStafObject indexObject) {
        this.dictVariable = dictVariable;
        this.itemIdentifier = indexObject;
        this.type = StafTypes.DOT_ITEM_ACCESS;
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafDictionary actualDict = (StafDictionary) dictVariable.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        return actualDict.getObjectMap().get(((AbstractStafObject)itemIdentifier.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository)).getValue());
    }
}
