package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;

@StafLibrary(name = "selenium", builtin = true)
public class SeleniumLibrary extends AbstractStafLibrary {

    @Keyword(name = "Open browser")
    public void openBrowser() {
        System.out.println("Opening browser");
    }

    @Keyword(name = "Input Text")
    public void input(@KeywordArgument String selector, @KeywordArgument String value) {
        System.out.println("Set input (" + selector + ") value = " + value );
    }

    @Keyword(name = "Click Button")
    public void clickButton(@KeywordArgument String buttonSelector) {
        System.out.println("Clicking button (" + buttonSelector + ")");
    }

    @Keyword(name = "Input Value")
    public String getInputValue(@KeywordArgument String inputSelector) {
        return inputSelector + "[value=test]";
    }

    @Override
    protected Class<? extends AbstractStafLibrary> getClassName() {
        return SeleniumLibrary.class;
    }
}
