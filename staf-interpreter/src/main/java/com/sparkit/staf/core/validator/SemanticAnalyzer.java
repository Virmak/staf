package com.sparkit.staf.core.validator;

import com.sparkit.staf.core.ast.*;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.SemanticError;
import com.sparkit.staf.core.runtime.libs.BuiltInLibraryFactory;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.core.runtime.libs.exceptions.LibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class SemanticAnalyzer {
    @Autowired
    private BuiltInLibraryFactory libraryFactory;
    @Value("${testDirectory}")
    private String testDirectory;

    public void validateSemantics(StafFile mainFile, Map<String, StafFile> stafFileMap)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        validateStafFile(mainFile, stafFileMap);
    }

    public void validateStafFile(StafFile currentFile, Map<String, StafFile> stafFileMap) throws IllegalAccessException,
            InvocationTargetException, InstantiationException {
        List<KeywordCall> fileKeywordCalls = extractStafFileKeywordCalls(currentFile);
        KeywordLibrariesRepository keywordLibrariesRepository = buildKeywordRepository(currentFile, stafFileMap);
        fileKeywordCalls.forEach(keywordCall -> {
            if (!keywordLibrariesRepository.isKeywordDeclared(keywordCall.getKeywordName())) {
                if (currentFile.getSemanticErrors() == null) {
                    currentFile.setSemanticErrors(new ArrayList<>());
                }
                currentFile.getSemanticErrors().add(new SemanticError(keywordCall.getPosition(), "Cannot find keyword '" + keywordCall.getKeywordName() + "'"));
            }
        });
    }

    private KeywordLibrariesRepository buildKeywordRepository(StafFile currentStafFile, Map<String, StafFile> stafFileMap)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        File currentDirectoryFile = new File(currentStafFile.getFilePath()).getParentFile();

        Map<String, KeywordDeclaration> userKeywordDeclarationMap = new HashMap<>();
        KeywordLibrariesRepository keywordLibrariesRepository = new KeywordLibrariesRepository(libraryFactory, null);
        if (currentStafFile.getImports() != null) {
            for (ImportStatement importStatement : currentStafFile.getImports()) {
                if (importStatement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                    String libClassName = importStatement.getPath().substring(0, 1).toUpperCase()
                            + importStatement.getPath().toLowerCase().substring(1) + "Library";
                    try {
                        keywordLibrariesRepository.registerLibrary(libraryFactory.getBuiltinLibrariesClasses().get(libClassName));
                    } catch (LibraryNotFoundException e) {
                        currentStafFile.getSemanticErrors().add(new SemanticError(importStatement.getTokenPosition(), "Library '" + importStatement.getPath() + "' not found"));
                    }
                } else if (importStatement.getType() == ImportTypes.FILE) {
                    try {
                        String importAbsolutePath = new File(currentDirectoryFile, importStatement.getPath()).getCanonicalPath();
                        importAbsolutePath = getRelativePathToTestDirectory(importAbsolutePath);
                        if (stafFileMap.containsKey(importAbsolutePath) && stafFileMap.get(importAbsolutePath).getKeywordDeclarationMap() != null) {
                            userKeywordDeclarationMap.putAll(stafFileMap.get(importAbsolutePath).getKeywordDeclarationMap());
                        }
                    } catch (IOException ignored) {

                    }
                }
            }
        }
        if (currentStafFile.getKeywordDeclarationMap() != null) {
            userKeywordDeclarationMap.putAll(currentStafFile.getKeywordDeclarationMap());
        }
        try {
            keywordLibrariesRepository.addUserDefinedKeywords(userKeywordDeclarationMap);
        } catch (KeywordAlreadyRegisteredException e) {
            KeywordDeclaration keywordWithError = userKeywordDeclarationMap.get(e.getKeywordName());
            stafFileMap.get(getRelativePathToTestDirectory(keywordWithError.getTokenPosition().getFilePath()))
                    .getSemanticErrors().add(new SemanticError(keywordWithError.getTokenPosition(), e.getMessage()));
        }
        return keywordLibrariesRepository;
    }

    private List<KeywordCall> extractStafFileKeywordCalls(StafFile currentStafFile) {
        List<KeywordCall> fileKeywordCalls = new ArrayList<>();
        if (currentStafFile.getVariableDeclarationMap() != null) {
            fileKeywordCalls.addAll(currentStafFile.getVariableDeclarationMap().values().stream()
                    .map(this::extractKeywordCalls)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList()));
        }
        if (currentStafFile.getKeywordDeclarationMap() != null) {
            fileKeywordCalls.addAll(currentStafFile.getKeywordDeclarationMap().values().stream()
                    .map(KeywordDeclaration::getStatementList)
                    .flatMap(Collection::stream)
                    .map(this::extractKeywordCalls)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList()));
        }
        if (currentStafFile.getTestCaseDeclarationMap() != null) {
            fileKeywordCalls.addAll(currentStafFile.getTestCaseDeclarationMap().values().stream()
                    .map(TestCaseDeclaration::getStatements)
                    .flatMap(Collection::stream)
                    .map(this::extractKeywordCalls)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList()));
        }
        return fileKeywordCalls;
    }

    private List<KeywordCall> extractKeywordCalls(IStatement statement) {
        List<KeywordCall> keywordCalls = new ArrayList<>();
        if (statement instanceof KeywordCall) {
            keywordCalls.addAll(extractKeywordCallsFromStafObject((KeywordCall) statement));
        } else if (statement instanceof Assignment) {
            Assignment assignment = (Assignment) statement;
            keywordCalls.addAll(extractKeywordCallsFromStafObject(assignment.getRightHandSide()));
        } else if (statement instanceof RunKeywordIf) {
            RunKeywordIf runKeywordIfStatement = (RunKeywordIf) statement;
            keywordCalls.addAll(extractKeywordCallsFromStafObject(runKeywordIfStatement.getCondition()));
            keywordCalls.addAll(extractKeywordCallsFromStafObject(runKeywordIfStatement.getKeywordCall()));
        } else if (statement instanceof ExitLoopStatement) {
            ExitLoopStatement exitLoopStatement = (ExitLoopStatement) statement;
            keywordCalls.addAll(extractKeywordCallsFromStafObject(exitLoopStatement.getCondition()));
        } else if (statement instanceof ForStatement) {
            ForStatement forStatement = (ForStatement) statement;
            keywordCalls.addAll(extractKeywordCallsFromStafObject(forStatement.getIterator()));
            keywordCalls.addAll(forStatement.getStatements().stream()
                    .map(this::extractKeywordCalls)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList()));
        }
        return keywordCalls;
    }

    private List<KeywordCall> extractKeywordCallsFromStafObject(AbstractStafObject stafObject) {
        List<KeywordCall> keywordCalls = new ArrayList<>();
        if (stafObject instanceof Expression) {
            Expression expression = (Expression) stafObject;
            if (expression.getExpressionLeftMember() instanceof KeywordCall) {
                keywordCalls.add((KeywordCall) expression.getExpressionLeftMember());
            } else if (expression.getExpressionLeftMember() instanceof Expression) {
                keywordCalls.addAll(extractKeywordCallsFromStafObject(expression.getExpressionLeftMember()));
            }
            if (expression.getExpressionRightMember() instanceof KeywordCall) {
                keywordCalls.add((KeywordCall) expression.getExpressionRightMember());
            } else if (expression.getExpressionRightMember() instanceof Expression) {
                keywordCalls.addAll(extractKeywordCallsFromStafObject(expression.getExpressionRightMember()));
            }
        } else if (stafObject instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) stafObject;
            keywordCalls.add(keywordCall);
            keywordCalls.addAll(keywordCall.getArgumentsList().stream()
                    .map(this::extractKeywordCallsFromStafObject)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList()));
        }
        return keywordCalls;
    }

    private String getRelativePathToTestDirectory(String path) {
        return path.substring(path.indexOf(testDirectory));
    }
}
