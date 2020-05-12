import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogServiceService {

  logContent;
  debug = true;
  currentTestCase;
  totalTestCases;

  currentTestCaseIndex;

  constructor() { }

  addMessage(message) {
    if (message.indexOf('ERROR') > -1) {
      message = '<span class="log-error">' + message + '</span>';
    }
    if (message.indexOf('WARN') > -1) {
      message = '<span class="log-warn">' + message + '</span>';
    }
    if (message.indexOf('INFO') > -1) {
      message = '<span class="log-info">' + message + '</span>';
    }
    if (this.debug && message.indexOf('DEBUG') > -1) {
      message = '<span class="log-debug">' + message + '</span>';
    }
    const testCaseStartedMatch = message.match(/Started executing test case : \[(.*?)\]/);
    if (testCaseStartedMatch) {
      this.currentTestCase = {
        name: testCaseStartedMatch[1],
        index: ++this.currentTestCaseIndex
      }
    }
    const testSuiteStartedMatch = message.match(/Started executing test suite : \[(.*?)\] (\d+) Test cases found/);
    if (testSuiteStartedMatch) {
        this.totalTestCases = testSuiteStartedMatch[2];
    }

    this.logContent += message + '<br>';
  }
  
  newSession() {
    this.logContent = '';
    this.currentTestCase = {
      name: '',
      index: 0,
    };
    this.totalTestCases = 0;
    this.currentTestCaseIndex = 0;
  }
}
