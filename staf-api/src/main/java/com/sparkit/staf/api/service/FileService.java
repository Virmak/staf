package com.sparkit.staf.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileService {

    @Value("${testDirectory}")
    String testDir;

    public void saveFile(String path, String content) {
        System.out.println(path);
        System.out.println(content);
    }

    private boolean isChild(Path child, String parentText) {
        Path parent = Paths.get(parentText).toAbsolutePath();
        return child.startsWith(parent);
    }
}
