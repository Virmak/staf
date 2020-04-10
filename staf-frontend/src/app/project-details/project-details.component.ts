import { ProjectService } from './../project.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {
  projects = [];
  project;
  projectId;
  reportTabActive = false;
  reports = [];
  
  constructor(private route: ActivatedRoute, private projectService: ProjectService) { }

  ngOnInit(): void {
    this.projectService.getProjectsSubject().subscribe(projects => {
      this.projects = projects;
      this.project = this.projectService.getProjectById(this.projectId);
      console.log(this.projectId, this.project)
    });
    this.route.paramMap.subscribe(paramMap => {
      this.projectId = paramMap.get('id');
      this.project = this.projectService.getProjectById(this.projectId);
    });
  }

  onTestCompleted(reports) {
    this.reportTabActive = true;
    this.reports = reports;
  }
}
