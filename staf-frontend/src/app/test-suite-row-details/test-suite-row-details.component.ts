import { StafProject } from './../types/staf-project';
import { ITestSuite } from './../interfaces/itest-suite';
import { Component, OnInit, Input } from '@angular/core';
import { TestSuiteService } from '../test-suite.service';

@Component({
  selector: 'app-test-suite-row-details',
  templateUrl: './test-suite-row-details.component.html',
  styleUrls: ['./test-suite-row-details.component.css']
})
export class TestSuiteRowDetailsComponent implements OnInit {
  @Input() testSuite: ITestSuite;
  @Input() project: StafProject;

  constructor(private testSuiteService: TestSuiteService) { }

  ngOnInit(): void {
    
    this.testSuiteService.getTestSuiteDetails(this.project.getNormalizedProjectName(), this.testSuite.name)
    .subscribe((ts: any) => {
      this.testSuite.testCases = ts.testCases
      .map(testCase => {
        testCase.enabled = !testCase.ignored; 
        return testCase;
      })
      .sort((a,b) => {
        if (isNaN(a.order)) {
          return -1;
        } if (isNaN(b.order)) return 1;
        return a.order - b.order;
      })
    });
  }

}
