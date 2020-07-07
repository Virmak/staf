package com.sparkit.staf.application.service;

import com.sparkit.staf.application.IProjectBuilder;
import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.exception.TestDirectoryNotFound;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.response.CreateTestSuiteResponse;
import com.sparkit.staf.application.models.response.DeleteTestSuiteResponse;
import com.sparkit.staf.application.models.response.GetProjectReportsResponse;
import com.sparkit.staf.application.models.response.UpdateProjectConfigResponse;
import com.sparkit.staf.core.runtime.config.JsonStafProjectConfig;
import com.sparkit.staf.core.runtime.loader.IStafProjectConfigReader;
import com.sparkit.staf.domain.Directory;
import com.sparkit.staf.domain.FileType;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestSuite;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    public static final String ERROR_RESULT_STRING = "error";
    public static final String OK_RESULT_STRING = "ok";
    private static final String USER_DIR = "user.dir";
    private static final String READING_FILE_ERROR = "Error reading file";
    private final IProjectBuilder projectBuilder;
    private final IStafProjectConfigReader configReader;
    @Value("${testDirectory}")
    private String testDir;

    @Autowired
    public ProjectService(IProjectBuilder projectBuilder, IStafProjectConfigReader configReader) {
        this.projectBuilder = projectBuilder;
        this.configReader = configReader;
    }

    public static String normalizeProjectName(String name) {
        return name.toLowerCase().replaceAll("\\s+", "-");
    }

    public Directory readProjectContent(String projectName) {
        File projectDir = new File(testDir, ProjectService.normalizeProjectName(projectName));
        return readDirectory(projectDir);
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

    public List<String> getProjectTestSuiteNames(String projectLocation) throws IOException {
        ProjectConfig config = getProjectConfig(projectLocation);
        File projectDirectoryFile = getProjectDirectoryFile(projectLocation);
        File[] content = projectDirectoryFile.listFiles();
        return Arrays.stream(Objects.requireNonNull(content))
                .filter(File::isDirectory)
                .map(File::getName)
                .filter(dirName -> !dirName.equals(config.getReportsDir()) && !dirName.equals(config.getLogDir()))
                .collect(Collectors.toList());
    }

    public ProjectConfig createProject(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist {
        return projectBuilder.buildProject(createProjectRequest);
    }

    public Directory readDirectory(File dir) {
        Directory directory = new Directory();
        File[] content = dir.listFiles();
        directory.setContent(new ArrayList<>());
        for (File file : content) {
            if (file.isDirectory()) {
                directory.getContent().add(readDirectory(file));
            } else {
                com.sparkit.staf.domain.File newFile = new com.sparkit.staf.domain.File();
                newFile.setName(file.getName());
                newFile.setFileContent(readFileContent(file));
                newFile.setPath(file.getPath());
                newFile.setType(FileType.FILE);
                directory.getContent().add(newFile);
            }
        }
        directory.setName(dir.getName());
        directory.setPath(dir.getPath());
        directory.setType(FileType.DIRECTORY);
        return directory;
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

        try (FileInputStream fileInputStream = new FileInputStream(f)) {
            byte[] bytes = new byte[(int) f.length()];
            fileInputStream.read(bytes);
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return READING_FILE_ERROR;
        }
    }

    private String readTextFile(File f) {
        try {
            return new String(Files.readAllBytes(Paths.get(f.getPath())));
        } catch (IOException e) {
            return READING_FILE_ERROR;
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
            response.setResult(OK_RESULT_STRING);
            response.setContent(readDirectory(new File(testSuite.getRootPath())));
        } catch (IOException e) {
            e.printStackTrace();
            response.setResult(ERROR_RESULT_STRING);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public GetProjectReportsResponse getProjectReports(String projectName) throws IOException {
        GetProjectReportsResponse response = new GetProjectReportsResponse();
        response.setProjectName(projectName);
        File projectDirectoryFile = getProjectDirectoryFile(projectName);
        ProjectConfig projectConfig = getProjectConfig(projectName);
        File reportsDirectory = new File(projectDirectoryFile, projectConfig.getReportsDir());
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

    public boolean updateProjectLocation(String oldProjectLocation, String newProjectLocation) {
        File projectDirectoryFile = getProjectDirectoryFile(normalizeProjectName(oldProjectLocation));
        File newProjectDirectoryFile = getProjectDirectoryFile(normalizeProjectName(newProjectLocation));
        return projectDirectoryFile.renameTo(newProjectDirectoryFile);
    }

    public File getProjectDirectoryFile(String projectName) {
        File testDirectoryFile = new File(testDir);
        return new File(testDirectoryFile, normalizeProjectName(projectName));
    }

    public UpdateProjectConfigResponse updateProjectConfig(String projectLocation, ProjectConfig updateConfigRequest) {
        UpdateProjectConfigResponse response = new UpdateProjectConfigResponse();
        try {
            ProjectConfig originalConfig = getProjectConfig(projectLocation);
            originalConfig.setProject(updateConfigRequest.getProject());
            originalConfig.setDescription(updateConfigRequest.getDescription());
            originalConfig.setLogDir(updateConfigRequest.getLogDir());
            originalConfig.setReportsDir(updateConfigRequest.getReportsDir());
            if (!originalConfig.getLocation().equals(updateConfigRequest.getLocation())) {
                if (!updateProjectLocation(originalConfig.getLocation(), updateConfigRequest.getLocation())) {
                    throw new IOException("Cannot rename project");
                }
                originalConfig.setLocation(updateConfigRequest.getLocation());
            }
            projectBuilder.writeConfigFile(originalConfig, getProjectDirectoryFile(updateConfigRequest.getLocation()));
            response.setResult(OK_RESULT_STRING);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ERROR_RESULT_STRING);
        }
        return response;
    }

    public String readTestReport(String projectName, String fileName) throws IOException {
        ProjectConfig projectConfig = getProjectConfig(projectName);
        File projectDirectoryFile = getProjectDirectoryFile(normalizeProjectName(projectName));
        File reportsDirectory = new File(projectDirectoryFile, projectConfig.getReportsDir());
        File reportFile = new File(reportsDirectory, fileName);
        return new String(Files.readAllBytes(Paths.get(reportFile.getAbsolutePath())));
    }

    public ProjectConfig getProjectConfig(String projectLocation) throws IOException {
        File projectDirectoryFile = getProjectDirectoryFile(normalizeProjectName(projectLocation));
        File configFile = new File(projectDirectoryFile, JsonStafProjectConfig.DEFAULT_PROJECT_CONFIG_NAME);
        return configReader.readConfigFile(configFile);
    }
}
