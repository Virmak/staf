package com.sparkit.staf.visitors;

import com.sparkit.staf.interpreter.StafBaseVisitor;
import com.sparkit.staf.interpreter.StafParser;

import java.util.ArrayList;
import java.util.List;

public class StafFileVisitor extends StafBaseVisitor<Object> {
    String suiteName;
    List<String> libImports = new ArrayList<>();

    @Override
    public Object visitStaf_file(StafParser.Staf_fileContext ctx) {
        StafParser.Suite_nameContext suiteNameCtx = ctx.suite_name();
        if (suiteNameCtx != null) {
            suiteName = suiteNameCtx.string().getText();
        }

        StafParser.Imports_sectionContext imports = ctx.imports_section();
        if (imports != null) {
            this.visitImports_section(imports);
        }


        return super.visitStaf_file(ctx);
    }

    @Override
    public Object visitImports_section(StafParser.Imports_sectionContext ctx) {
        for(StafParser.Import_statContext importStat: ctx.import_stat()) {
            libImports.add(importStat.import_obj().getText());
        }
        return super.visitImports_section(ctx);
    }

    @Override
    public Object visitVars_section(StafParser.Vars_sectionContext ctx) {
        return super.visitVars_section(ctx);
    }
}
