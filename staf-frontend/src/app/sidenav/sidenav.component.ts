import { StafProject } from './../types/staf-project';
import { ITestSuite } from './../interfaces/itest-suite';
import { FileType } from './../interfaces/ifile';
import { ProjectService } from './../project.service';
import { SequenceService } from './../sequence.service';
import { ICreateTestSuite } from './../interfaces/icreate-test-suite';
import { TestSuiteService } from './../test-suite.service';
import { Component, OnInit, Input, ViewChild, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { ContextMenuComponent } from 'ngx-contextmenu';
import { IDirectory } from '../interfaces/idirectory';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit, AfterViewInit {
  @Input() projects: StafProject[] = [];
  @ViewChild(ContextMenuComponent,  { static: true }) public basicMenu: ContextMenuComponent;

  fileTypes = FileType;


  createTestSuiteModal = false;
  testSuite: ICreateTestSuite = {
    name: '',
    type: 'UITest',
    content: [],
    projectName: '',
  };
  currentProject: StafProject;
  
  createFileModal = false;
  renameModalOpened = false;
  
  selectedTestSuite: ITestSuite;
  selectedProject: StafProject;
  selectedType: FileType;

  constructor(private router: Router,
    private testSuiteService: TestSuiteService,
    private sequence: SequenceService,
    private projectService: ProjectService,
    private cdr: ChangeDetectorRef) { }
    
  ngAfterViewInit(): void {
    this.cdr.detectChanges()
  }

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
      .subscribe(testSuiteRes => {
        if (testSuiteRes.result == 'ok') {
          let testSuiteContentDir: IDirectory = {
            name: testSuiteRes.name,
            type: FileType.Directory,
            content: this.testSuiteService.readDirectory(testSuiteRes.content),
          }
          this.currentProject.testSuites.push({
            id: this.sequence.getNext('testSuite'),
            name: testSuiteRes.name,
            content: testSuiteContentDir
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

  createNewFileSystemItem(testSuite: ITestSuite, project: StafProject, type: FileType) {
    this.createFileModal = true;

    this.selectedTestSuite = testSuite;
    this.selectedProject = project;
    this.selectedType = type;
  }

  openFile(e) {
    console.log(e);
  }

  deleteFile(item, parent) {
    this.projectService.showDeleteTestSuiteDialog(item, parent);
  }

  renameTestSuite(testSuite: ITestSuite, project: StafProject) {
    this.renameModalOpened = true;

    this.selectedTestSuite = testSuite;
    this.selectedProject = project;
  }

}
