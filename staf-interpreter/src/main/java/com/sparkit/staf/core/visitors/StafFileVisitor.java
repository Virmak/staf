package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import lombok.Getter;
import lombok.Setter;
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
    @Getter
    @Setter
    private String filePath;

    @Override
    public Object visitStaf_file(StafParser.Staf_fileContext ctx) {
        StafFile stafFile = new StafFile();
        StafParser.Suite_nameContext suiteNameCtx = ctx.suite_name();
        if (suiteNameCtx != null) {
            stafFile.setSuiteName(suiteNameCtx.string().getText().replaceAll("\"", ""));
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
            stafFile.setKeywordDeclarations(keywordDeclarationsSectionVisitor.visitKeywords_section(keywordsSectionContext));
        }
        StafParser.Test_cases_sectionContext testCasesSectionContext = ctx.test_cases_section();
        if (testCasesSectionContext != null) {
            stafFile.setTestCaseDeclarationMap(testCaseDeclarationsSectionVisitor.visitTest_cases_section(testCasesSectionContext));
        }
        return stafFile;
    }
}