import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-project-overview',
  templateUrl: './project-overview.component.html',
  styleUrls: ['./project-overview.component.css']
})
export class ProjectOverviewComponent implements OnInit {
  _project;

  @Input() set project(value) {
    this._project = value;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
