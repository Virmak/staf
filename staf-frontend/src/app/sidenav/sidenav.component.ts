import { ICreateTestSuite } from './../interfaces/icreate-test-suite';
import { TestSuiteService } from './../test-suite.service';
import { StafProject } from '../types/staf-project';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  @Input() projects: StafProject[];


  createTestSuiteModal = false;
  testSuite: ICreateTestSuite = {
    name: '',
    type: 'UITest',
    content: [],
  };
  currentProject: StafProject;

  constructor(private router: Router, private testSuiteService: TestSuiteService) { }

  ngOnInit(): void {
  }

  openProject(projectId) {
    this.router.navigateByUrl('/projectDetails/' + projectId);
  }

  openCreateTestSuiteModal(project: StafProject) {
    this.createTestSuiteModal = true;
    this.currentProject = project;
  }

  createTestSuite() {
    this.currentProject.testSuites.push(this.testSuiteService.createTestSuite(this.testSuite));
    this.testSuite.name = '';
    this.testSuite.type = 'UITest';
    this.createTestSuiteModal = false;
  }


  createNewStafScript(msg) {
    console.log(msg)
  }

}
