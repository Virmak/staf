package com.sparkit.staf.api.service;

import com.sparkit.staf.api.application.IProjectBuilder;
import com.sparkit.staf.api.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.api.exception.TestDirectoryNotFound;
import com.sparkit.staf.api.models.ProjectConfig;
import com.sparkit.staf.api.models.request.CreateProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ProjectService {
    @Autowired
    private IProjectBuilder projectBuilder;

    @Value("${testDirectory}")
    private String projectsDirPath;

    public static String normalizeProjectName(String name) {
        return name.toLowerCase().replaceAll("\\s+", "-");
    }

    public List<String> readProjects() throws TestDirectoryNotFound {
        File currentDir = new File(System.getProperty("user.dir"));
        File projectsDir = new File(currentDir, projectsDirPath);
        List<String> projects = new ArrayList<>();
        File[] files = projectsDir.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(f -> projects.add(f.getName()));
        } else {
            throw new TestDirectoryNotFound(projectsDirPath);
        }
        return projects;
    }

    public ProjectConfig createProject(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist {
        return projectBuilder.build(createProjectRequest);
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
                file.put(f.toString().replace(testDir, "$projectRoot"), readFileContent(f));
                files.add(file);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("folders", folders);
        result.put("files", files);
        result.put("name", dir.toString().replace(testDir, "$projectRoot"));
        return result;
    }

    private String readFileContent(File f) {
        String fileExtension = getFileExtension(f);
        switch (fileExtension) {
            case "png":
            case "jpg":
            case "jpeg":
                return readImageBase64(f);
            case "staf":
            case "page":
            case "step":
            case "steps":
            case "txt":
            case "json":
            case "log":
                return readTextFile(f);
            default:
                return "Error : Unsupported file format!";
        }
    }

    private String readImageBase64(File f) {
        String encodedFile = null;
        FileInputStream fileInputStreamReader = null;
        try {
            fileInputStreamReader = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Error reading file";
        }
        byte[] bytes = new byte[(int) f.length()];
        try {
            fileInputStreamReader.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file";
        }
        encodedFile = Base64.getEncoder().encodeToString(bytes);
        return encodedFile;
    }

    private String readTextFile(File f) {
        try {
            return new String(Files.readAllBytes(Paths.get(f.getPath())));
        } catch (IOException e) {
            return "Error reading file";
        }
    }

    private String getFileExtension(File f) {
        return f.getName().substring(f.getName().lastIndexOf(".") + 1);
    }
}
