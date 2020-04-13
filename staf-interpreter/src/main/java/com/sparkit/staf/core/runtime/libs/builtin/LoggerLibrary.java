package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@StafLibrary(name = "logger", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    private static final Logger logger = LogManager.getLogger();

    @Keyword(name = "log")
    public void log(@KeywordArgument AbstractStafObject data) {
        logger.debug(data.getValue());
    }

    @Keyword(name = "log info")
    public void logInfo(@KeywordArgument AbstractStafObject data) {
        logger.info(data.getValue());
    }

    @Keyword(name = "log warn")
    public void logWarn(@KeywordArgument AbstractStafObject data) {
        logger.warn(data.getValue());
    }

    @Keyword(name = "log error")
    public void logErr(@KeywordArgument AbstractStafObject data) {
        logger.error(data.getValue());
    }
}
