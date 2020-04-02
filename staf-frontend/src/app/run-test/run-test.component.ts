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
  _testSuites = [];
  private _project: IStafProject;
  
  public get project() : IStafProject {
    return  this._project;
  }
  

  @Input('project')
  public set project(value: IStafProject) {
    this._testSuites = value.testSuites.filter(testSuite => testSuite.name != 'logs');
    this._project = value;
  }

  constructor(private testService: TestService) { }

  ngOnInit(): void {
  }

  runSelectedTests() {

  }

  runAllTests() {
    this.testService.runTest(this._project.name)
    .subscribe(console.log);
  }

  testSuiteCheck(e) {
    console.log(e.target.checked)
  }


}
