package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import lombok.Data;

@Data
public class KeyValuePair {
    protected String key;
    protected AbstractStafObject value;

    public KeyValuePair() {
    }

    public KeyValuePair(String key, AbstractStafObject value) {
        this.key = key;
        this.value = value;
    }

}
