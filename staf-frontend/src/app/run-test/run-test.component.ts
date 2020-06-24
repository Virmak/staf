import { LogServiceService } from './../log-service.service';
import { TestSuiteReport, TestSuiteResult } from './../types/test-suite-report';
import { ToastrService } from 'ngx-toastr';
import { IStafProject } from './../interfaces/istaf-project';
import { TestService } from './../test.service';
import { ITestSuite } from './../interfaces/itest-suite';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-run-test',
  templateUrl: './run-test.component.html',
  styleUrls: ['./run-test.component.css']
})
export class RunTestComponent implements OnInit {
  runBtnDisabled = true;
  runAllBtnDisabled = true;
  stopBtnDisabled = true;
  progress = false;
  sessionCount = 1;

  _testSuites = [];
  private _project: IStafProject;
  dataListModel;

  public get project(): IStafProject {
    return this._project;
  }


  @Input('project')
  public set project(value: IStafProject) {
    this._testSuites = value.testSuites.filter(testSuite => testSuite.name != 'logs')
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
    public logService: LogServiceService) { }

  ngOnInit(): void {
  }

  runSelectedTests() {
    if (!this.isSessionCountValid()) {
      return;
    }
    this.logService.newSession(this.sessionCount);
    this.progress = true;
    this.stopBtnDisabled = false;
    this.runAllBtnDisabled = true;
    this.runBtnDisabled = true;
    this.testService.runTest({
      project: this._project.name,
      testSuites: this._testSuites.filter(ts => ts.checked).map(ts => ts.name),
      sessionCount: this.sessionCount
    })
      .subscribe(this.testComplete.bind(this), this.testFailed.bind(this));
  }

  runAllTests() {
    if (!this.isSessionCountValid()) {
      return;
    }
    this.logService.newSession(this.sessionCount);
    this.progress = true;
    this.stopBtnDisabled = false;
    this.runAllBtnDisabled = true;
    this.runBtnDisabled = true;
    this.testService.runTest({
      project: this._project.name,
      testSuites: this._testSuites.map(ts => ts.name),
      sessionCount: this.sessionCount
    }).subscribe(this.testComplete.bind(this), err => {
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

    this.project.reports = reports.map(report => {
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
      this.toastr.warning("Some test suites encountered errors please refer to logs to learn more about the problem", "Error")
    } else {
      this.toastr.success('Tests execution finished', 'Success');
    }
  }

  testFailed() {
    this.progress = false;
    this.stopBtnDisabled = true;
    this.toastr.error('Tests execution failed', 'Error');
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

  isSessionCountValid() {
    if ( isNaN(this.sessionCount) || this.sessionCount < 1) {
      this.toastr.error("Error, minimum test session is 1");
      return false;
    }
    return true;
  }
}
