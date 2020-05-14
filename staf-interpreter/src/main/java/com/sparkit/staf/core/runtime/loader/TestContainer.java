package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.runtime.interpreter.TestSuite;
import lombok.Data;

@Data
public class TestContainer { // Used to save current running test suite
    private TestSuite testSuite;
    private String file;
}
