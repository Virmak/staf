package com.sparkit.staf.api.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {


    @Value("${testDirectory}")
    String testDir;

    @CrossOrigin(origins = "*")
    @GetMapping("/projects")
    public Map<String, Object> getProjects() throws IOException {
        String currentDir = System.getProperty("user.dir");
        String absoluteTestDir = currentDir + "/" + testDir;
        File projectsDir = new File(testDir);
        return listDirectory(projectsDir, absoluteTestDir);
    }

    public Map<String, Object> listDirectory(File dir, String testDir) throws IOException {
        File[] content = dir.listFiles();

        List<Map<String, String>> files = new LinkedList<>();
        List<Map<String, Object>> folders = new LinkedList<>();

        for (File f : content) {
            if (f.isDirectory()) {
                Map<String, Object> subList = listDirectory(f, testDir);
                folders.add(subList);
            } else {
                Map<String, String> file = new HashMap<>();
                file.put(f.toString().replace(testDir, "$projectRoot"), new String(Files.readAllBytes(f.toPath())));
                files.add(file);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("folders", folders);
        result.put("files", files);
        result.put("name", dir.toString().replace(testDir, "$projectRoot"));
        return result;
    }

}
