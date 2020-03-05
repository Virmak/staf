package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;

@StafLibrary(name = "logger", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {

    @Keyword(name = "log")
    public void log(@KeywordArgument Object data) {
        System.out.println("LOG : " + data);
    }

    @Override
    protected Class<? extends AbstractStafLibrary> getClassName() {
        return LoggerLibrary.class;
    }
}
