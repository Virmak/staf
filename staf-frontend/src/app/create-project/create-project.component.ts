import { ProjectService } from './../project.service';
import { Component, OnInit } from '@angular/core';
import { IStafProject, ProjectType } from '../interfaces/istaf-project';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
  private lastProjectName = '';
  project: IStafProject;

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

}
