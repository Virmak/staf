package com.sparkit.interpreter.runtime;

import com.sparkit.interpreter.compiler.ast.StafFile;
import com.sparkit.interpreter.compiler.ast.TestCaseDeclaration;
import com.sparkit.interpreter.runtime.libs.KeywordLibrariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StafInterpreter {
    @Autowired
    private StafFileLoader stafFileLoader;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private SymbolsTable globalSymTable;
    @Autowired
    private CallStack callStack;
    @Autowired
    private TestCasesInterpreter testCasesInterpreter;

    public void run(String filePath) throws Throwable {
        keywordLibrariesRepository.init();
        globalSymTable.init();
        stafFileLoader.init();
        callStack.init();
        StafFile mainFile = stafFileLoader.load(filePath);
        List<TestCaseDeclaration> testCaseDeclarationList = new ArrayList<>(mainFile.getTestCaseDeclarationMap().values());
        testCasesInterpreter.sortTestCasesByOrder(testCaseDeclarationList);

        for (TestCaseDeclaration testCase : testCaseDeclarationList) {
            testCasesInterpreter.execute(testCase);
        }
    }
}
