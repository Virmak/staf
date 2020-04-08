package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.core.runtime.libs.exceptions.UndefinedBuiltinKeywordException;
import com.sparkit.staf.core.runtime.loader.TestContainer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class KeywordLibrariesRepository {
    private final SymbolsTable globalSymTable;
    private final StatementBlockExecutor statementBlockExecutor;
    /* Map keyword to library method */
    protected Map<String, KeywordDeclaration> userDefinedKeywords;
    protected Map<String, KeywordWrapper> builtinKeywordMap;
    protected Map<String, AbstractStafLibrary> libsInstancesMap;
    protected TestContainer dependencyContainer;

    public KeywordLibrariesRepository(Map<String, KeywordDeclaration> userDefinedKeywords,
                                      SymbolsTable globalSymTable,
                                      StatementBlockExecutor statementBlockExecutor,
                                      TestContainer dependencyContainer) {
        this.userDefinedKeywords = userDefinedKeywords;
        this.globalSymTable = globalSymTable;
        this.statementBlockExecutor = statementBlockExecutor;
        this.dependencyContainer = dependencyContainer;
        builtinKeywordMap = new HashMap<>();
        libsInstancesMap = new HashMap<>();
    }

    public Map<String, KeywordDeclaration> getUserDefinedKeywords() {
        return userDefinedKeywords;
    }

    public void registerLibrary(Class<? extends AbstractStafLibrary> libClass)
            throws KeywordAlreadyRegisteredException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        AbstractStafLibrary libInstance = LibraryFactory.build(libClass, dependencyContainer);
        if (libsInstancesMap.containsKey(libClass.getName())) {
            return;
        }
        libsInstancesMap.put(libClass.getName(), libInstance);
        for (Method method : libClass.getMethods()) {
            if (method.isAnnotationPresent(Keyword.class)) {
                Keyword keywordAnnotation = method.getAnnotation(Keyword.class);
                String keywordString = normalizeKeywordName(keywordAnnotation.name());
                if (builtinKeywordMap.containsKey(keywordString)) {
                    throw new KeywordAlreadyRegisteredException(keywordString);
                } else {
                    builtinKeywordMap.put(keywordString, new KeywordWrapper(libInstance, method));
                }
            }
        }
    }

    public void addUserDefinedKeywords(Map<String, KeywordDeclaration> keywordDeclarationMap)
            throws KeywordAlreadyRegisteredException {
        if (userDefinedKeywords == null) {
            userDefinedKeywords = new HashMap<>();
        }
        for (Map.Entry<String, KeywordDeclaration> keywordDeclaration : keywordDeclarationMap.entrySet()) {
            if (isKeywordDeclared(keywordDeclaration.getKey())) {
                throw new KeywordAlreadyRegisteredException(keywordDeclaration.getKey());
            }
            userDefinedKeywords.put(keywordDeclaration.getKey(), keywordDeclaration.getValue());
        }
    }

    public Object invokeKeyword(String keyword, Object[] params) throws Throwable {
        String normalizedKeywordName = normalizeKeywordName(keyword);
        if (builtinKeywordMap.containsKey(normalizedKeywordName)) {
            statementBlockExecutor.getCallStack().pop();
            return builtinKeywordMap.get(normalizedKeywordName).invoke(params);
        } else if (userDefinedKeywords.containsKey(keyword)) {
            return userDefinedKeywords.get(keyword).execute(statementBlockExecutor, globalSymTable, this, params);
        } else {
            throw new UndefinedBuiltinKeywordException();
        }
    }

    public boolean isKeywordDeclared(String keyword) {
        return builtinKeywordMap.containsKey(keyword) || (userDefinedKeywords != null && userDefinedKeywords.containsKey(keyword));
    }

    public String normalizeKeywordName(String keyword) {
        return keyword.toLowerCase().replaceAll(" ", "");
    }
}
