package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class KeywordDeclarationsSectionVisitor extends StafBaseVisitor<List<KeywordDeclaration>> {
    @Autowired
    private KeywordDeclarationVisitor keywordDeclarationVisitor;

    @Override
    public List<KeywordDeclaration> visitKeywords_section(StafParser.Keywords_sectionContext ctx) {
        List<KeywordDeclaration> keywordDeclarations = new ArrayList<>();
        for (StafParser.Keyword_declarationContext keywordDeclarationContext : ctx.keyword_declaration()) {
            KeywordDeclaration keywordDeclaration = keywordDeclarationVisitor.visitKeyword_declaration(keywordDeclarationContext);
            keywordDeclarations.add(keywordDeclaration);
        }
        return keywordDeclarations;
    }
}
