import { ProjectService } from './../project.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { IStafProject, ProjectType } from '../interfaces/istaf-project';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
  @ViewChild('fileImportInput') fileImportInput;
  private lastProjectName = '';
  private fileToUpload;
  project: IStafProject;
  uploadBtnDisabled = true;

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.project = this.projectService.getEmptyProject();
  }

  projectNameChanged(e) {
    const projectName = this.normalizeProjectName(this.project.name);
    if (this.lastProjectName == "") {
      this.project.location += projectName;
    } else {
      this.project.location = this.project.location.replace(this.lastProjectName, projectName);
    }
    this.lastProjectName = projectName;
  }

  createProject() {
    this.projectService.addProject(this.project);
    this.project = this.projectService.getEmptyProject();
  }

  private normalizeProjectName(projectName) {
    return projectName.replace(/[ \t]/g, '-').toLowerCase();
  }

  fileChange(e) {
    if (e.target.files.length) {
      this.uploadBtnDisabled = false;
      this.fileToUpload = e.target.files[0];
    }
  }
  
  uploadProject() {
    this.projectService.uploadProject(this.fileToUpload)
      .subscribe(res => {
        this.fileToUpload = null;
        this.fileImportInput.nativeElement.value = '';
        this.uploadBtnDisabled = true;
        this.projectService.fetchAllProjects();
      });
  }

}
