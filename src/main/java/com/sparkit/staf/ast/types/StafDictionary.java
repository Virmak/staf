package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.KeyValuePair;
import com.sparkit.staf.ast.StafTypes;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import java.util.Hashtable;
import java.util.Map;

public class StafDictionary extends AbstractStafObject {
    protected Map<String, AbstractStafObject> objectMap;

    public StafDictionary() {
        objectMap = new Hashtable<>();
        this.type = StafTypes.DICTIONARY;
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return objectMap;
    }

    public StafDictionary(Map<String, AbstractStafObject> items) {
        this.objectMap = items;
        this.type = StafTypes.DICTIONARY;
    }

    public Map<String, AbstractStafObject> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, AbstractStafObject> objectMap) {
        this.objectMap = objectMap;
    }

    public void putKeyValuePair(KeyValuePair keyValuePair) {
        objectMap.put(keyValuePair.getKey(), keyValuePair.getValue());
    }

    public void removeItemAt(String key) {
        objectMap.remove(key);
    }
}
