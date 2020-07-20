package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.response.docs.KeywordDocumentation;
import com.sparkit.staf.application.models.response.docs.LibraryDocumentation;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.BuiltInLibraryFactory;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.utils.SharedConstants;
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
        libraryDocumentation.setImportName(extractLibraryImportName(libraryClass.getName()));
        libraryDocumentation.setKeywords(new ArrayList<>());

        for (Method method : libraryClass.getMethods()) {
            if (method.isAnnotationPresent(Keyword.class)) {
                Keyword keyword = method.getAnnotation(Keyword.class);
                KeywordDocumentation keywordDocumentation = new KeywordDocumentation();
                keywordDocumentation.setName(keyword.name());
                keywordDocumentation.setDescription(keyword.doc());
                keywordDocumentation.setReturnType(convertType(method.getReturnType().getName()));
                Parameter[] parameters = method.getParameters();
                List<KeywordDocumentation.KeywordParameter> keywordParameters = Arrays.stream(parameters)
                        .filter(parameter -> parameter.isAnnotationPresent(KeywordArgument.class))
                        .map(p -> {
                            KeywordArgument keywordArgument = p.getAnnotation(KeywordArgument.class);
                            return new KeywordDocumentation.KeywordParameter(keywordArgument.name(),
                                    convertType(p.getType().getName()), keywordArgument.optional());
                        })
                        .collect(Collectors.toList());
                keywordDocumentation.setParameters(keywordParameters);
                libraryDocumentation.getKeywords().add(keywordDocumentation);
            }
        }
        return libraryDocumentation;
    }

    private String convertType(String type) {
        return type.substring(type.lastIndexOf('.') + 1).replaceAll("(Abstract)?Staf", "")
                .toLowerCase();
    }

    private String extractLibraryImportName(String libraryClass) {
        return libraryClass.substring(libraryClass.lastIndexOf('.') + 1).replace(SharedConstants.LIBRARY, "")
                .toLowerCase();
    }

}
