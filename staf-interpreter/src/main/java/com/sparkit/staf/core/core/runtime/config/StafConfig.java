package com.sparkit.staf.core.runtime.config;

import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JsonStafProjectConfig implements IStafConfig {
    @Autowired
    private JSONParser parser;
    private String projectName;
    private String projectDescription;
    private String projectDir;
    private String logDirectory;
    private String reportingDirectory;
    private List<String> testSuites = new ArrayList<>();
    @Value("${testDirectory}")
    String testDirectory;

    public String getLogDirectory() {
        return logDirectory;
    }

    public void setLogDirectory(String logDirectory) {
        this.logDirectory = logDirectory;
    }

    public void readConfigFile(String projectDir, String configFilePath) throws ConfigFileNotFoundException {
        this.projectDir = projectDir;
        File file = new File(configFilePath);
        if (!file.isAbsolute()) {
            configFilePath = System.getProperty("user.dir") + "/" + configFilePath;
        }
        try (Reader reader = new FileReader(configFilePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            projectName = (String) jsonObject.get("project");
            projectDescription = (String) jsonObject.get("description");
            logDirectory = testDirectory + "/" + jsonObject.get("logDir");
            if (logDirectory.contains("$date")) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                logDirectory = logDirectory.replace("$date", dateFormat.format(new Date()));
            }

            reportingDirectory = (String) jsonObject.get("reportsDir");
            JSONArray msg = (JSONArray) jsonObject.get("testSuites");
            Iterator<String> iterator = msg.iterator();
            iterator.forEachRemaining(testSuites::add);
        } catch (IOException | ParseException e) {
            throw new ConfigFileNotFoundException();
        }
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public String getProjectDir() {
        return projectDir;
    }

    @Override
    public String getProjectDescription() {
        return projectDescription;
    }

    @Override
    public String getReportingDirectory() {
        return reportingDirectory;
    }

    @Override
    public List<String> testSuites() {
        return testSuites;
    }
}
