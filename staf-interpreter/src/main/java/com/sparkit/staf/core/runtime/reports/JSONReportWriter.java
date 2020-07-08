package com.sparkit.staf.core.runtime.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparkit.staf.domain.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class JSONReportWriter implements ITestReportWriter {
    private static final Logger logger = LoggerFactory.getLogger(JSONReportWriter.class);
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${testDirectory}")
    private String testDirectory;

    @Override
    public void write(ProjectConfig projectConfig, String testSuiteName, List<TestSuiteReport> reports) {
        try {
            objectMapper.writeValue(Paths.get(getReportFilePath(projectConfig, testSuiteName)).toFile(), reports);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Cannot write test result file : {}", testSuiteName);
        }
    }

    private String getReportFilePath(ProjectConfig projectConfig, String testSuiteName) {
        return Paths.get(testDirectory).toAbsolutePath() + "/" + projectConfig.getLocation()
                + "/" + projectConfig.getReportsDir() + "/" + testSuiteName + "-" + getCurrentDateTime() + ".json";
    }

    private String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
