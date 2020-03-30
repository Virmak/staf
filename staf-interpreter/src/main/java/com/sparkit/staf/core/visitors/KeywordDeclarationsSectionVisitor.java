package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.KeywordDeclaration;

import java.util.HashMap;
import java.util.Map;

public class KeywordDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, KeywordDeclaration>> {
    @Override
    public Map<String, KeywordDeclaration> visitKeywords_section(StafParser.Keywords_sectionContext ctx) {
        Map<String, KeywordDeclaration> keywordDeclarationMap = new HashMap<>();
        for (StafParser.Keyword_declarationContext keywordDeclarationContext : ctx.keyword_declaration()) {
            KeywordDeclaration keywordDeclaration = new KeywordDeclarationVisitor().visitKeyword_declaration(keywordDeclarationContext);
            keywordDeclarationMap.put(keywordDeclaration.getKeywordName(), keywordDeclaration);
        }
        return keywordDeclarationMap;
    }
}
