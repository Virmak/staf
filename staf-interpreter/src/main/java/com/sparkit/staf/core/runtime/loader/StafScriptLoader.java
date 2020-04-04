package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.ImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafScriptLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StafScriptLoader implements IStafScriptLoader {

    private final IStafCompiler stafCompiler;
    private final SymbolsTable globalSymTable;
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    private final List<String> loadedFilesList = new ArrayList<>();

    public StafScriptLoader(IStafCompiler stafCompiler, SymbolsTable globalSymTable,
                            KeywordLibrariesRepository keywordLibrariesRepository) {
        this.stafCompiler = stafCompiler;
        this.globalSymTable = globalSymTable;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
    }

    @Override
    public void load(String filePath, ImportsInterpreter importsInterpreter) throws Throwable {
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
            importsInterpreter.loadImports(imports, currentDirectory);
        }
        if (varsMap != null) {
            globalSymTable.addVariablesMap(varsMap, keywordLibrariesRepository);
        }
        if (keywordsMap != null) {
            keywordLibrariesRepository.addUserDefinedKeywords(keywordsMap);
        }
        loadedFilesList.add(filePath);
    }
}
