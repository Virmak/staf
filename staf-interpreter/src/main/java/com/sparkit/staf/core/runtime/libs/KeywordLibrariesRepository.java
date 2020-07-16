package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.SeleniumLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.core.runtime.libs.exceptions.UndefinedBuiltinKeywordException;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class KeywordLibrariesRepository {
    private static final Logger logger = LoggerFactory.getLogger(KeywordLibrariesRepository.class);
    private final Map<String, BuiltInLibraryKeywordWrapper> builtinKeywordMap = new HashMap<>();
    @Getter
    private final Map<String, AbstractStafLibrary> libsInstancesMap = new HashMap<>();
    /* Map keyword to library method */
    private final Map<String, KeywordDeclaration> userDefinedKeywords = new HashMap<>();
    private final BuiltInLibraryFactory builtInLibraryFactory;
    private final StatementBlockExecutor statementBlockExecutor;

    public KeywordLibrariesRepository(BuiltInLibraryFactory libraryFactory, StatementBlockExecutor statementBlockExecutor) {
        this.builtInLibraryFactory = libraryFactory;
        this.statementBlockExecutor = statementBlockExecutor;
    }

    public void registerLibrary(Class<? extends AbstractStafLibrary> libClass)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {

        AbstractStafLibrary libInstance = builtInLibraryFactory.build(libClass);
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
                    builtinKeywordMap.put(keywordString, new BuiltInLibraryKeywordWrapper(libInstance, method));
                }
            }
        }
    }

    public void clearUserDefinedKeywordsMap() {
        userDefinedKeywords.clear();
    }

    public void addUserDefinedKeywords(List<KeywordDeclaration> keywordDeclarations) {
        for (KeywordDeclaration keywordDeclaration : keywordDeclarations) {
            if (isKeywordDeclared(normalizeKeywordName(keywordDeclaration.getKeywordName()))) {
                throw new KeywordAlreadyRegisteredException(keywordDeclaration.getKeywordName());
            }
            userDefinedKeywords.put(normalizeKeywordName(keywordDeclaration.getKeywordName()), keywordDeclaration);
        }
    }

    public Object invokeKeyword(MemoryMap globalSymbolsTable, KeywordCall keyword, Object[] params) throws Throwable {
        String normalizedKeywordName = normalizeKeywordName(keyword.getKeywordName());

        logger.debug("Invoking Keyword : {}", keyword);
        if (builtinKeywordMap.containsKey(normalizedKeywordName)) {
            try {
                Object ret;
                BuiltInLibraryKeywordWrapper keywordWrapper = builtinKeywordMap.get(normalizedKeywordName);
                List<Object> dependencies = injectKeywordDependencies(globalSymbolsTable, keyword, keywordWrapper);
                dependencies.addAll(Arrays.asList(params));
                ret = builtinKeywordMap.get(normalizedKeywordName).invoke(dependencies);
                statementBlockExecutor.getCallStack().pop(globalSymbolsTable.getSessionId());
                if (ret instanceof WebDriver) { // this is used by selenium library (open browser) keyword to save an instance of web driver in global sym table
                    globalSymbolsTable.setVariableValue(SeleniumLibrary.WEB_DRIVER_KEY, ret);
                    return null;
                }
                return ret;
            } catch (Exception e) {
                statementBlockExecutor.getCallStack().pop(globalSymbolsTable.getSessionId());
                throw e;
            }
        } else if (userDefinedKeywords.containsKey(normalizedKeywordName)) {
            return userDefinedKeywords.get(normalizedKeywordName).execute(statementBlockExecutor, globalSymbolsTable, this, params);
        } else {
            throw new UndefinedBuiltinKeywordException();
        }
    }

    public boolean hasLibrary(Class<?> libraryClassName) {
        return libsInstancesMap.containsKey(libraryClassName.getName());
    }

    public boolean isKeywordDeclared(String keyword) {
        String normalized = normalizeKeywordName(keyword);
        return builtinKeywordMap.containsKey(normalized) || userDefinedKeywords.containsKey(normalized);
    }

    public String normalizeKeywordName(String keyword) {
        return keyword.toLowerCase().replaceAll("\\s*", "");
    }

    private List<Object> injectKeywordDependencies(MemoryMap symbolsTable, KeywordCall keywordCall, BuiltInLibraryKeywordWrapper keywordWrapper) { // Fetch variables requested using keyword method @Inject annotation from globalSymbolsTable
        List<Object> keywordDependencies = new ArrayList<>();
        symbolsTable.setVariableValue("__keyword__", keywordCall);
        for (String dep : keywordWrapper.getInjectAnnotatedParams()) {
            keywordDependencies.add(symbolsTable.getVariableValue(dep));
        }
        return keywordDependencies;
    }
}
