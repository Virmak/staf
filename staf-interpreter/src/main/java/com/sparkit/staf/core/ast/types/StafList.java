package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Getter;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class StafList extends AbstractStafObject {
    @Getter
    private final List<AbstractStafObject> stafList;

    public StafList() {
        stafList = new ArrayList<>();
        this.type = StafTypes.LIST;
    }

    public StafList(List<AbstractStafObject> items) {
        this.stafList = items;
        this.type = StafTypes.LIST;
    }

    public static StafList fromJSONArray(JSONArray array) {
        List<AbstractStafObject> list = new ArrayList<>();
        for (Object item : array) {
            list.add(fromObject(item));
        }
        return new StafList(list);
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return this;
    }

    public void addListItem(AbstractStafObject item) {
        stafList.add(item);
    }

    @Override
    public JSONArray toJSON() {
        JSONArray array = new JSONArray();
        for (AbstractStafObject stafObject : stafList) {
            array.add((stafObject).toJSON());
        }
        return array;
    }
}
