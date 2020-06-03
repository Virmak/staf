package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.ImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StafScriptLoader implements IStafScriptLoader {

    @Autowired
    private IStafCompiler stafCompiler;
    @Autowired
    private SymbolsTable globalSymTable;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private ImportsInterpreter importsInterpreter;

    private final List<String> loadedFilesList = new ArrayList<>();
    @Value("#{systemProperties['testDirectory']}")
    private final String testDirectory;

    public StafScriptLoader() {
        testDirectory = System.getProperty("testDirectory");
    }

    @Override
    public void load(String filePath) throws Throwable {
        String currentDirectory = filePath.substring(0, filePath.lastIndexOf("/"));
        if (loadedFilesList.contains(filePath)) {
            return;
        }
        System.out.println("Parsing : " + filePath);
        StafFile stafFileAST = stafCompiler.compile(filePath);
        List<ImportStatement> imports = stafFileAST.getImports();
        Map<String, Assignment> varsMap = stafFileAST.getVariableDeclarationMap();
        Map<String, KeywordDeclaration> keywordsMap = stafFileAST.getKeywordDeclarationMap();
        if (imports != null) {
            importsInterpreter.loadImports(imports, currentDirectory, testDirectory);
        }
        if (varsMap != null) {
            globalSymTable.addVariablesMap(varsMap);
        }
        if (keywordsMap != null) {
            keywordLibrariesRepository.addUserDefinedKeywords(keywordsMap);
        }
        loadedFilesList.add(filePath);
    }
}
