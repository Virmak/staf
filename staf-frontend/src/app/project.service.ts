import { environment } from './../environments/environment';
import { ToastrService } from 'ngx-toastr';
import { TestSuiteService } from './test-suite.service';
import { SequenceService } from './sequence.service';
import { StafProject } from './types/staf-project';
import { ITestSuite } from './interfaces/itest-suite';
import { Injectable } from '@angular/core';
import { IStafProject, ProjectType } from './interfaces/istaf-project';
import { IDirectory } from './interfaces/idirectory';
import { Subject, config } from 'rxjs';
import { IFile, FileType } from './interfaces/ifile';
import { HttpClient } from '@angular/common/http';

const defaultProjectsLocation = '~/tests';
const baseUrl = environment.resolveApi();

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private projectsSubject = new Subject<IStafProject[]>();

  private projects: StafProject[] = [];

  currentDir;

  public testDirectory;

  public deleteFileModal = false;
  public deleteFileConfirmed = false;
  private deleteOperation = () => { };

  constructor(
    private sequence: SequenceService,
    private http: HttpClient,
    private testSuiteService: TestSuiteService,
    private toastr: ToastrService) {
  }

  private getProjectConfig(project) {
    for (let i = 0; i < project.files.length; i++) {
      const keys = Object.keys(project.files[i]); // filenames are the object keys
      const fileNames = keys.map(fn => fn.substring(fn.lastIndexOf('/') + 1));
      const configFileIndex = fileNames.indexOf('config.json');
      if (configFileIndex == -1) { // error config file not found
        return null;
      } else {
        return project.files[i][keys[configFileIndex]];
      }
    }
  }

  fetchProjects(errCallback = null) {
    this.http.get(baseUrl + '/projects').subscribe((projects: any) => {
      console.log(projects);
      this.testDirectory = projects.name;
      this.projects = projects.folders.map(this.createProject.bind(this))
        .filter(p => p != null);
      this.next();
    }, errCallback);
  }

  next() {
    this.projectsSubject.next(this.projects);
  }

  getProjectsSubject() {
    return this.projectsSubject;
  }

  getProjects() {
    return this.projects;
  }

  createFile(parent: IDirectory, project: StafProject, filename: string, type: FileType) {
    const filePath = parent.path + '/' + filename;
    if (type == FileType.File) {
      let file: IFile = {
        name: filename,
        content: '',
        type,
        path: filePath,
        extension: filename.substr(filename.lastIndexOf('.') + 1)
      };
      if (parent.content.has(filePath)) {
        this.toastr.error('File with the same name already exist', 'Error');
      } else {
        parent.content.set(filePath, file);
      }
      this.saveFile(file).subscribe((res: any) => {
        if (res.result == 'ok') {
          this.toastr.success('File created', 'Success');
        } else {
          this.toastr.error('Error creating file', 'Error');
        }
      });;
    } else {
      let dir: IDirectory = {
        name: filename,
        content: new Map(),
        type: FileType.Directory,
        path: filePath,
      }
      if (parent.content.has(filename)) {
        this.toastr.error('Directory with the same name already exist', 'Error');
      } else {
        parent.content.set(filename, dir);
      }
      this.saveDirectory(dir);
    }
  }

  saveDirectory(directory: IDirectory) {
    this.saveFile(directory).subscribe((res: any) => {
      if (res.result == 'ok') {
        this.toastr.success('Directory created', 'Success');
      } else {
        this.toastr.error('Error creating directory', 'Error');
      }
    });
  }

  deleteFile(file: IFile, parent) {
    this.deleteFileModal = true;

    this.deleteOperation = () => {
      const errorToastr = () => this.toastr.error('Error deleting file', 'Error');
      this.http.delete(baseUrl + '/deleteFile/' + file.path.replace(/\//g, '<sep>'))
        .subscribe((res: any) => {
          if (res.result == 'ok') {
            parent.content.delete(file.path);
            this.toastr.info('File deleted', 'Success');
          } else {
            errorToastr();
          }
        }, errorToastr);
    }
  }

  confirmDeleteFile() {
    this.deleteOperation();
    this.deleteFileModal = false;
  }

  createProject(project) {
    const configFile = this.getProjectConfig(project);
    if (configFile != null) {
      const config = JSON.parse(configFile.fileContent);
      return StafProject.fromObject({
        id: this.sequence.getNext('project'),
        name: config.project,
        description: config.description,
        location: '',
        testSuites: this.testSuiteService.extractTestSuitesFromProject(project),
        logDir: config.logDir,
        reportsDir: config.reportsDir,
        type: config.type,
      });
    }
    return null;
  }

  addProject(project: IStafProject) {
    this.http.post(baseUrl + '/projects', project)
      .subscribe((res: any) => {
        if (res.error) {
          this.toastr.error('Another project with the same name already exists', 'Error');
        } else {
          this.projects.push(this.createProject(res));
        }
        this.toastr.success('Project created', 'Success');
      }, err => { this.toastr.error('Error creating project', 'Error') })

  }

  addTestSuite(project: IStafProject, testSuite: ITestSuite) {

  }

  getProjectById(id: number) {
    for (let i = 0; i < this.projects.length; i++) {
      if (this.projects[i].id == id) {
        return this.projects[i];
      }
    }
    return null;
  }

  getProjectByName(name: string): StafProject {
    for (let i = 0; i < this.projects.length; i++) {
      if (this.projects[i].getNormalizedProjectName() == name) {
        return this.projects[i];
      }
    }
    return null;
  }

  getFile(project, path): IFile {
    console.log(project, path);
    const pathItems = path.split('/');
    let testSuite = this.getTestSuiteByName(project, pathItems[1]);
    let lastDir: any = testSuite.content;

    for (let i = 2; i < pathItems.length; i++) {

    }

    return null;
  }

  getEmptyProject(): IStafProject {
    return {
      id: 0,
      name: '',
      description: '',
      location: defaultProjectsLocation + '/',
      logDir: 'logs',
      reportsDir: 'reports',
      testSuites: [],
      type: ProjectType.UITest,
    };
  }

  getTestSuiteByName(project: StafProject, testSuiteName) {
    for (let i = 0; i < project.testSuites.length; i++) {
      if (project.testSuites[i].name == testSuiteName) {
        return project.testSuites[i];
      }
    }
    return null;
  }

  saveFile(file: IFile) {
    return this.http.post(baseUrl + '/saveFile', file);
  }

  getImage(screenShot: string) {
    return this.http.get(baseUrl + "/screenshot/" + screenShot);
  }
}
