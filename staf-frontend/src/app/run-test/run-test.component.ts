import { ToastrService } from 'ngx-toastr';
import { IStafProject } from './../interfaces/istaf-project';
import { TestService } from './../test.service';
import { ITestSuite } from './../interfaces/itest-suite';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-run-test',
  templateUrl: './run-test.component.html',
  styleUrls: ['./run-test.component.css']
})
export class RunTestComponent implements OnInit {
  runBtnDisabled = true;
  progress = false;

  _testSuites = [];
  private _project: IStafProject;
  
  public get project() : IStafProject {
    return  this._project;
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

  constructor(private testService: TestService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  runSelectedTests() {
    this.progress = true;
    this.testService.runTest({
      project: this._project.name,
      testSuites: this._testSuites.filter(ts => ts.checked).map(ts => ts.name),
    })
    .subscribe(this.testComplete.bind(this), this.testFailed.bind(this));
    this.toastr.info(this._project.name + ' Tests are running', 'Test');
  }

  runAllTests() {
    this.progress = true;
    this.testService.runTest({
      project: this._project.name,
      testSuites: this._testSuites.map(ts => ts.name),
    })
    .subscribe(this.testComplete.bind(this), this.testFailed.bind(this));
    this.toastr.info(this._project.name + ' Tests are running', 'Test');
  }

  testSuiteCheck(e, testSuite) {
    testSuite.checked = e.target.checked;
    this.runBtnDisabled = true;
    for (let i = 0 ; i < this._testSuites.length; i++) {
      if (this._testSuites[i].checked) {
        this.runBtnDisabled = false;
        break;
      }
    }
  }

  testComplete(reports) {
    this.progress = false;
    this.toastr.success('Tests execution finished', 'Success');
  }
  testFailed() {
    this.progress = false;
    this.toastr.error('Tests execution failed', 'Error');
  }
}
