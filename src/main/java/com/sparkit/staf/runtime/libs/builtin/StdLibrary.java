package com.sparkit.staf.runtime.libs.builtin;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.runtime.libs.exceptions.ShouldBeEqualException;

@StafLibrary(name = "standard", builtin = true)
public class StdLibrary extends AbstractStafLibrary {

    @Keyword(name = "should be equal")
    public void shouldBeEqual(AbstractStafObject object, AbstractStafObject expected, AbstractStafObject errorMessage) throws ShouldBeEqualException {
        if (!compareStafObjects(object, expected)) {
            if (errorMessage != null) {
                throw new ShouldBeEqualException(errorMessage.getValue().toString());
            } else {
                throw new ShouldBeEqualException(object.getValue().toString() + ", " + expected.getValue().toString()  + " are not equal");
            }
        }
        System.out.println("Should be equal validated");
    }

    public boolean compareStafObjects(AbstractStafObject object1, AbstractStafObject object2) {
        return object1.getValue().toString().equals(object2.getValue().toString());
    }
}
