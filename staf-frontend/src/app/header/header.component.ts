import { AuthService } from './../auth.service';
import { FileEditorService } from './../file-editor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  settingsModal = false;
  settingsMenuExpanded = false;
  saveFileModal = false;

  closingFile;

  constructor(
    private authService: AuthService,
    public fileEditor: FileEditorService) { }

  ngOnInit() {

  }
  
  openFile(file, project)  {
    this.fileEditor.openFile(file, project);
  }

  closeFile(file, key) {
    if (file.changed) {
      this.saveFileModal = true;
      this.closingFile = {
        file, key
      };
    } else {
      this.fileEditor.closeFile(file, key, false);
    }
  }

  resetFileContent() {

  }

  closeAndSaveFile(save) {
      this.fileEditor.closeFile(this.closingFile.file, this.closingFile.key, save);
      this.saveFileModal = false;
  }

  showHideModal(e) {
    this.settingsModal = e;
  }

  onWheel(event: WheelEvent): void {
    (<Element>event.currentTarget).scrollLeft += event.deltaY;
    event.preventDefault();
  } 

  logout() {
    this.authService.logout();
  }

}
