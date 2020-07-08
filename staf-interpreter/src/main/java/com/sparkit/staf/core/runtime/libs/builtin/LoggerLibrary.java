package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@StafLibrary(name = "Builtin Logging library", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    private static final Logger logger = LogManager.getLogger(Main.class);

    @Keyword(name = "log")

    public void log(AbstractStafObject data) {
        logger.info(data.getValue().toString());
    }

    @Keyword(name = "log info")
    public void logInfo(AbstractStafObject data) {
        logger.info(data.getValue().toString());
    }

    @Keyword(name = "log warn")
    public void logWarn(AbstractStafObject data) {
        logger.warn(data.getValue().toString());
    }

    @Keyword(name = "log error")
    public void logErr(AbstractStafObject data) {
        logger.error(data.getValue().toString());
    }
}
