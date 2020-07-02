import { TestSuiteService } from "./../test-suite.service";
import { StafProject } from "./../types/staf-project";
import { LogServiceService } from "./../log-service.service";
import { TestSuiteReport, TestSuiteResult } from "./../types/test-suite-report";
import { ToastrService } from "ngx-toastr";
import { TestService } from "./../test.service";
import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";

@Component({
  selector: "app-run-test",
  templateUrl: "./run-test.component.html",
  styleUrls: ["./run-test.component.css"],
})
export class RunTestComponent implements OnInit {
  runBtnDisabled = true;
  runAllBtnDisabled = true;
  stopBtnDisabled = true;
  progress = false;

  _testSuites = [];
  private _project: StafProject;

  selectedTestSuites = [];

  public get project(): StafProject {
    return this._project;
  }

  @Input("project")
  public set project(value: StafProject) {
    this._testSuites = value.testSuites
      .filter((testSuite) => ["logs", "results"].indexOf(testSuite.name) == -1)
      .map((ts: any) => {
        ts.checked = false;
        return ts;
      });
    this._project = value;
  }

  @Output() testCompleted = new EventEmitter();

  constructor(
    private testService: TestService,
    private toastr: ToastrService,
    private testSuiteService: TestSuiteService,
    public logService: LogServiceService
  ) {}

  ngOnInit(): void {
    this.loadTestCases();
  }

  runSelectedTests() {
    this.logService.newSession(this.testService.driverOptions.sessionCount);
    this.progress = true;
    this.stopBtnDisabled = false;
    this.runAllBtnDisabled = true;
    this.runBtnDisabled = true;

    console.log(this.selectedTestSuites);
    this.testService
      .runTest({
        project: this._project.getNormalizedProjectName(),
        testSuites: this.selectedTestSuites,
      })
      .subscribe(this.testComplete.bind(this), this.testFailed.bind(this));
  }

  runAllTests() {
    this.logService.newSession(this.testService.driverOptions.sessionCount);
    this.progress = true;
    this.stopBtnDisabled = false;
    this.runAllBtnDisabled = true;
    this.runBtnDisabled = true;
    this.testService
      .runTest({
        project: this._project.name,
        testSuites: this._testSuites.map((ts) => ts.name),
      })
      .subscribe(this.testComplete.bind(this), (err) => {
        this.testFailed();
      });
  }

  testSuiteCheck(e, testSuite) {
    testSuite.checked = e.target.checked;
    this.runBtnDisabled = true;
    for (let i = 0; i < this._testSuites.length; i++) {
      if (this._testSuites[i].checked) {
        this.runBtnDisabled = false;
        break;
      }
    }
  }

  testComplete(reports: TestSuiteReport[]) {
    let hasErrors = false;

    this.project.reports = reports.map((report) => {
      if (report.result == TestSuiteResult.Error) {
        hasErrors = true;
      }
      return report;
    });

    this.testCompleted.emit(this.project.reports);
    this.progress = false;
    this.stopBtnDisabled = true;
    this.runBtnDisabled = false;
    this.runAllBtnDisabled = false;
    if (hasErrors) {
      this.toastr.warning(
        "Some test suites encountered errors please refer to logs to learn more about the problem",
        "Error"
      );
    } else {
      this.toastr.success("Tests execution finished", "Success");
    }
  }

  testFailed() {
    this.progress = false;
    this.stopBtnDisabled = true;
    this.toastr.error("Tests execution failed", "Error");
    this.runBtnDisabled = false;
    this.runAllBtnDisabled = false;
  }

  stopTests() {
    this.testService.stopTest().subscribe(() => {
      this.runBtnDisabled = false;
      this.runAllBtnDisabled = false;
      this.stopBtnDisabled = true;
      this.progress = false;
    });
  }

  loadTestCases() {
    this._testSuites.forEach((testSuite) => {
      this.testSuiteService
        .getTestSuiteDetails(
          this.project.getNormalizedProjectName(),
          testSuite.name
        )
        .subscribe((ts: any) => {
          testSuite.testCases = ts.testCases
            .map((testCase) => {
              testCase.enabled = !testCase.ignored;
              return testCase;
            })
            .sort((a, b) => {
              if (isNaN(a.order)) {
                return -1;
              }
              if (isNaN(b.order)) return 1;
              return a.order - b.order;
            });
        });
    });
  }
}
