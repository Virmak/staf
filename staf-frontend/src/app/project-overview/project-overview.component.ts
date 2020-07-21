import { ProjectService } from './../project.service';
import { StafProject } from './../types/staf-project';
import { environment } from './../../environments/environment';
import { Component, OnInit, Input } from '@angular/core';

const baseUrl = environment.resolveApi();

@Component({
  selector: 'app-project-overview',
  templateUrl: './project-overview.component.html',
  styleUrls: ['./project-overview.component.css']
})
export class ProjectOverviewComponent implements OnInit {
  _project: StafProject;

  deleteProjectModal = false;

  @Input() set project(value) {
    this._project = value;
    this._project.expanded = true;
  }

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
  }

  downloadProject() {
    window.open(baseUrl + '/projects/download/' + this._project.location, '_blank');
  }

  deleteProject() {
    this.projectService.deleteProject(this._project);
    this.deleteProjectModal = false;
  }

}
