package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.request.CreateFileRequest;
import com.sparkit.staf.application.models.request.RenameFileRequest;
import com.sparkit.staf.application.models.response.CreateFileResponse;
import com.sparkit.staf.application.models.response.RenameFileResponse;
import com.sparkit.staf.domain.FileType;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileService {

    @Value("${testDirectory}")
    private String testDir;

    // File type 'scroll' => file, 'folder' => dir
    public void saveFile(String path, String content, FileType type) throws IOException {
        path = path.replace(testDir, "");
        File file = new File(testDir, path);
        if (type == FileType.FILE) {
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } else {
            file.mkdir();
        }
    }

    public CreateFileResponse createFile(CreateFileRequest createFileRequest) {
        CreateFileResponse response = new CreateFileResponse();
        String relativePath = createFileRequest.getPath().replace(testDir, "");
        File file = new File(testDir, relativePath);
        if (file.exists()) {
            response.setResult(ProjectService.ERROR_RESULT_STRING);
            response.setError("File already exists");
        } else if (createFileRequest.getType() == FileType.FILE) {
            try {
                FileUtils.writeStringToFile(file, "", "UTF-8");
                response.setResult(ProjectService.OK_RESULT_STRING);
            } catch (IOException e) {
                response.setResult(ProjectService.ERROR_RESULT_STRING);
                response.setError("Cannot create file");
            }
        } else {
            if (file.mkdir()) {
                response.setResult(ProjectService.OK_RESULT_STRING);
            } else {
                response.setResult(ProjectService.ERROR_RESULT_STRING);
                response.setError("Cannot create directory");
            }
        }
        return response;
    }

    public RenameFileResponse renameFile(RenameFileRequest renameFileRequest) {
        String actualFilePath = renameFileRequest.getFilePath().replace(testDir, "");
        RenameFileResponse response = new RenameFileResponse();
        File fileToRename = new File(testDir, actualFilePath);
        File newFile = new File(fileToRename.getParentFile(), renameFileRequest.getNewName());
        if (fileToRename.renameTo(newFile)) {
            response.setResult(ProjectService.OK_RESULT_STRING);
        } else {
            response.setResult(ProjectService.ERROR_RESULT_STRING);
        }
        return response;
    }

    public boolean removeFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            return deleteDirectory(file);
        }
        return file.delete();
    }

    boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
