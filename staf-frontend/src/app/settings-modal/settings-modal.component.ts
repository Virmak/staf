import { LogServiceService } from './../log-service.service';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { TestService } from '../test.service';

@Component({
  selector: 'app-settings-modal',
  templateUrl: './settings-modal.component.html',
  styleUrls: ['./settings-modal.component.css']
})
export class SettingsModalComponent implements OnInit {

  @Output() showModalChange: EventEmitter<boolean> = new EventEmitter<boolean>();

  webDriverUrl = '';
  runInSelenoid = false;
  sessionCount = 1;
  remoteWebDriver = false;
  enableVnc = false;
  enableVideo = false;

  serverIp = '';

  browserList = {
    chrome: ['81.0', '83.0'],
    firefox: ['76.0', '77.0'],
    opera: ['67.0', '68.0'],
  };

  browserNames = [
    'chrome',
    'firefox',
    'opera'
  ];

  selectedBrowser = this.browserNames[0];

  selectedVersion;

  constructor(public testService: TestService, private logService: LogServiceService) { }

  ngOnInit(): void {
    if (this.testService.driverOptions) {
      this.webDriverUrl = this.testService.driverOptions.webDriverAddress;
      this.remoteWebDriver = this.testService.driverOptions.remote;
      this.sessionCount = this.testService.driverOptions.sessionCount;
      this.selectedBrowser = this.testService.driverOptions.browserName;
      this.selectedVersion = this.testService.driverOptions.browserVersion;
      this.enableVideo = this.testService.driverOptions.enableVideo;
      this.enableVnc = this.testService.driverOptions.enableVnc;
      this.runInSelenoid = this.testService.driverOptions.runInSelenoid;
    }
    this.logService.showConsole = false;
    this.testService.getServerHostAddress().subscribe((res: any) => {
      this.serverIp = res.result;
    });
  }

  saveWebDriverOptions() {
    this.testService.setWebDriverOptions({
      webDriverAddress: this.webDriverUrl,
      remote: this.remoteWebDriver,
      sessionCount: this.runInSelenoid ? this.sessionCount : 1,
      browserName: this.selectedBrowser,
      browserVersion: this.selectedVersion,
      enableVideo: this.enableVideo,
      enableVnc: this.enableVnc,
      runInSelenoid: this.runInSelenoid
    });
  }

  hideModal() {
    this.showModalChange.emit(false);
  }
}
