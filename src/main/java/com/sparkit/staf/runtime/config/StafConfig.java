package com.sparkit.staf.runtime.config;

import com.sparkit.staf.runtime.loader.IStafConfig;
import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

public class StafConfig implements IStafConfig {
    private JSONParser parser;
    private String projectName;
    private String projectDescription;
    private String testDirectory;
    private String logDirectory;
    private String reportingDirectory;
    private List<String> testSuites = new ArrayList<>();

    public StafConfig(JSONParser parser) {
        this.parser = parser;
    }

    public String getLogDirectory() {
        return logDirectory;
    }

    public void setLogDirectory(String logDirectory) {
        this.logDirectory = logDirectory;
    }

    public void readConfigFile(String configFilePath) throws ConfigFileNotFoundException {
        File file = new File(configFilePath);
        if (!file.isAbsolute()) {
            configFilePath = System.getProperty("user.dir") + "/" + configFilePath;
        }
        try (Reader reader = new FileReader(configFilePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            projectName = (String) jsonObject.get("projectName");
            projectDescription = (String) jsonObject.get("projectDescription");
            testDirectory = (String) jsonObject.get("testDirectory");
            logDirectory = (String) jsonObject.get("logDirectory");
            if (logDirectory.contains("$date")) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                logDirectory = logDirectory.replace("$date", dateFormat.format(new Date()));
            }

            reportingDirectory = (String) jsonObject.get("reportingDirectory");
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
    public String getProjectDescription() {
        return projectDescription;
    }

    @Override
    public String getReportingDirectory() {
        return reportingDirectory;
    }

    @Override
    public String getTestDirectory() {
        return testDirectory;
    }

    @Override
    public List<String> testSuites() {
        return testSuites;
    }
}
