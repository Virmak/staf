package com.sparkit.staf.api.service;

import org.springframework.stereotype.Component;

@Component
public class FileService {
    public void saveFile(String path, String content) {
        System.out.println(path);
        System.out.println(content);
    }
}
