package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;

public class Assignment implements IStatement {
    protected StafObject object;
    protected StafObject value;

    public Assignment(StafObject object, StafObject value) {
        this.object = object;
        this.value = value;
    }

    public Assignment() {
    }

    public StafObject getObject() {
        return object;
    }

    public void setObject(StafObject object) {
        this.object = object;
    }

    public StafObject getValue() {
        return value;
    }

    public void setValue(StafObject value) {
        this.value = value;
    }


    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable symTable, KeywordLibrariesRepository libraryKeywordsRepository) throws Exception {
        if (value.getType() == StafTypes.KEYWORD_CALL) {
            KeywordCall keywordCall = (KeywordCall) value;
            object.setValue(keywordCall.execute(globalSymTable, symTable, libraryKeywordsRepository));
        } else {
            object.setValue(value.getValue());
        }
        System.out.println(object.getValue().toString());
        return null;
    }
}
