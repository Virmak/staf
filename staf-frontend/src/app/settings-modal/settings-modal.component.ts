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
  sessionCount = '';

  constructor(private testService: TestService) { }

  ngOnInit(): void {
    if (this.testService.webDriverAddress) {
      this.webDriverUrl = this.testService.webDriverAddress;
    }
  }

  setWebDriverIpAddress() {
    this.testService.setWebDriverAddress(this.webDriverUrl);
  }

  hideModal() {
    this.showModalChange.emit(false);
  }
}
