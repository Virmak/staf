package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.core.runtime.libs.exceptions.UndefinedBuiltinKeywordException;
import com.sparkit.staf.core.runtime.loader.TestContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KeywordLibrariesRepository {
    @Autowired
    private SymbolsTable globalSymTable;
    @Autowired
    private StatementBlockExecutor statementBlockExecutor;
    @Autowired
    private TestContainer dependencyContainer;
    @Autowired LibraryFactory libraryFactory;
    /* Map keyword to library method */
    private Map<String, KeywordDeclaration> userDefinedKeywords = new HashMap<>();;
    private Map<String, KeywordWrapper> builtinKeywordMap = new HashMap<>();;
    private Map<String, AbstractStafLibrary> libsInstancesMap = new HashMap<>();;

    public Map<String, KeywordDeclaration> getUserDefinedKeywords() {
        return userDefinedKeywords;
    }

    public void registerLibrary(Class<? extends AbstractStafLibrary> libClass)
            throws KeywordAlreadyRegisteredException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        AbstractStafLibrary libInstance = libraryFactory.build(libClass);
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
            if (isKeywordDeclared(normalizeKeywordName(keywordDeclaration.getKey()))) {
                throw new KeywordAlreadyRegisteredException(keywordDeclaration.getKey());
            }
            userDefinedKeywords.put(normalizeKeywordName(keywordDeclaration.getKey()), keywordDeclaration.getValue());
        }
    }

    public Object invokeKeyword(String keyword, Object[] params) throws Throwable {
        String normalizedKeywordName = normalizeKeywordName(keyword);
        if (builtinKeywordMap.containsKey(normalizedKeywordName)) {
            try {
                Object ret = builtinKeywordMap.get(normalizedKeywordName).invoke(params);
                statementBlockExecutor.getCallStack().pop();
                return ret;
            } catch (Exception e) {
                statementBlockExecutor.getCallStack().pop();
                throw e;
            }
        } else if (userDefinedKeywords.containsKey(normalizedKeywordName)) {
            return userDefinedKeywords.get(normalizedKeywordName).execute(statementBlockExecutor, globalSymTable, this, params);
        } else {
            throw new UndefinedBuiltinKeywordException();
        }
    }

    public boolean isKeywordDeclared(String keyword) {
        String normalized = normalizeKeywordName(keyword);
        return builtinKeywordMap.containsKey(normalized) || (userDefinedKeywords != null && userDefinedKeywords.containsKey(normalized));
    }

    public String normalizeKeywordName(String keyword) {
        return keyword.toLowerCase().replaceAll(" ", "");
    }
}
