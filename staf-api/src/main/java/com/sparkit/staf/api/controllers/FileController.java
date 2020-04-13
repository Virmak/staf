package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${testDirectory}")
    String testDir;

    @CrossOrigin("*")
    @PostMapping("/saveFile")
    public String saveFile(@RequestBody Map<String, Object> payload) throws IOException {
        fileService.saveFile(payload.get("path").toString(), payload.get("content").toString());
        return "{\"result\":\"ok\"}";
    }

    @CrossOrigin("*")
    @GetMapping("/screenshot/{url}")
    public String imageBase64(@PathVariable String url) {
        return "ok";
    }
}
