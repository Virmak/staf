package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Inject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.ShouldBeEqualException;
import com.sparkit.staf.core.runtime.libs.exceptions.ShouldNotBeEqualException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@StafLibrary(name = "Standard library", builtin = true)
public class StdLibrary extends AbstractStafLibrary {
    private static final Logger logger = LoggerFactory.getLogger(StdLibrary.class);
    private static final double THRESHOLD = .001;

    @Keyword(name = "should be equal")
    public void shouldBeEqual(@KeywordArgument(name = "object") AbstractStafObject stafObject, @KeywordArgument(name = "expected") AbstractStafObject expected,
                              @KeywordArgument(name = "errorMessage", optional = true) StafString errorMessage)
            throws ShouldBeEqualException {
        if (!compareStafObjects(stafObject, expected)) {
            logger.info("Should be equal not validated {} = {}", stafObject, expected);
            if (errorMessage != null) {
                throw new ShouldBeEqualException(errorMessage.getValue().toString());
            } else {
                throw new ShouldBeEqualException(stafObject.getValue().toString()
                        + ", " + expected.getValue().toString() + " are not equal");
            }
        }
        logger.info("Should be equal validated {} = {}", stafObject, expected);
    }

    @Keyword(name = "should not be equal")
    public void shouldNoBeEqual(@KeywordArgument(name = "object") AbstractStafObject stafObject, @KeywordArgument(name = "expected") AbstractStafObject expected,
                                @KeywordArgument(name = "errorMessage", optional = true) StafString errorMessage)
            throws ShouldBeEqualException {
        if (compareStafObjects(stafObject, expected)) {
            logger.info("Should not be equal not validated {} = {}", stafObject, expected);
            if (errorMessage != null) {
                throw new ShouldNotBeEqualException(errorMessage.getValue().toString());
            } else {
                throw new ShouldNotBeEqualException(stafObject.getValue().toString()
                        + ", " + expected.getValue().toString() + " are equal");
            }
        }
        logger.info("Should not be equal validated {} != {}", stafObject, expected);
    }

    @Keyword(name = "trim")
    public StafString trim(@KeywordArgument(name = "string") StafString stafString) throws ShouldBeEqualException {
        return new StafString(stafString.getValue().toString().trim());
    }

    @Keyword(name = "replace text")
    public StafString replaceString(@KeywordArgument(name = "string") StafString stafString, @KeywordArgument(name = "search") StafString search,
                                    @KeywordArgument(name = "replace") StafString replacement)
            throws ShouldBeEqualException {
        return new StafString(stafString.getValue().toString().replaceAll(search.getValue().toString(), replacement.getValue().toString()));
    }

    @Keyword(name = "debugger")
    public void debugger(AbstractStafObject args)
            throws ShouldBeEqualException {
        System.out.println(args);
    }


    @Keyword(name = "range", doc = "Generate a list with numbers [from ... to]")
    public StafList range(@KeywordArgument(name = "from") AbstractStafObject from, @KeywordArgument(name = "to", optional = true) AbstractStafObject to)
            throws ShouldBeEqualException {
        int start, end;
        if (to == null) {
            start = 0;
            end = (int) from.getValue();
        } else {
            start = (int) from.getValue();
            end = (int) to.getValue();
        }
        StafList list = new StafList();
        for (; start <= end; start++) {
            list.getStafList().add(new StafInteger(start));
        }
        return list;
    }

    @Keyword(name = "parse number", doc = "Convert a string into a double and remove currency")
    public AbstractStafObject parseNumber(StafString stafString, AbstractStafObject defaultVal) {
        String s;
        s = removeCurrency(stafString.getValue().toString());
        s = removeWhiteSpace(s);
        try {
            double d = Double.parseDouble(s);
            return new StafDouble(d);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    @Keyword(name = "get session id", doc = "Get parallel session id")
    public AbstractStafObject getSessionId(@Inject(name = "$__session__") StafInteger sessionId) {
        return sessionId;
    }

    private String removeCurrency(String s) {
        return s.replace(",", ".")
                .replace("TND", "")
                .replace("€", "")
                .replace("$", "");
    }

    private String removeWhiteSpace(String s) {
        return s.replaceAll("\\s", "")
                .replace("\u00a0", "")
                .replaceAll("\u00a0", "").trim();
    }

    public boolean compareStafObjects(AbstractStafObject object1, AbstractStafObject object2) {
        if (object1 instanceof StafDouble) {
            double a = (Double) object1.getValue();
            double b = (Double) object2.getValue();
            double difference = Math.abs(a - b);
            return difference < THRESHOLD;
        }
        return object1.getValue().toString().equals(object2.getValue().toString());
    }
}
