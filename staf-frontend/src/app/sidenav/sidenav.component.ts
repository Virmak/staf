import { ProjectService } from './../project.service';
import { SequenceService } from './../sequence.service';
import { ICreateTestSuite } from './../interfaces/icreate-test-suite';
import { TestSuiteService } from './../test-suite.service';
import { StafProject } from '../types/staf-project';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ContextMenuComponent } from 'ngx-contextmenu';
import { ITestSuite } from '../interfaces/itest-suite';
import { FileType } from '../interfaces/ifile';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  @Input() projects: StafProject[];
  @ViewChild(ContextMenuComponent) public basicMenu: ContextMenuComponent;


  createTestSuiteModal = false;
  testSuite: ICreateTestSuite = {
    name: '',
    type: 'UITest',
    content: [],
    projectName: '',
  };
  currentProject: StafProject;

  newFile = {
    name: '',
  }
  createFileModal = false;

  current: any = {};

  constructor(private router: Router,
    private testSuiteService: TestSuiteService,
    private sequence: SequenceService,
    private projectService: ProjectService) { }

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

  createNewFileSystemItem(testSuite: ITestSuite, project: StafProject, type: string) {
    this.createFileModal = true;
    this.current = {
      testSuite, project, type
    }
  }

  createFile() {debugger;
    this.current.testSuite.content.path = this.current.project.getNormalizedProjectName() + '/' + this.current.testSuite.name;
    this.projectService.createFile(this.current.testSuite.content, this.current.project, this.newFile.name, this.current.type);
    this.createFileModal = false;
  }

  openFile(e) {
    console.log(e);
  }

  deleteFile(item, parent) {
    this.projectService.deleteFile(item, parent);
  }

}
