package com.sparkit.staf.types;

import java.util.Hashtable;
import java.util.Map;

public class StafDictionary extends StafObject {
    protected Map<String, StafObject> objectMap;

    public StafDictionary() {
        objectMap = new Hashtable<>();
        this.type = StafTypes.DICTIONARY;
    }

    public StafDictionary(Map<String, StafObject> items) {
        this.objectMap = items;
        this.type = StafTypes.DICTIONARY;
    }

    public Map<String, StafObject> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, StafObject> objectMap) {
        this.objectMap = objectMap;
    }

    public void putKeyValuePair(KeyValuePair keyValuePair) {
        objectMap.put(keyValuePair.getKey(), keyValuePair.getValue());
    }

    public void removeItemAt(String key) {
        objectMap.remove(key);
    }
}
