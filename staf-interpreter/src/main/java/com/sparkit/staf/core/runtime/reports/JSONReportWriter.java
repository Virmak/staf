package com.sparkit.staf.core.runtime.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
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
    @Value(SharedConstants.TEST_DIRECTORY_PROPERTY_VALUE)
    private String testDirectory;

    @Override
    public void write(ProjectConfig projectConfig, String testSuiteName, List<TestSuiteReport> reports) {
        try {
            objectMapper.writeValue(Paths.get(getReportFilePath(projectConfig, testSuiteName)).toFile(), reports);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(SharedConstants.CANNOT_WRITE_TEST_RESULTS, testSuiteName);
        }
    }

    private String getReportFilePath(ProjectConfig projectConfig, String testSuiteName) {
        return getReportDirectory(projectConfig, testSuiteName) + "/" + testSuiteName + "-report-" + getCurrentDateTime() + ".json";
    }

    private String getReportDirectory(ProjectConfig projectConfig, String testSuiteName) {
        String testSuiteReportsPath = Paths.get(testDirectory).toAbsolutePath() + "/" + projectConfig.getLocation()
                + "/" + projectConfig.getReportsDir() + "/" + testSuiteName;

        File reportDirFile = new File(testSuiteReportsPath);
        if (!reportDirFile.exists()) {
            reportDirFile.mkdirs();
        }
        return testSuiteReportsPath;
    }

    private String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(SharedConstants.YYYY_MM_DD_HH_MM_SS);
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
