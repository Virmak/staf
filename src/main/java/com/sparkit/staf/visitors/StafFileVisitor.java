package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.Assignment;
import com.sparkit.staf.types.ImportsSection;
import com.sparkit.staf.types.StafObject;

import java.util.Map;

public class StafFileVisitor extends StafBaseVisitor<Object> {
    String suiteName;
    ImportsSection importsSection;
    Map<String, Assignment> variablesSection;

    @Override
    public Object visitStaf_file(StafParser.Staf_fileContext ctx) {
        StafParser.Suite_nameContext suiteNameCtx = ctx.suite_name();
        if (suiteNameCtx != null) {
            suiteName = suiteNameCtx.string().getText();
        }
        StafParser.Imports_sectionContext imports = ctx.imports_section();
        importsSection = new ImportsSectionVisitor().visitImports_section(ctx.imports_section());
        StafParser.Vars_sectionContext varsSection = ctx.vars_section();
        variablesSection = new VariableDeclarationsSectionVisitor().visitVars_section(ctx.vars_section());

        return super.visitStaf_file(ctx);
    }
}
