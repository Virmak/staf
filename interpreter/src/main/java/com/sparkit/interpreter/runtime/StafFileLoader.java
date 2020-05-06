package com.sparkit.interpreter.runtime;

import com.sparkit.interpreter.compiler.StafFileCompiler;
import com.sparkit.interpreter.compiler.ast.KeywordDeclaration;
import com.sparkit.interpreter.compiler.ast.StafFile;
import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.ast.statement.ImportStatement;
import com.sparkit.interpreter.runtime.libs.KeywordLibrariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StafFileLoader {
    @Autowired
    private StafFileCompiler compiler;
    @Autowired
    private ImportsInterpreter importsInterpreter;
    @Autowired
    private SymbolsTable globalSymTable;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;

    private Map<String, StafFile> loadedFilesMap;

    public StafFile load(String filePath) throws Throwable {
        String absolutePath = new File(filePath).getAbsolutePath();
        String currentDir = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        if (loadedFilesMap.containsKey(absolutePath)) {
            return loadedFilesMap.get(absolutePath);
        }
        StafFile fileAst = compiler.compile(absolutePath);
        loadedFilesMap.put(absolutePath, fileAst);
        List<ImportStatement> imports = fileAst.getImports();
        if (imports != null) {
            importsInterpreter.loadImports(imports, currentDir);
        }
        Map<String, Assignment> variableDeclarationMap = fileAst.getVariableDeclarationMap();
        if (variableDeclarationMap != null) {
            globalSymTable.addVariablesMap(variableDeclarationMap);
        }
        Map<String, KeywordDeclaration> keywordsMap = fileAst.getKeywordDeclarationMap();
        if (keywordsMap != null) {
            keywordLibrariesRepository.addUserDefinedKeywords(keywordsMap);
        }
        return fileAst;
    }

    public void init() {
        loadedFilesMap = new HashMap<>();
    }
}
