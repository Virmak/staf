package com.sparkit.staf.api.controllers;

import com.sparkit.staf.api.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.api.models.ProjectConfig;
import com.sparkit.staf.api.models.request.CreateProjectRequest;
import com.sparkit.staf.api.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModelMapper mapper;

    @Value("${testDirectory}")
    String testDir;

    @CrossOrigin(origins = "*")
    @PostMapping("/projects")
    public ResponseEntity<Map<String, Object>> createProject(@RequestBody CreateProjectRequest createProjectRequest) throws IOException {
        try {
            ProjectConfig config = projectService.createProject(createProjectRequest);
        } catch (IOException | ProjectNameAlreadyExist e) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", "Project name already exists");
            return ResponseEntity.ok(res);
        }
        File projectDir = new File(testDir, ProjectService.normalizeProjectName(createProjectRequest.getName()));
        String currentDir = System.getProperty("user.dir");
        String absoluteTestDir = currentDir + "/" + testDir;
        return ResponseEntity.ok(listDirectory(projectDir, absoluteTestDir));
    }

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
