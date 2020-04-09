package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;

import java.util.List;

public interface IStafScriptInterpreter {
    List<TestCaseReport> run(String currentDirectory, String testSuite, StafFile mainStafFile);
}
