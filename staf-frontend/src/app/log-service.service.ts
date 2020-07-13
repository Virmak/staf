import { FileEditorService } from './file-editor.service';
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

  currentProgress;

  sessionCount;

  showConsole = false;

  constructor(private fileEditorService: FileEditorService) { }

  addMessage(message) {
    if (message.startsWith('[INFO] WebSocketSession[1 current WS')) { //ignore websocket session log
      return;
    }
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
    const testCaseStartedMatch = message.match(/Started executing test case : \[(.*?)\]|Test case \[(.*?)\] Ignored/);
    if (testCaseStartedMatch) {
      this.currentTestCase = {
        name: testCaseStartedMatch[1],
        index: ++this.currentTestCaseIndex
      };
      this.currentProgress = ((this.currentTestCaseIndex *100 / (this.totalTestCases *  this.sessionCount))).toFixed(2);
    }
    const testSuiteStartedMatch = message.match(/Started executing test suite : \[(.*?)\] (\d+) Test cases found/);
    if (testSuiteStartedMatch) {
        this.totalTestCases = testSuiteStartedMatch[2];
    }

    const testCaseFinishedMatch = message.match(/Finished executing test case : \[(.*?)\] (Pass|Fail)/);
    if (testCaseFinishedMatch) {
      let logClass;
      logClass = testCaseFinishedMatch[2] == 'Pass' ? 'log-success' : 'log-error';
      message = '<span class="' + logClass + '">[TEST] ' + testCaseFinishedMatch[1] + ' - ' + testCaseFinishedMatch[2] + 'ed</span>' 
    }

    this.logContent += message + '<br>';
  }
  
  newSession(sessionCount) {
    this.logContent = '';
    this.currentTestCase = {
      name: '',
      index: 0,
    };
    this.totalTestCases = 0;
    this.currentTestCaseIndex = 0;
    this.currentProgress = 0;
    this.sessionCount = sessionCount;
  }
}
