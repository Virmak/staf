import { IDirectory } from './../interfaces/idirectory';
import { FileType } from './../interfaces/ifile';
import { StafProject } from './../types/staf-project';
import { ITestSuite } from './../interfaces/itest-suite';
import { ProjectService } from './../project.service';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-create-file-modal',
  templateUrl: './create-file-modal.component.html',
  styleUrls: ['./create-file-modal.component.css']
})
export class CreateFileModalComponent implements OnInit {
  public fileTypes = FileType;

  @Input() createFileModalOpened = false;

  name = '';
  extension = 'staf';

  supportedExtensions = {
    staf: 'Test file',
    page: 'Page test file',
    csv: 'CSV data file',
  };

  @Input() testSuite: ITestSuite;
  @Input() parent: IDirectory;
  @Input() project: StafProject;
  @Input() type: FileType;

  @Output() modalOpenChanged = new EventEmitter();

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
  }

  createFile() {
    let parentDir;
    if (this.testSuite) {
      parentDir = this.testSuite.content;
      this.testSuite.content.path = this.project.getNormalizedProjectName() + '/' + this.testSuite.name;
    } else {
      parentDir = this.parent;
    }
    this.projectService.createFile(
      parentDir,
      this.project,
      this.getFilename(),
      this.type);
    this.createFileModalOpened = false;
    this.name = '';
    this.extension = 'staf';
  }

  openChanged(e) {
    this.modalOpenChanged.emit(e);
  }

  private getFilename() {
    if (this.type == FileType.File) {
      return this.name + '.' + this.extension;
    }
    return this.name;
  }
}
