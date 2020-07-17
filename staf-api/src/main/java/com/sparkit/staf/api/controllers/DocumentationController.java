package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.response.docs.LibraryDocumentation;
import com.sparkit.staf.application.service.DocumentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DocumentationController {
    private final DocumentationService documentationService;

    @Autowired
    public DocumentationController(DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @GetMapping("/docs/builtin")
    public List<LibraryDocumentation> getBuiltinKeywords() {
        return documentationService.extractKeywords();
    }
}
