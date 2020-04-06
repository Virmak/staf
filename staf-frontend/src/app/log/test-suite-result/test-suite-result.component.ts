import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'test-suite-result',
  templateUrl: './test-suite-result.component.html',
  styleUrls: ['./test-suite-result.component.css']
})
export class TestSuiteResultComponent implements OnInit {
  _testSuite;
  @Input() set testSuite (value) {
    this._testSuite = value;
    this._testSuite.elapsed = this.getTimeString((new Date(value.end)).getTime()
      - (new Date(value.start)).getTime());
    this._testSuite.expanded = '+';
  };

  get testSuite() {
    return this._testSuite;
  }

  constructor() { }

  ngOnInit(): void {
  }

  getTimeString(milliseconds) {
    const date = new Date(0);
    date.setMilliseconds(milliseconds);
    return date.toISOString().substr(11, 8);
  }

  toggleExpand() {
    this._testSuite.expanded = this._testSuite.expanded == '+' ? '-' : '+';
  }

}
