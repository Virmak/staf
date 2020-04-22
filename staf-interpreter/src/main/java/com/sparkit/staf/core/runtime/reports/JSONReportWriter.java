package com.sparkit.staf.core.runtime.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparkit.staf.core.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class JSONReportWriter implements ITestReportWriter {
    @Autowired
    private ObjectMapper objectMapper;
    private static Logger logger = LoggerFactory.getLogger(Main.class);

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
