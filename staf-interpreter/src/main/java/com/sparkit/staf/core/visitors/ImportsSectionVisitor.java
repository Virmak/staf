package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.ast.TokenPosition;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ImportsSectionVisitor extends StafBaseVisitor<List<ImportStatement>> {
    @Autowired
    private StafFileVisitor stafFileVisitor;

    @Override
    public List<ImportStatement> visitImports_section(StafParser.Imports_sectionContext ctx) {
        List<ImportStatement> importStatements = new ArrayList<>();
        for (StafParser.Import_statContext importStat : ctx.import_stat()) {

            TokenPosition tokenPosition = new TokenPosition(
                    importStat.import_obj().getStart().getLine(),
                    importStat.import_obj().getStart().getCharPositionInLine(),
                    importStat.import_obj().getStart().getStartIndex(),
                    importStat.import_obj().getStop().getStopIndex(),
                    stafFileVisitor.getFilePath());

            ImportStatement importStatement = new ImportStatement(importStat.import_obj().getText(), tokenPosition);
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
