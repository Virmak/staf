package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
<<<<<<< HEAD:staf-interpreter/src/main/java/com/sparkit/staf/core/core/runtime/libs/builtin/StdLibrary.java
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;
=======
import com.sparkit.staf.core.runtime.loader.TestContainer;
>>>>>>> 7a82d8117d101f54165fa8a08889696c97e79217:staf-interpreter/src/main/java/com/sparkit/staf/core/runtime/libs/builtin/StdLibrary.java
import com.sparkit.staf.core.runtime.libs.exceptions.ShouldBeEqualException;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;

@StafLibrary(name = "standard", builtin = true)
public class StdLibrary extends AbstractStafLibrary {

    public StdLibrary(TestContainer container) {
        super(container);
    }

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
