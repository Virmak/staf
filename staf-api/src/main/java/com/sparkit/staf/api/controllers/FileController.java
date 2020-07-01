package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.response.ImageBase64;
import com.sparkit.staf.application.service.FileService;
import com.sparkit.staf.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
public class FileController {
    private final FileService fileService;
    private final ProjectService projectService;
    @Value("${testDirectory}")
    private String testDir;

    @Autowired
    public FileController(FileService fileService, ProjectService projectService) {
        this.fileService = fileService;
        this.projectService = projectService;
    }

    @CrossOrigin("*")
    @PostMapping("/saveFile")
    public String saveFile(@RequestBody Map<String, Object> payload) throws IOException {
        fileService.saveFile(payload.get("path").toString(), payload.get("content").toString(),
                payload.get("type").toString());
        return "{\"result\":\"ok\"}";
    }

    @CrossOrigin("*")
    @DeleteMapping("/deleteFile/{path}")
    public String deleteFile(@PathVariable String path) {
        path = path.replace("<sep>", "/");
        if (fileService.removeFile(path)) {
            return "{\"result\":\"ok\"}";
        }
        return "{\"result\":\"error\"}";
    }

    @CrossOrigin("*")
    @GetMapping("/screenshot/{url}")
    public ImageBase64 imageBase64(@PathVariable String url) {
        String screenShotPath = url.replace("<sep>", "/");
        File file = new File(screenShotPath);
        ImageBase64 imageBase64 = new ImageBase64();
        imageBase64.setFileName(screenShotPath.substring(screenShotPath.lastIndexOf('/')));
        imageBase64.setImageData(projectService.readImageBase64(file));
        return imageBase64;
    }
}
