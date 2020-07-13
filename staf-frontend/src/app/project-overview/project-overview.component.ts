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

  @Input() set project(value) {
    this._project = value;
    this._project.expanded = true;
  }

  constructor() { }

  ngOnInit(): void {
  }

  downloadProject() {
    window.open(baseUrl + '/projects/download/' + this._project.location, '_blank');
  }

}
