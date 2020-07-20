package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.models.RunTestCase;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class TestSuite {
    @Getter
    private final String testSuiteName;
    @Getter
    private final MemoryMap globalSharedMemory; // shared symbols table between test sessions (threads)
    @Getter
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    @Getter
    private final List<String> loadedFilesList = new ArrayList<>();
    @Getter
    private final Map<String, RunTestCase> selectedTestCaseMap;
    @Getter
    private final String testDirectory;
    @Getter
    @Setter
    private Map<String, TestCaseDeclaration> testCaseDeclarationMap = new HashMap<>();

    public TestSuite(String testSuiteName, String testDirectory, MemoryMap globalSharedMemory,
                     KeywordLibrariesRepository keywordLibrariesRepository, Map<String, RunTestCase> selectedTestCaseMap) {
        this.testSuiteName = testSuiteName;
        this.testDirectory = testDirectory;
        this.globalSharedMemory = globalSharedMemory;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.selectedTestCaseMap = selectedTestCaseMap;
    }

    public String getFullPath() {
        return testDirectory + "/" + testSuiteName;
    }

    public List<Map.Entry<String, TestCaseDeclaration>> getSortedTestCases() {
        List<Map.Entry<String, TestCaseDeclaration>> testCasesEntryList = new ArrayList<>(testCaseDeclarationMap.entrySet());
        testCasesEntryList.sort(Comparator.comparingInt(t -> t.getValue().getOrder()));
        return testCasesEntryList;
    }
}
