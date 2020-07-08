package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.response.docs.KeywordDocumentation;
import com.sparkit.staf.application.models.response.docs.LibraryDocumentation;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.BuiltInLibraryFactory;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DocumentationService {
    private final BuiltInLibraryFactory libraryFactory;

    @Autowired
    public DocumentationService(BuiltInLibraryFactory libraryFactory) {
        this.libraryFactory = libraryFactory;
    }

    public List<LibraryDocumentation> extractKeywords() {
        List<LibraryDocumentation> libraryDocumentationList = new ArrayList<>();

        Map<String, Class<? extends AbstractStafLibrary>> builtinLibrariesClasses = libraryFactory.getBuiltinLibrariesClasses();
        for (Class<? extends AbstractStafLibrary> libraryClass : builtinLibrariesClasses.values()) {
            libraryDocumentationList.add(getLibraryKeywords(libraryClass));
        }
        return libraryDocumentationList;
    }

    private LibraryDocumentation getLibraryKeywords(Class<? extends AbstractStafLibrary> libraryClass) {
        LibraryDocumentation libraryDocumentation = new LibraryDocumentation();
        StafLibrary libraryClassAnnotation = libraryClass.getAnnotation(StafLibrary.class);
        libraryDocumentation.setLibraryName(libraryClassAnnotation.name());
        libraryDocumentation.setKeywords(new ArrayList<>());

        for (Method method : libraryClass.getMethods()) {
            if (method.isAnnotationPresent(Keyword.class)) {
                Keyword keyword = method.getAnnotation(Keyword.class);
                KeywordDocumentation keywordDocumentation = new KeywordDocumentation();
                keywordDocumentation.setName(keyword.name());
                keywordDocumentation.setDescription(keyword.doc());
                Parameter[] parameters = method.getParameters();
                List<KeywordDocumentation.KeywordParameter> keywordParameters = Arrays.stream(parameters)
                        .filter(parameter -> AbstractStafObject.class.isAssignableFrom(parameter.getType()))
                        .map(p -> new KeywordDocumentation.KeywordParameter(p.getName(), p.getType().getName()))
                        .collect(Collectors.toList());
                keywordDocumentation.setParameters(keywordParameters);
                libraryDocumentation.getKeywords().add(keywordDocumentation);
            }
        }
        return libraryDocumentation;
    }

}
