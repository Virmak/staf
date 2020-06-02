package com.sparkit.staf.application.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileService {

    @Value("${testDirectory}")
    String testDir;

    // File type 'scroll' => file, 'folder' => dir
    public void saveFile(String path, String content, String type) throws IOException {
        path = path.replace(testDir, "");
        File file = new File(testDir, path);
        if ("scroll".equals(type)) {
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } else {
            file.mkdir();
        }
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
