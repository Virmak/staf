package com.sparkit.staf.runtime.libs;

import com.sparkit.staf.ast.KeywordDeclaration;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.runtime.libs.exceptions.UndefinedBuiltinKeywordException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class KeywordLibrariesRepository {
    private final SymbolsTable globalSymTable;
    /* Map keyword to library method */
    protected Map<String, KeywordDeclaration> userDefinedKeywords;
    protected Map<String, KeywordWrapper> builtinKeywordMap;
    protected Map<String, AbstractStafLibrary> libsInstancesMap;

    public KeywordLibrariesRepository(Map<String, KeywordDeclaration> userDefinedKeywords, SymbolsTable globalSymTable) throws NoSuchMethodException, KeywordAlreadyRegisteredException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.userDefinedKeywords = userDefinedKeywords;
        this.globalSymTable = globalSymTable;
        builtinKeywordMap = new HashMap<>();
        libsInstancesMap = new HashMap<>();

    }

    public Map<String, KeywordDeclaration> getUserDefinedKeywords() {
        return userDefinedKeywords;
    }

    public void registerLibrary(Class<? extends AbstractStafLibrary> libClass) throws KeywordAlreadyRegisteredException,
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AbstractStafLibrary libInstance = LibraryFactory.build(libClass);
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

    public KeywordWrapper getBuiltInKeywordByName(String keyword) throws UndefinedBuiltinKeywordException {
        String normalizedKeywordName = normalizeKeywordName(keyword);
        if (!builtinKeywordMap.containsKey(normalizedKeywordName) && !userDefinedKeywords.containsKey(keyword)) {
            throw new UndefinedBuiltinKeywordException();
        }
        return builtinKeywordMap.get(normalizedKeywordName);
    }

    public Object invokeKeyword(String keyword, Object[] params) throws Exception {
        String normalizedKeywordName = normalizeKeywordName(keyword);
        if (builtinKeywordMap.containsKey(keyword)) {
            return builtinKeywordMap.get(normalizedKeywordName).invoke(params);
        } else if (userDefinedKeywords.containsKey(keyword)) {
            return userDefinedKeywords.get(keyword).execute(globalSymTable, this, params);
        } else {
            throw new UndefinedBuiltinKeywordException();
        }
    }

    public boolean isKeywordDeclared(String keyword) {
        return builtinKeywordMap.containsKey(keyword) || userDefinedKeywords.containsKey(keyword);
    }

    public String normalizeKeywordName(String keyword) {
        return keyword.toLowerCase().replaceAll(" ", "");
    }
}