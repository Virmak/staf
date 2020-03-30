package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.KeywordDeclaration;

public class KeywordDeclarationVisitor extends StafBaseVisitor<KeywordDeclaration> {
    @Override
    public KeywordDeclaration visitKeyword_declaration(StafParser.Keyword_declarationContext ctx) {
        KeywordDeclaration keywordDeclaration = new KeywordDeclaration();
        keywordDeclaration.setKeywordName(ctx.keyword_name().getText().toLowerCase().replaceAll(" ", ""));
        keywordDeclaration.setArgsList(new KeywordDeclarationArgumentsVisitor().visitKeyword_declaration_arguments(ctx.keyword_declaration_arguments()));
        keywordDeclaration.setStatementList(new KeywordBodyVisitor().visitKeyword_body(ctx.keyword_body()));
        keywordDeclaration.setReturnObject(new KeywordReturnStatement().visitKeyword_return_stat(ctx.keyword_return_stat()));
        return keywordDeclaration;
    }
}
