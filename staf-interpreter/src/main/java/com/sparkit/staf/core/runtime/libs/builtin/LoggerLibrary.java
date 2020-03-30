package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
<<<<<<< HEAD:staf-interpreter/src/main/java/com/sparkit/staf/core/core/runtime/libs/builtin/LoggerLibrary.java
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;
=======
import com.sparkit.staf.core.runtime.loader.TestContainer;
>>>>>>> 7a82d8117d101f54165fa8a08889696c97e79217:staf-interpreter/src/main/java/com/sparkit/staf/core/runtime/libs/builtin/LoggerLibrary.java
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@StafLibrary(name = "logger", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public LoggerLibrary(TestContainer container) {
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
