package com.sparkit.staf.api.controllers;

import com.sparkit.staf.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;


    @Value("${testDirectory}")
    String testDir;

    @CrossOrigin("*")
    @PostMapping("/saveFile")
    public String saveFile(@RequestBody Map<String, Object> payload) {
        fileService.saveFile(payload.get("path").toString(), payload.get("content").toString());
        return "{\"result\":\"ok\"}";
    }
}
