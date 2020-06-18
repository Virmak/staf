package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.response.ImageBase64;
import com.sparkit.staf.application.service.FileService;
import com.sparkit.staf.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private ProjectService projectService;
    @Value("${testDirectory}")
    String testDir;

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
        path = path.replace("<sep>","/");
        if (fileService.removeFile(path)) {
            return "{\"result\":\"ok\"}";
        }
        return "{\"result\":\"error\"}";
    }

    @CrossOrigin("*")
    @GetMapping("/screenshot/{url}")
    public ImageBase64 imageBase64(@PathVariable String url) {
        String screenShotPath = url.replaceAll("<sep>", "/");
        File file = new File(screenShotPath);
        ImageBase64 imageBase64 = new ImageBase64();
        imageBase64.setFileName(screenShotPath.substring(screenShotPath.lastIndexOf('/')));
        imageBase64.setImageData(projectService.readImageBase64(file));
        return imageBase64;
    }

    private boolean isChild(String path) {
        Path parent = Paths.get(testDir).toAbsolutePath();
        Path child = Paths.get(path).toAbsolutePath();
        return child.startsWith(parent);
    }
}
