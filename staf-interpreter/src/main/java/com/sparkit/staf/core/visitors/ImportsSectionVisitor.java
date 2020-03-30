package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.ImportStatement;

import java.util.ArrayList;
import java.util.List;

public class ImportsSectionVisitor extends StafBaseVisitor<List<ImportStatement>> {
    @Override
    public List<ImportStatement> visitImports_section(StafParser.Imports_sectionContext ctx) {
        List<ImportStatement> importStatements = new ArrayList<>();
        for (StafParser.Import_statContext importStat : ctx.import_stat()) {
            ImportStatement importStatement = new ImportStatement(importStat.import_obj().getText());
            if (importStatement.getPath().charAt(1) == '.' || importStatement.getPath().charAt(0) == '.') {
                importStatement.setType(ImportTypes.FILE);
            } else if (importStatement.getPath().matches("[\"']")) {
                importStatement.setType(ImportTypes.USER_DEFINED_LIBRARY);
            } else {
                importStatement.setType(ImportTypes.BUILT_IN_LIBRARY);
            }
            importStatements.add(importStatement);
        }
        return importStatements;
    }
}
