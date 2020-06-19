import { FileEditorService } from './../file-editor.service';
import { TestService } from './../test.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
    private router: Router,
    public fileEditor: FileEditorService) { }

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
  
  openFile(file, project)  {
    this.fileEditor.setFile(file);
    this.router.navigate(['editFile', project.getNormalizedProjectName(), file.name, file.path]);
  }

  closeFile(file, key) {
    this.fileEditor.closeFile(file, key);
  }

}
