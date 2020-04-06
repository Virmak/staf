package com.sparkit.staf.core.visitors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisitorsConfig {
    @Bean
    public VariableReferenceVisitor variableReferenceVisitor() {
        return new VariableReferenceVisitor();
    }

    @Bean
    public StafObjectVisitor stafObjectVisitor() {
        return new StafObjectVisitor();
    }

    @Bean
    public ListLiteralVisitor listLiteralVisitor() {
        return new ListLiteralVisitor();
    }

    @Bean
    public DictionaryLiteralVisitor dictionaryLiteralVisitor() {
        return new DictionaryLiteralVisitor();
    }

    @Bean
    public KeyValuePairVisitor keyValuePairVisitor() {
        return new KeyValuePairVisitor();
    }

    @Bean
    public ScalarObjectVisitor scalarObjectVisitor() {
        return new ScalarObjectVisitor();
    }

    @Bean
    public StatementVisitor statementVisitor() {
        return new StatementVisitor();
    }

    @Bean
    public ComplexObjectVisitor complexObjectVisitor() {
        return new ComplexObjectVisitor();
    }

    @Bean
    public KeywordCallVisitor keywordCallVisitor() {
        return new KeywordCallVisitor();
    }

    @Bean
    public ForStatementBodyVisitor forStatementBodyVisitor() {
        return new ForStatementBodyVisitor();
    }

    @Bean
    public KeywordDeclarationVisitor keywordDeclarationVisitor() {
        return new KeywordDeclarationVisitor();
    }

    @Bean
    public KeywordCallArgumentsVisitor keywordCallArgumentsVisitor() {
        return new KeywordCallArgumentsVisitor();
    }

    @Bean
    public KeywordBodyVisitor keywordBodyVisitor() {
        return new KeywordBodyVisitor();
    }

    @Bean
    public KeywordReturnStatementVisitor keywordReturnStatementVisitor() {
        return new KeywordReturnStatementVisitor();
    }

    @Bean
    public PrimitiveVisitor primitiveVisitor() {
        return new PrimitiveVisitor();
    }

    @Bean
    public ImportsSectionVisitor importsSectionVisitor() {
        return new ImportsSectionVisitor();
    }

    @Bean
    public ExpressionVisitor expressionVisitor() {
        return new ExpressionVisitor();
    }

    @Bean
    public AssignmentVisitor assignmentVisitor() {
        return new AssignmentVisitor();
    }

    @Bean
    public RunKeywordIfVisitor runKeywordIfVisitor() {
        return new RunKeywordIfVisitor();
    }

    @Bean
    public TestCaseDeclarationVisitor testCaseDeclarationVisitor() {
        return new TestCaseDeclarationVisitor();
    }

    @Bean
    public TestCaseBodyVisitor testCaseBodyVisitor() {
        return new TestCaseBodyVisitor();
    }

    @Bean
    public ForStatementVisitor forStatementVisitor() {
        return new ForStatementVisitor();
    }

    @Bean
    public KeywordDeclarationArgumentsVisitor keywordDeclarationArgumentsVisitor() {
        return new KeywordDeclarationArgumentsVisitor();
    }

    @Bean
    public StafFileVisitor stafFileVisitor() {
        return new StafFileVisitor();
    }

    @Bean
    public VariableDeclarationsSectionVisitor variableDeclarationsSectionVisitor() {
        return new VariableDeclarationsSectionVisitor();
    }

    @Bean
    public KeywordDeclarationsSectionVisitor keywordDeclarationsSectionVisitor() {
        return new KeywordDeclarationsSectionVisitor();
    }

    @Bean
    public TestCaseDeclarationsSectionVisitor testCaseDeclarationsSectionVisitor() {
        return new TestCaseDeclarationsSectionVisitor();
    }
}
