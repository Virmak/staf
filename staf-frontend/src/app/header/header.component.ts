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
  settingsModal = false;
  settingsMenuExpanded = false;
  saveFileModal = false;

  closingFile;

  constructor(
    private router: Router,
    public fileEditor: FileEditorService) { }

  ngOnInit() {

  }
  
  openFile(file, project)  {
    this.fileEditor.setFile(file);
    this.router.navigate(['editFile', project.getNormalizedProjectName(), file.name, file.path]);
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

}
