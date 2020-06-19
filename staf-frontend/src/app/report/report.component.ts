import { TestSuiteReport } from './../types/test-suite-report';
import { Component, OnInit, Input } from '@angular/core';
import { TestSuiteResultComponent } from '../log/test-suite-result/test-suite-result.component';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  private _reports = [];

  resColors = {
    'Pass': 'green',
    'Fail': 'red',
  };

  @Input() set reports(value) {
    this._reports = value.map((report: TestSuiteReport) => {
      report.elapsed = TestSuiteResultComponent.getTimeString((new Date(report.end)).getTime()
      - (new Date(report.start)).getTime());
      report.testCaseReports.map(tc => {
        tc.elapsed = TestSuiteResultComponent.getTimeString((new Date(tc.end)).getTime()
        - (new Date(tc.start)).getTime());
      });
      return report;
    });
  }

  get reports() {
    return this._reports;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
