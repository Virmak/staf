package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.ImportStatement;

import java.util.ArrayList;
import java.util.List;

public class ImportsSectionVisitor extends StafBaseVisitor<List<ImportStatement>> {
    @Override
    public List<ImportStatement> visitImports_section(StafParser.Imports_sectionContext ctx) {
        List<ImportStatement> importStatements = new ArrayList<>();
        for (StafParser.Import_statContext importStat : ctx.import_stat()) {
            ImportStatement importStatement = new ImportStatement(importStat.import_obj().getText());
            importStatements.add(importStatement);
        }
        return importStatements;
    }
}
