package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.KeywordDeclaration;

public class KeywordDeclarationVisitor extends StafBaseVisitor<KeywordDeclaration> {
    @Override
    public KeywordDeclaration visitKeyword_declaration(StafParser.Keyword_declarationContext ctx) {
        KeywordDeclaration keywordDeclaration = new KeywordDeclaration();
        keywordDeclaration.setKeywordName(ctx.keyword_name().getText());
        keywordDeclaration.setArgsList(new KeywordDeclarationArgumentsVisitor().visitKeyword_declaration_arguments(ctx.keyword_declaration_arguments()));
        keywordDeclaration.setStatementList(new KeywordBodyVisitor().visitKeyword_body(ctx.keyword_body()));
        keywordDeclaration.setReturnObject(new KeywordReturnStatement().visitKeyword_return_stat(ctx.keyword_return_stat()));
        return keywordDeclaration;
    }
}
