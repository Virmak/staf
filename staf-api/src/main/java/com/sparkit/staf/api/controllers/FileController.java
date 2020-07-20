package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.request.CreateFileRequest;
import com.sparkit.staf.application.models.request.RenameFileRequest;
import com.sparkit.staf.application.models.response.CreateFileResponse;
import com.sparkit.staf.application.models.response.GenericResponse;
import com.sparkit.staf.application.models.response.ImageBase64;
import com.sparkit.staf.application.models.response.RenameFileResponse;
import com.sparkit.staf.application.service.FileService;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.Directory;
import com.sparkit.staf.domain.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@CrossOrigin
@RestController
public class FileController {
    private final FileService fileService;
    private final ProjectService projectService;
    @Value(SharedConstants.TEST_DIRECTORY_PROPERTY_VALUE)
    private String testDir;

    @Autowired
    public FileController(FileService fileService, ProjectService projectService) {
        this.fileService = fileService;
        this.projectService = projectService;
    }

    @GetMapping("/directory")
    public Directory getProject(@RequestParam("path") String directoryPath) {
        directoryPath = directoryPath.replaceAll("^" + testDir + "/", "");
        File testDirectoryFile = new File(testDir);
        File directoryFile = new File(testDirectoryFile, directoryPath);
        return projectService.readDirectory(directoryFile);
    }

    @PostMapping("/save-file")
    public GenericResponse saveFile(@RequestBody Map<String, Object> payload) throws IOException {
        FileType fileType = FileType.valueOf(payload.get("type").toString());
        fileService.saveFile(payload.get("path").toString(), payload.get("content").toString(), fileType);
        return new GenericResponse(SharedConstants.OK_RESULT_STRING);
    }

    @PostMapping("/create-file")
    public CreateFileResponse createFile(@RequestBody CreateFileRequest createFileRequest) {
        return fileService.createFile(createFileRequest);
    }

    @PutMapping("/rename-file")
    public RenameFileResponse renameFile(@RequestBody RenameFileRequest renameFileRequest) {
        return fileService.renameFile(renameFileRequest);
    }

    @DeleteMapping("/delete-file/{path}")
    public GenericResponse deleteFile(@PathVariable String path) {
        path = path.replace("<sep>", "/");
        if (fileService.removeFile(path)) {
            return new GenericResponse(SharedConstants.OK_RESULT_STRING);
        }
        return new GenericResponse(SharedConstants.ERROR_RESULT_STRING);
    }

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
