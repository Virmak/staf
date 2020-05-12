import { WebSocketApiService } from './web-socket-api.service';
import { ProjectService } from './project.service';
import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { IStafProject } from './interfaces/istaf-project';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'staf-gui';
  projects: IStafProject[];
  serverError = false;

  constructor(public projectService: ProjectService,
    private webSocket: WebSocketApiService) {}

  ngOnInit(): void {

    (<any>window).userKeywords = {};
    this.projectService.fetchProjects(err => {this.serverError = true});
    this.projectService.getProjectsSubject().subscribe(projects => {
      this.projects = projects.filter(p => p != null);
    });
    this.projectService.next();
    this.webSocket._connect();
  }

  confirmDeleteFile() {

  }
}
