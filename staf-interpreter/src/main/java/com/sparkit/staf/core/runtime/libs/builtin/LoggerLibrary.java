package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDictionary;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.utils.SharedConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@StafLibrary(name = "Builtin Logging library", builtin = true)
public class LoggerLibrary extends AbstractStafLibrary {
    private static final Logger logger = LogManager.getLogger(LoggerLibrary.class);

    @Keyword(name = "log")
    public void log(@KeywordArgument(name = "object") AbstractStafObject stafObject) {
        logger.info(SharedConstants.LOGGER_LIB_TEMPLATE, evaluateStafObject(stafObject));
    }

    @Keyword(name = "log info")
    public void logInfo(@KeywordArgument(name = "object") AbstractStafObject stafObject) {
        logger.info(SharedConstants.LOGGER_LIB_TEMPLATE, evaluateStafObject(stafObject));
    }

    @Keyword(name = "log warn")
    public void logWarn(@KeywordArgument(name = "object") AbstractStafObject stafObject) {
        logger.warn(SharedConstants.LOGGER_LIB_TEMPLATE,evaluateStafObject(stafObject));
    }

    @Keyword(name = "log error")
    public void logErr(@KeywordArgument(name = "object") AbstractStafObject stafObject) {
        logger.error(SharedConstants.LOGGER_LIB_TEMPLATE, evaluateStafObject(stafObject));
    }

    private Object evaluateStafObject(AbstractStafObject stafObject) {
        if (stafObject instanceof StafDictionary) {
            return ((StafDictionary) stafObject).getObjectMap();
        } else if (stafObject instanceof StafList) {
            return ((StafList) stafObject).getStafList();
        }
        return stafObject.getValue();
    }
}
