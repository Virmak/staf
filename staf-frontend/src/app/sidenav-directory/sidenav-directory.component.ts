import { FileType } from './../interfaces/ifile';
import { FileEditorService } from './../file-editor.service';
import { StafProject } from '../types/staf-project';
import { ITestSuite } from './../interfaces/itest-suite';
import { IStafProject } from './../interfaces/istaf-project';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { ContextMenuComponent } from 'ngx-contextmenu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav-directory',
  templateUrl: './sidenav-directory.component.html',
  styleUrls: ['./sidenav-directory.component.css']
})
export class SidenavDirectoryComponent implements OnInit {

  @Input() dir;
  @Input() parent: any;
  @Input() project: StafProject;
  @Input() testSuite: ITestSuite;
  @ViewChild(ContextMenuComponent) public basicMenu: ContextMenuComponent;

  constructor(private router: Router, private fileEditorService: FileEditorService) { }

  ngOnInit(): void {
  }

  createNewFileSystemItem(item) {
    alert('creating new')
  }

  openFile(item, key) {
    if (item.type == FileType.Directory) {
      this.router.navigate(['directory', this.project.getNormalizedProjectName(), item.name, key]);
    } else {
      this.fileEditorService.setFile(item);
      this.router.navigate(['editFile', this.project.getNormalizedProjectName(), item.name, key]);
    }
  }

}
