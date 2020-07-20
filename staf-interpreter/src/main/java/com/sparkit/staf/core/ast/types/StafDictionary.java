package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.KeyValuePair;
import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class StafDictionary extends AbstractStafObject {
    @Getter
    @Setter
    private Map<String, AbstractStafObject> objectMap;

    public StafDictionary() {
        objectMap = new Hashtable<>();
        this.type = StafTypes.DICTIONARY;
    }

    public StafDictionary(Map<String, AbstractStafObject> items) {
        this.objectMap = items;
        this.type = StafTypes.DICTIONARY;
    }

    public static StafDictionary fromMap(Map<String, Object> map) {
        Map<String, AbstractStafObject> dictMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            dictMap.put(entry.getKey(), AbstractStafObject.fromObject(entry.getValue()));
        }
        return new StafDictionary(dictMap);
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return this;
    }

    public Map<String, Object> getEvaluatedObjectMap() {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, AbstractStafObject> entry : objectMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getValue());
        }
        return map;
    }

    public void putKeyValuePair(KeyValuePair keyValuePair) {
        objectMap.put(keyValuePair.getKey(), keyValuePair.getValue());
    }

    public void removeItemAt(String key) {
        objectMap.remove(key);
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, AbstractStafObject> entry : objectMap.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue().toJSON());
        }
        return jsonObject;
    }
}
