package com.sparkit.staf.api.domain.report;

import com.sparkit.staf.core.runtime.reports.TestResult;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class TestCaseReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String testSuite;
    private String testCase;
    private TestResult result;
    private Date startTime;
    private Date endTime;
}
