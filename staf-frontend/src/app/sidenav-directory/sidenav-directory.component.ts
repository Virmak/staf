import { IDirectory } from './../interfaces/idirectory';
import { ProjectService } from './../project.service';
import { FileType, IFile } from './../interfaces/ifile';
import { FileEditorService } from './../file-editor.service';
import { StafProject } from '../types/staf-project';
import { ITestSuite } from './../interfaces/itest-suite';
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

  newFile = {
    name: '',
    extension: 'staf',
  }
  createFileModal = false;

  current: any = {};

  renameFileModalOpened = false;


  fileTypes = FileType;

  fileToRename: IFile;
  fileToRenameParentDir: IDirectory;
  
  constructor(
    private router: Router,
    private fileEditorService: FileEditorService,
    private projectService: ProjectService) { }

  ngOnInit(): void {
  }

  createNewFileSystemItem(item: IFile, type: string) {
    this.createFileModal = true;
    this.current = {
      parent: item, type
    }
  }

  removeFile(item, parent) {
    this.projectService.showDeleteFileDialog(item, parent);
  }

  openFile(item, key) {
    if (item.type == FileType.Directory) {
      this.projectService.currentDir = item;
      this.router.navigate(['directory', this.project.getNormalizedProjectName(), item.name]);
    } else if (this.fileEditorService.isTextFile(item)) {
      this.fileEditorService.setFile(item);
      item.project = this.project;
      this.router.navigate(['editFile', this.project.getNormalizedProjectName(), item.name, key]);
    } else if (this.fileEditorService.isCsvFile(item)) {
      this.fileEditorService.setFile(item);
      item.project = this.project;
      this.router.navigate(['csvEditor', this.project.getNormalizedProjectName(), item.path]);
    } else if (this.fileEditorService.isImageFile(item)) {
      this.fileEditorService.setFile(item);
      this.router.navigate(['viewImage', this.project.getNormalizedProjectName(), item.path, key]);
    }
  }

  renameFile(item, parent) {
    this.fileToRename = item;
    this.fileToRenameParentDir = parent;
    this.renameFileModalOpened = true;
  }

  getIcon(fileType: FileType) {
    if (fileType == FileType.File) {
      return 'scroll';
    } else if (fileType == FileType.Directory) {
      return 'folder';
    }
  }

  copyPath(item) {
    navigator.clipboard.writeText(item.path.replace(this.projectService.testDirectory, '')).then(function() {
    });
  }
}
