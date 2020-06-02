import { Component, OnInit, Input } from '@angular/core';
import { TestSuiteResultComponent } from '../test-suite-result/test-suite-result.component';

@Component({
  selector: 'app-test-case-result',
  templateUrl: './test-case-result.component.html',
  styleUrls: ['./test-case-result.component.css']
})
export class TestCaseResultComponent implements OnInit {

  private _testCase;

  @Input() set testCase(value) {
    this._testCase = value;
    this._testCase.elapsed = TestSuiteResultComponent.getTimeString((new Date(value.end)).getTime()
      - (new Date(value.start)).getTime());
    this._testCase.expanded = '+';
    this._testCase.badge = this._testCase.result == 'Pass' ? 'badge-success' : 'badge-danger';
  }

  get testCase() {
    return this._testCase;
  }

  constructor() { }

  ngOnInit(): void {
  }

  toggleExpand() {
    this._testCase.expanded = this._testCase.expanded == '+' ? '-' : '+';
  }
}
