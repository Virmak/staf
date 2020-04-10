package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class KeywordDeclarationVisitor extends StafBaseVisitor<KeywordDeclaration> {
    @Autowired
    private KeywordDeclarationArgumentsVisitor keywordDeclarationArgumentsVisitor;
    @Autowired
    private KeywordBodyVisitor keywordBodyVisitor;
    @Autowired
    private KeywordReturnStatementVisitor keywordReturnStatementVisitor;
    @Autowired
    private StafFileVisitor stafFileVisitor;

    @Override
    public KeywordDeclaration visitKeyword_declaration(StafParser.Keyword_declarationContext ctx) {
        KeywordDeclaration keywordDeclaration = new KeywordDeclaration();
        keywordDeclaration.setFile(stafFileVisitor.getFilePath());
        keywordDeclaration.setKeywordName(ctx.keyword_name().getText());
        keywordDeclaration.setArgsList(keywordDeclarationArgumentsVisitor.visitKeyword_declaration_arguments(ctx.keyword_declaration_arguments()));
        keywordDeclaration.setStatementList(keywordBodyVisitor.visitKeyword_body(ctx.keyword_body()));
        keywordDeclaration.setReturnObject(keywordReturnStatementVisitor.visitKeyword_return_stat(ctx.keyword_return_stat()));
        return keywordDeclaration;
    }
}