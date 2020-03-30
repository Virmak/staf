package com.sparkit.staf.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String rootPath;
    private String logsDirectory;
    private String reportsDirectory;
    @OneToMany
    private List<TestSuite> testSuites;
}
