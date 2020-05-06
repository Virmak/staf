package com.sparkit.interpreter.runtime.libs;

import com.sparkit.interpreter.compiler.ast.KeywordDeclaration;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.CallStack;
import com.sparkit.interpreter.runtime.evaluator.statement.block.IStatementBlockExecutor;
import com.sparkit.interpreter.runtime.libs.annotations.Keyword;
import com.sparkit.interpreter.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.interpreter.runtime.libs.exceptions.UndefinedBuiltinKeywordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class KeywordLibrariesRepository {
    @Autowired
    private LibraryFactory libraryFactory;
    @Autowired
    private IStatementBlockExecutor<KeywordDeclaration> userKeywordExecutor;
    @Autowired
    private CallStack callStack;
    /* Map keyword to library method */
    private Map<String, KeywordWrapper> builtinKeywordMap = new HashMap<>();

    private Map<String, KeywordDeclaration> userDefinedKeywords = new HashMap<>();

    private Map<String, AbstractStafLibrary> libsInstancesMap = new HashMap<>();

    public void init() {
        builtinKeywordMap = new HashMap<>();
        userDefinedKeywords = new HashMap<>();
        libsInstancesMap = new HashMap<>();
    }

    public Map<String, KeywordDeclaration> getUserDefinedKeywords() {
        return userDefinedKeywords;
    }

    public void registerLibrary(Class<? extends AbstractStafLibrary> libClass)
            throws KeywordAlreadyRegisteredException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (libsInstancesMap.containsKey(libClass.getName())) {
            return;
        }
        AbstractStafLibrary libInstance = libraryFactory.build(libClass);
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

    public AbstractStafObject invokeKeyword(String keyword, Object[] params) throws Throwable {
        String normalizedKeywordName = normalizeKeywordName(keyword);
        if (builtinKeywordMap.containsKey(normalizedKeywordName)) {
            try {
                return (AbstractStafObject) builtinKeywordMap.get(normalizedKeywordName).invoke(params);
            } catch (Exception e) {
                throw e;
            }
        } else if (userDefinedKeywords.containsKey(normalizedKeywordName)) {
            return userKeywordExecutor.execute(userDefinedKeywords.get(normalizedKeywordName), null);
        } else {
            throw new UndefinedBuiltinKeywordException();
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

    public boolean isKeywordDeclared(String keyword) {
        String normalized = normalizeKeywordName(keyword);
        return builtinKeywordMap.containsKey(normalized) || (userDefinedKeywords != null && userDefinedKeywords.containsKey(normalized));
    }

    public String normalizeKeywordName(String keyword) {
        return keyword.toLowerCase().replaceAll(" ", "");
    }
}
