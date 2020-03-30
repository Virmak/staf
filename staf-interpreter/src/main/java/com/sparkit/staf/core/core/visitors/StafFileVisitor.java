package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

public class StafFileVisitor extends StafBaseVisitor<Object> {

    @Override
    public Object visitStaf_file(StafParser.Staf_fileContext ctx) {
        StafFile stafFile = new StafFile();
        StafParser.Suite_nameContext suiteNameCtx = ctx.suite_name();
        if (suiteNameCtx != null) {
            stafFile.setSuiteName(suiteNameCtx.string().getText());
        }
        StafParser.Imports_sectionContext importsSection = ctx.imports_section();
        if (importsSection != null) {
            stafFile.setImports(new ImportsSectionVisitor().visitImports_section(importsSection));
        }
        StafParser.Vars_sectionContext varsSection = ctx.vars_section();
        if (varsSection != null) {
            stafFile.setVariableDeclarationMap(new VariableDeclarationsSectionVisitor().visitVars_section(varsSection));
        }
        StafParser.Keywords_sectionContext keywordsSectionContext = ctx.keywords_section();
        if (keywordsSectionContext != null) {
            stafFile.setKeywordDeclarationMap(new KeywordDeclarationsSectionVisitor().visitKeywords_section(keywordsSectionContext));
        }
        StafParser.Test_cases_sectionContext testCasesSectionContext = ctx.test_cases_section();
        if (testCasesSectionContext != null) {
            stafFile.setTestCaseDeclarationMap(new TestCaseDeclarationsSectionVisitor().visitTest_cases_section(testCasesSectionContext));
        }
        return stafFile;
    }
}