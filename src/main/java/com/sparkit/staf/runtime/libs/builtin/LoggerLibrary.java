package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.Main;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.runtime.libs.dependencies.DependencyContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@StafLibrary(name = "logger", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public LoggerLibrary(DependencyContainer container) {
        super(container);
    }

    @Keyword(name = "log")
    public void log(@KeywordArgument AbstractStafObject data) {
        LOG.debug(data.getValue());
    }

    @Keyword(name = "log info")
    public void logInfo(@KeywordArgument AbstractStafObject data) {
        LOG.info(data.getValue());
    }

    @Keyword(name = "log warn")
    public void logWarn(@KeywordArgument AbstractStafObject data) {
        LOG.warn(data.getValue());
    }

    @Keyword(name = "log error")
    public void logErr(@KeywordArgument AbstractStafObject data) {
        LOG.error(data.getValue());
    }
}
