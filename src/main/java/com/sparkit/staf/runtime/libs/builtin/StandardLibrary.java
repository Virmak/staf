package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;

@StafLibrary(name = "standard", builtin = true)
public class StandardLibrary extends AbstractStafLibrary {

    @Keyword(name = "should be equal")
    public void shouldBeEqual(AbstractStafObject object, AbstractStafObject expected) {
        System.out.println("shouldBeEqual");

    }

    @Keyword(name = "run keyword if")
    public void runKeywordIf(Object condition, AbstractStafObject keywordCall) {
        System.out.println("run keyword if ----");
    }

    @Override
    protected Class<? extends AbstractStafLibrary> getClassName() {
        return StandardLibrary.class;
    }
}
