import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-project-overview',
  templateUrl: './project-overview.component.html',
  styleUrls: ['./project-overview.component.css']
})
export class ProjectOverviewComponent implements OnInit {

  _project;
  projectName;
  projectNameChanged = false;

  @Input() set project(value) {
    this._project = value;
    this.projectName = value.name;
    this.projectNameChanged = false;
  }

  constructor() { }

  ngOnInit(): void {
  }

  updateProjectName(e) {
    if (this.projectName !== this._project.name) {
      this.projectNameChanged = true;
    } else {
      this.projectNameChanged = false;
    }
  }

}
