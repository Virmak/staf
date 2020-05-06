package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.StafFile;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class StafFileVisitor extends StafBaseVisitor<Object> {
    @Autowired
    private ImportsSectionVisitor importsSectionVisitor;
    @Autowired
    private VariableDeclarationsSectionVisitor variableDeclarationsSectionVisitor;
    @Autowired
    private KeywordDeclarationsSectionVisitor keywordDeclarationsSectionVisitor;
    @Autowired
    private TestCaseDeclarationsSectionVisitor testCaseDeclarationsSectionVisitor;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Object visitStaf_file(StafParser.Staf_fileContext ctx) {
        StafFile stafFile = new StafFile();
        StafParser.Suite_nameContext suiteNameCtx = ctx.suite_name();
        if (suiteNameCtx != null) {
            stafFile.setSuiteName(suiteNameCtx.string().getText());
        }
        StafParser.Imports_sectionContext importsSection = ctx.imports_section();
        if (importsSection != null) {
            stafFile.setImports(importsSectionVisitor.visitImports_section(importsSection));
        }
        StafParser.Vars_sectionContext varsSection = ctx.vars_section();
        if (varsSection != null) {
            stafFile.setVariableDeclarationMap(variableDeclarationsSectionVisitor.visitVars_section(varsSection));
        }
        StafParser.Keywords_sectionContext keywordsSectionContext = ctx.keywords_section();
        if (keywordsSectionContext != null) {
            stafFile.setKeywordDeclarationMap(keywordDeclarationsSectionVisitor.visitKeywords_section(keywordsSectionContext));
        }
        StafParser.Test_cases_sectionContext testCasesSectionContext = ctx.test_cases_section();
        if (testCasesSectionContext != null) {
            stafFile.setTestCaseDeclarationMap(testCaseDeclarationsSectionVisitor.visitTest_cases_section(testCasesSectionContext));
        }
        return stafFile;
    }
}