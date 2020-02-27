package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.ImportStatement;
import com.sparkit.staf.types.ImportsSection;

public class ImportsSectionVisitor extends StafBaseVisitor<ImportsSection> {
    @Override
    public ImportsSection visitImports_section(StafParser.Imports_sectionContext ctx) {
        ImportsSection importsSection = new ImportsSection();
        for(StafParser.Import_statContext importStat: ctx.import_stat()) {
            ImportStatement importStatement = new ImportStatement(importStat.import_obj().getText());
            importsSection.getImportStatementList().add(importStatement);
        }
        return importsSection;
    }
}
