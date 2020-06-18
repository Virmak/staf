import { FileExplorerService } from './../file-explorer.service';
import { TestService } from './../test.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  settingsMenuExpanded = false;
  webDriverSettingsModalOpen = false;
  webDriverIpAddrInput = '';
  webDriverPortInput = '9515';

  constructor(
    private testService: TestService,
    public fileExplorer: FileExplorerService) { }

  ngOnInit(): void {
    if (this.testService.webDriverAddress) {
      const addressArr = this.testService.webDriverAddress.split(':');
      this.webDriverIpAddrInput = addressArr[0];
      this.webDriverPortInput = addressArr[1];
    }
  }

  setWebDriverIpAddress() {
    this.testService.setWebDriverAddress(this.webDriverIpAddrInput, this.webDriverPortInput);
    this.webDriverSettingsModalOpen = false;
    this.settingsMenuExpanded = false;
  }

}
