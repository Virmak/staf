package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.*;

import java.util.Map;

public class StafFileVisitor extends StafBaseVisitor<Object> {

    @Override
    public Object visitStaf_file(StafParser.Staf_fileContext ctx) {
        StafFile stafFile = new StafFile();
        StafParser.Suite_nameContext suiteNameCtx = ctx.suite_name();
        if (suiteNameCtx != null) {
            stafFile.setSuiteName(suiteNameCtx.string().getText());
        }
        StafParser.Imports_sectionContext imports = ctx.imports_section();
        stafFile.setImports(new ImportsSectionVisitor().visitImports_section(ctx.imports_section()));
        StafParser.Vars_sectionContext varsSection = ctx.vars_section();
        stafFile.setVariableDeclarationMap(new VariableDeclarationsSectionVisitor().visitVars_section(ctx.vars_section()));
        StafParser.Keywords_sectionContext keywordsSectionContext = ctx.keywords_section();
        stafFile.setKeywordDeclarationMap(new KeywordDeclarationsSectionVisitor().visitKeywords_section(keywordsSectionContext));
        StafParser.Test_cases_sectionContext testCasesSectionContext = ctx.test_cases_section();
        stafFile.setTestCaseDeclarationMap(new TestCaseDeclarationsSectionVisitor().visitTest_cases_section(testCasesSectionContext));
        return stafFile;
    }
}