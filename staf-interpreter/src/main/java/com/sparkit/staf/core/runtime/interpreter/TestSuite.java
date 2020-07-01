package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class TestSuite {
    @Getter
    private final String testSuiteName;
    @Getter
    @Setter
    private String testDirectory;
    @Getter
    private final SymbolsTable globalSharedSymbolsTable; // shared symbols table between test sessions (threads)
    @Getter
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    @Getter
    private final List<String> loadedFilesList = new ArrayList<>();
    @Getter
    @Setter
    private Map<String, TestCaseDeclaration> testCaseDeclarationMap = new HashMap<>();

    public TestSuite(String testSuiteName, String testDirectory, SymbolsTable symbolsTable,
                     KeywordLibrariesRepository keywordLibrariesRepository) {
        this.testSuiteName = testSuiteName;
        this.testDirectory = testDirectory;
        this.globalSharedSymbolsTable = symbolsTable;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
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
