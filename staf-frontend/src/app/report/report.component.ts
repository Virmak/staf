import { TestSuiteReport } from './../types/test-suite-report';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  resColors = {
    'Passed': 'green',
    'Failed': 'red',
  };

  @Input() reports: TestSuiteReport[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
