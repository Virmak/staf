package com.sparkit.staf.application.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileService {

    @Value("${testDirectory}")
    String testDir;

    // File type 'scroll' => file, 'folder' => dir
    public void saveFile(String path, String content, String type) throws IOException {
        path = path.replace(testDir, "");
        File file = new File(testDir, path);
        if (type.equals("scroll")) {
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } else {
            file.mkdir();
        }
    }

    public boolean removeFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    private boolean isChild(Path child, String parentText) {
        Path parent = Paths.get(parentText).toAbsolutePath();
        return child.startsWith(parent);
    }
}
