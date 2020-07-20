package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictionaryItemAccess extends AbstractStafObject {
    private AbstractStafObject dictVariable;
    private String itemIdentifier;

    public DictionaryItemAccess(AbstractStafObject dictVariable, String indexObject) {
        this.dictVariable = dictVariable;
        this.itemIdentifier = indexObject;
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafDictionary actualDict = (StafDictionary) dictVariable.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        return actualDict.getObjectMap().get(itemIdentifier);
    }
}
