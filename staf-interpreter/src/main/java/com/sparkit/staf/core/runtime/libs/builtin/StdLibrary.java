package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.ShouldBeEqualException;
import org.springframework.beans.factory.annotation.Autowired;

@StafLibrary(name = "standard", builtin = true)
public class StdLibrary extends AbstractStafLibrary {
    private final double THRESHOLD = .0001;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;

    @Keyword(name = "should be equal")
    public void shouldBeEqual(AbstractStafObject object, AbstractStafObject expected, AbstractStafObject errorMessage)
            throws ShouldBeEqualException {
        if (!compareStafObjects(object, expected)) {
            if (errorMessage != null) {
                throw new ShouldBeEqualException(errorMessage.getValue().toString());
            } else {
                throw new ShouldBeEqualException(object.getValue().toString()
                        + ", " + expected.getValue().toString() + " are not equal");
            }
        }
        System.out.println("Should be equal validated");
    }

    @Keyword(name = "trim")
    public StafString trim(AbstractStafObject object, AbstractStafObject expected) throws ShouldBeEqualException {
        return new StafString(object.getValue().toString().trim());
    }

    @Keyword(name = "replace text")
    public StafString replaceString(AbstractStafObject str, AbstractStafObject oldStr, AbstractStafObject newStr)
            throws ShouldBeEqualException {
        return new StafString(str.getValue().toString().replaceAll(oldStr.getValue().toString(), newStr.getValue().toString()));
    }

    @Keyword(name = "range")
    public StafList range(AbstractStafObject from, AbstractStafObject to) throws ShouldBeEqualException {
        int start, end;
        if (to == null) {
            start = 0;
            end = (int)from.getValue();
        } else {
            start = (int)from.getValue();
            end = (int)to.getValue();
        }
        StafList list = new StafList();
        for (; start <= end; start++) {
            list.getList().add(new StafInteger(start));
        }
        return list;
    }

    @Keyword(name = "parse number")
    public AbstractStafObject parseNumber(AbstractStafObject object, AbstractStafObject defaultVal) {
        String s;
        s = object.getValue().toString().replace(",", ".");
        s = s.replace("TND", "");
        s = s.replace("€", "");
        s = s.replace("$", "");
        s = s.replaceAll("\\s", "");
        s = s.replace("\u00a0","");
        s = s.replaceAll("\u00a0","");
        s = s.trim();
        try {
            double d = Double.parseDouble(s);
            return new StafDouble(d);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    public boolean compareStafObjects(AbstractStafObject object1, AbstractStafObject object2) {
        if (object1 instanceof StafDouble) {
            Double a = (Double) object1.getValue();
            Double b = (Double) object1.getValue();
            return Math.abs(a - b) < THRESHOLD;
        }
        return object1.getValue().toString().equals(object2.getValue().toString());
    }
}
