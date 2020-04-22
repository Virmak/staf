import { SequenceService } from './../sequence.service';
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
    projectName: '',
  };
  currentProject: StafProject;

  constructor(private router: Router,
    private testSuiteService: TestSuiteService,
    private sequence: SequenceService) { }

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
    this.testSuite.projectName = this.currentProject.getNormalizedProjectName();

    this.testSuiteService.createTestSuite(this.testSuite)
      .subscribe(res => {
        if (res.result == 'ok') {
          this.currentProject.testSuites.push({
            id: this.sequence.getNext('testSuite'),
            name: res.name,
            content: res.content,
          });
          this.initTestSuiteFields();
        }
      }, err => { alert('Error creating test suite') ; this.initTestSuiteFields() });

  }

  initTestSuiteFields() {
    this.testSuite.name = '';
    this.testSuite.type = 'UITest';
    this.testSuite.projectName = this.currentProject.getNormalizedProjectName();
    this.createTestSuiteModal = false;
  }

  createNewStafScript(msg) {
    console.log(msg)
  }

}
