package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.ShouldBeEqualException;

@StafLibrary(name = "standard", builtin = true)
public class StdLibrary extends AbstractStafLibrary {
    final double THRESHOLD = .0001;

    @Keyword(name = "should be equal")
    public void shouldBeEqual(AbstractStafObject object, AbstractStafObject expected, AbstractStafObject errorMessage) throws ShouldBeEqualException {
        if (!compareStafObjects(object, expected)) {
            if (errorMessage != null) {
                throw new ShouldBeEqualException(errorMessage.getValue().toString());
            } else {
                throw new ShouldBeEqualException(object.getValue().toString() + ", " + expected.getValue().toString() + " are not equal");
            }
        }
        System.out.println("Should be equal validated");
    }

    @Keyword(name = "trim")
    public String trim(AbstractStafObject object, AbstractStafObject expected) throws ShouldBeEqualException {
        return object.getValue().toString().trim();
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
