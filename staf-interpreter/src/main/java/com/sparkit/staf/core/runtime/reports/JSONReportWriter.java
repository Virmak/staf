package com.sparkit.staf.core.runtime.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class JSONReportWriter implements ITestReportWriter {
    @Autowired
    private ObjectMapper objectMapper;
    private static Logger logger = LogManager.getLogger();

    @Override
    public void write(String filPath, List<TestSuiteReport> reports) {
        try {
            objectMapper.writeValue(Paths.get(filPath).toFile(), reports);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Cannot write test result file : " + filPath);
        }
    }
}
