import { FileEditorService } from './../file-editor.service';
import { ToastrService } from 'ngx-toastr';
import { GenericResponse } from './../interfaces/igeneric-response';
import { ProjectService } from 'src/app/project.service';
import { StafProject } from './../types/staf-project';
import { ITestSuite } from './../interfaces/itest-suite';
import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { IGenericResponse } from '../interfaces/igeneric-response';

@Component({
  selector: 'app-rename-test-suite',
  templateUrl: './rename-test-suite.component.html',
  styleUrls: ['./rename-test-suite.component.css']
})
export class RenameTestSuiteComponent implements OnInit {
  @Input() renameModalOpened = false;
  @Input() testSuite: ITestSuite;
  @Input() project: StafProject;
  newName: string;
  @Output() modalOpenChanged = new EventEmitter();

  projectHasOpenedFiles = false;

  constructor(
    private projectService: ProjectService,
    private toastr: ToastrService,
    private fileEditor: FileEditorService) { }

  ngOnInit(): void {
    this.projectHasOpenedFiles = false;
    this.newName = this.testSuite.name;
    
    this.fileEditor.openedFiles.forEach((file, key) => {
      if (file.project.name === this.project.name) {
        this.projectHasOpenedFiles = true;
      }
    });
  }

  openChanged(isOpened) {
    this.modalOpenChanged.emit(isOpened);
  }

  renameTestSuite() {
    this.projectService.renameTestSuite(this.project, this.testSuite, this.newName)
      .subscribe((response: IGenericResponse) => {
        if (response.result == GenericResponse.Ok) {
          this.toastr.success('Test suite renamed successfully');
          this.toastr.info('Reloading project files');
          this.projectService.fetchProject(this.project);
        } else {
          this.toastr.error('Error renaming test suite');
        }
      });
    this.renameModalOpened = false;
  }

}
