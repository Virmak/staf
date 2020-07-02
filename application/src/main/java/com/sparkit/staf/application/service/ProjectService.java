package com.sparkit.staf.application.service;

import com.sparkit.staf.application.IProjectBuilder;
import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.exception.TestDirectoryNotFound;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.request.UpdateProjectRequest;
import com.sparkit.staf.application.models.response.CreateTestSuiteResponse;
import com.sparkit.staf.application.models.response.DeleteTestSuiteResponse;
import com.sparkit.staf.application.models.response.GetProjectReportsResponse;
import com.sparkit.staf.application.models.response.UpdateProjectResponse;
import com.sparkit.staf.core.runtime.loader.IStafProjectConfigReader;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestSuite;
import org.apache.commons.io.FileUtils;
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
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private static final String USER_DIR = "user.dir";
    private static final String PROJECT_ROOT_PLACEHOLDER = "$projectRoot";
    private static final String ERROR_RESULT_STRING = "error";
    private static final String OK_RESULT_STRING = "ok";
    private final IProjectBuilder projectBuilder;
    private final IStafProjectConfigReader projectConfig;
    @Value("${testDirectory}")
    private String testDir;

    @Autowired
    public ProjectService(IProjectBuilder projectBuilder, IStafProjectConfigReader projectConfig) {
        this.projectBuilder = projectBuilder;
        this.projectConfig = projectConfig;
    }

    public static String normalizeProjectName(String name) {
        return name.toLowerCase().replaceAll("\\s+", "-");
    }

    public Map<String, Object> readProjectContent(String projectName) {
        File projectDir = new File(testDir, ProjectService.normalizeProjectName(projectName));
        String currentDir = System.getProperty(USER_DIR);
        String absoluteTestDir = currentDir + "/" + testDir;
        return listDirectory(projectDir, absoluteTestDir);
    }

    public List<String> getProjectsList() throws TestDirectoryNotFound {
        File currentDir = new File(System.getProperty(USER_DIR));
        File projectsDir = new File(currentDir, testDir);
        File[] files = projectsDir.listFiles();
        if (files != null) {
            return Arrays.stream(files).map(File::getName).collect(Collectors.toList());
        } else {
            throw new TestDirectoryNotFound(testDir);
        }
    }

    public ProjectConfig createProject(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist {
        return projectBuilder.buildProject(createProjectRequest);
    }

    public Map<String, Object> listDirectory(File dir, String testDir) {
        File[] content = dir.listFiles();

        List<Map<String, com.sparkit.staf.domain.File>> files = new LinkedList<>();
        List<Map<String, Object>> folders = new LinkedList<>();

        for (File f : content) {
            if (f.isDirectory()) {
                Map<String, Object> subList = listDirectory(f, testDir);
                folders.add(subList);
            } else {
                Map<String, com.sparkit.staf.domain.File> fileMap = new HashMap<>();
                com.sparkit.staf.domain.File file = new com.sparkit.staf.domain.File();
                file.setName(f.getPath());
                file.setFileContent(readFileContent(f));
                file.setPath(f.toString());
                fileMap.put(f.toString().replaceAll(testDir, PROJECT_ROOT_PLACEHOLDER), file);
                files.add(fileMap);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("folders", folders);
        result.put("files", files);
        result.put("name", dir.toString().replace(testDir, PROJECT_ROOT_PLACEHOLDER));
        result.put("path", dir.toString().replace(testDir, PROJECT_ROOT_PLACEHOLDER));
        return result;
    }

    private String readFileContent(File f) {
        String fileExtension = getFileExtension(f);
        if (f.getName().startsWith("reports-") && f.getName().endsWith(".json")) {
            return "";
        }
        switch (fileExtension) {
            case "staf":
            case "page":
            case "step":
            case "steps":
            case "txt":
            case "json":
            case "log":
            case "csv":
                return readTextFile(f);
            default:
                return "Error : Unsupported file format!";
        }
    }

    public String readImageBase64(File f) {
        String encodedFile = null;
        FileInputStream fileInputStreamReader = null;
        String readingFileError = "Error reading file";
        try {
            fileInputStreamReader = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return readingFileError;
        }
        byte[] bytes = new byte[(int) f.length()];
        try {
            fileInputStreamReader.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return readingFileError;
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
        return f.getName().substring(f.getName().lastIndexOf('.') + 1);
    }

    public CreateTestSuiteResponse createTestSuite(CreateTestSuiteRequest request) {
        CreateTestSuiteResponse response = new CreateTestSuiteResponse();
        response.setName(request.getName());
        try {
            TestSuite testSuite = projectBuilder.buildTestSuite(request);
            String absoluteTestDir = System.getProperty(USER_DIR) + "/" + testDir;
            response.setResult(OK_RESULT_STRING);
            response.setContent(listDirectory(new File(testSuite.getRootPath()), absoluteTestDir));
        } catch (IOException e) {
            e.printStackTrace();
            response.setResult(ERROR_RESULT_STRING);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public GetProjectReportsResponse getProjectReports(String projectName) {
        GetProjectReportsResponse response = new GetProjectReportsResponse();
        response.setProjectName(projectName);
        File projectDirectoryFile = getProjectDirectoryFile(projectName);
        File reportsDirectory = new File(projectDirectoryFile, "results");
        response.setReportsFileNameList(
                Arrays.stream(Objects.requireNonNull(reportsDirectory.listFiles()))
                        .map(File::getName).collect(Collectors.toList()));
        return response;
    }

    public DeleteTestSuiteResponse deleteTestSuite(String project, String testSuite) {
        DeleteTestSuiteResponse response = new DeleteTestSuiteResponse();
        String testSuitePath = testDir + '/' + project + '/' + testSuite;
        try {
            FileUtils.deleteDirectory(new File(testSuitePath));
            response.setResult(OK_RESULT_STRING);
        } catch (IOException e) {
            e.printStackTrace();
            response.setResult(ERROR_RESULT_STRING);
        }
        return response;
    }

    public UpdateProjectResponse renameProject(UpdateProjectRequest renameProjectRequest) {
        UpdateProjectResponse response = new UpdateProjectResponse();


        File projectDirectoryFile = getProjectDirectoryFile(normalizeProjectName(renameProjectRequest.getOldProjectName()));
        File newProjectDirectoryFile = getProjectDirectoryFile(normalizeProjectName(renameProjectRequest.getNewProjectName()));

        if (projectDirectoryFile.renameTo(newProjectDirectoryFile)) {
            response.setResult(OK_RESULT_STRING);
        } else {
            response.setResult(ERROR_RESULT_STRING);
        }
        return response;
    }

    public File getProjectDirectoryFile(String projectName) {
        File testDirectoryFile = new File(testDir);
        return new File(testDirectoryFile, normalizeProjectName(projectName));
    }
}
