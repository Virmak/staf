package com.sparkit.staf.api.domain.report;

import com.sparkit.staf.api.domain.TestSuite;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class TestSuiteReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private TestSuite testSuite;
    @OneToMany
    private List<TestCaseReport> testCases;
}
