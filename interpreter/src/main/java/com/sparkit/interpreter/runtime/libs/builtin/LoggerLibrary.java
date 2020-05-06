package com.sparkit.interpreter.runtime.libs.builtin;

import com.sparkit.interpreter.Main;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.libs.AbstractStafLibrary;
import com.sparkit.interpreter.runtime.libs.annotations.Keyword;
import com.sparkit.interpreter.runtime.libs.annotations.KeywordArgument;
import com.sparkit.interpreter.runtime.libs.annotations.StafLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@StafLibrary(name = "logger", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    private static Logger logger = LogManager.getLogger(Main.class);
    @Keyword(name = "log")
    public void log(@KeywordArgument AbstractStafObject data) {
        logger.info(data.getValue().toString());
    }

    @Keyword(name = "log info")
    public void logInfo(@KeywordArgument AbstractStafObject data) {
        logger.info(data.getValue().toString());
    }

    @Keyword(name = "log warn")
    public void logWarn(@KeywordArgument AbstractStafObject data) {
        logger.warn(data.getValue().toString());
    }

    @Keyword(name = "log error")
    public void logErr(@KeywordArgument AbstractStafObject data) {
        logger.error(data.getValue().toString());
    }
}
