package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Map;

public abstract class AbstractStafObject {
    protected Object value;
    protected StafTypes type;

    public AbstractStafObject() {
    }

    public AbstractStafObject(Object value, StafTypes type) {
        this.value = value;
        this.type = type;
    }

    public StafTypes getType() {
        return type;
    }

    public void setType(StafTypes type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isPrimitive() {
        return this.type == StafTypes.BOOL
                || this.type == StafTypes.INT
                || this.type == StafTypes.DOUBLE
                || this.type == StafTypes.STRING;
    }

    public abstract Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable;

    public Object toJSON() {
        return value;
    }

    public static AbstractStafObject fromObject(Object obj) {
        if (obj instanceof JSONObject) {
            return StafDictionary.fromMap((Map<String, Object>)obj);
        } else if (obj instanceof JSONArray) {
            return StafList.fromJSONArray((JSONArray)obj);
        } else if (obj instanceof String) {
            return new StafString((String)obj);
        } else if (obj instanceof Long) {
            return new StafInteger(Integer.parseInt(obj.toString()));
        } else if (obj instanceof Double) {
            return new StafDouble(Double.parseDouble(obj.toString()));
        } else if (obj instanceof Boolean) {
            return new StafBoolean((Boolean)obj);
        }
        return null;
    }

    @Override
    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return null;
    }
}
