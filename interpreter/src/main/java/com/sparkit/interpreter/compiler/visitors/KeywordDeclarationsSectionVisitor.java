package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.KeywordDeclaration;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class KeywordDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, KeywordDeclaration>> {
    @Autowired
    private KeywordDeclarationVisitor keywordDeclarationVisitor;

    @Override
    public Map<String, KeywordDeclaration> visitKeywords_section(StafParser.Keywords_sectionContext ctx) {
        Map<String, KeywordDeclaration> keywordDeclarationMap = new HashMap<>();
        for (StafParser.Keyword_declarationContext keywordDeclarationContext : ctx.keyword_declaration()) {
            KeywordDeclaration keywordDeclaration = keywordDeclarationVisitor.visitKeyword_declaration(keywordDeclarationContext);
            keywordDeclarationMap.put(keywordDeclaration.getKeywordName(), keywordDeclaration);
        }
        return keywordDeclarationMap;
    }
}
