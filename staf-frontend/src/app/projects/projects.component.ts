import { ProjectService } from 'src/app/project.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects = [];

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.projectService.getProjectsSubject().subscribe(projects => {
      this.projects = projects;
    });
  }

}
