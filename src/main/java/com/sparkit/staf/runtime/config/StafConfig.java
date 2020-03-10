package com.sparkit.staf.runtime.config;

import com.sparkit.staf.runtime.loader.IStafConfig;
import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StafConfig implements IStafConfig {
    private JSONParser parser;
    private String testDirectory;
    private String logDirectory;
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

    public void readConfig(String configFilePath) throws ConfigFileNotFoundException {

        try (Reader reader = new FileReader(configFilePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            testDirectory = (String) jsonObject.get("testDirectory");
            logDirectory = (String) jsonObject.get("logDirectory");
            JSONArray msg = (JSONArray) jsonObject.get("test_suites");
            Iterator<String> iterator = msg.iterator();
            iterator.forEachRemaining(testSuites::add);
        } catch (IOException | ParseException e) {
            throw new ConfigFileNotFoundException();
        }
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
