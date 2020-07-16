package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.compiler.IStafCompiler;
import com.sparkit.staf.core.runtime.interpreter.ImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.TestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StafScriptLoader implements IStafScriptLoader {

    @Value("#{systemProperties['testDirectory']}")
    private final String testDirectory;
    @Autowired
    private IStafCompiler stafCompiler;
    @Autowired
    private ImportsInterpreter importsInterpreter;

    public StafScriptLoader() {
        testDirectory = System.getProperty("testDirectory");
    }

    @Override
    public void load(TestSuite testSuite, String filePath) throws Throwable {
        String currentDirectory = filePath.substring(0, filePath.lastIndexOf('/'));
        if (testSuite.getLoadedFilesList().contains(filePath)) {
            return;
        }

        StafFile stafFileAST = stafCompiler.compile(filePath);
        List<ImportStatement> imports = stafFileAST.getImports();
        Map<String, Assignment> varsMap = stafFileAST.getVariableDeclarationMap();
        List<KeywordDeclaration> keywordDeclarations = stafFileAST.getKeywordDeclarations();
        if (stafFileAST.getTestCaseDeclarationMap() != null) {
            testSuite.getTestCaseDeclarationMap().putAll(stafFileAST.getTestCaseDeclarationMap());
        }

        if (imports != null) {
            importsInterpreter.loadImports(imports, testSuite, currentDirectory, testDirectory);
        }
        if (varsMap != null) {
            testSuite.getGlobalSharedMemory().addVariablesMap(varsMap, testSuite.getKeywordLibrariesRepository());
        }
        if (keywordDeclarations != null) {
            testSuite.getKeywordLibrariesRepository().addUserDefinedKeywords(keywordDeclarations);
        }
        testSuite.getLoadedFilesList().add(filePath);
    }
}
