import { StafProject } from './../types/staf-project';
import { TestSuiteService } from './../test-suite.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-test-suite-overview',
  templateUrl: './test-suite-overview.component.html',
  styleUrls: ['./test-suite-overview.component.css']
})
export class TestSuiteOverviewComponent implements OnInit {
  @Input() project: StafProject;
  testSuites = [];

  constructor(private testSuiteService: TestSuiteService) { }

  ngOnInit(): void {
  }

  resetChildren() {

  }

  fetchTestSuite(testSuite) {
    this.testSuiteService.getTestSuiteDetails(this.project.getNormalizedProjectName(), testSuite.name)
    .subscribe((ts: any) => testSuite.testCases = ts.testCases.sort((a,b) => a.order - b.order));
  }

  resetTestSuites() {

  }

}
