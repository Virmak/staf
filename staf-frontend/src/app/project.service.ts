import { Observable } from 'rxjs';
import { CompiledTestSuite } from './types/compiled-test-suite';
import { environment } from './../environments/environment';
import { ToastrService } from 'ngx-toastr';
import { TestSuiteService } from './test-suite.service';
import { SequenceService } from './sequence.service';
import { StafProject } from './types/staf-project';
import { ITestSuite } from './interfaces/itest-suite';
import { Injectable } from '@angular/core';
import { IStafProject, ProjectType } from './interfaces/istaf-project';
import { IDirectory } from './interfaces/idirectory';
import { BehaviorSubject } from 'rxjs';
import { IFile, FileType } from './interfaces/ifile';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { IGenericResponse, GenericResponse } from './interfaces/igeneric-response';
import { IGetImage64 } from './interfaces/i-getimage64';
import { StafAPI } from './api-endpoints';

const baseUrl = environment.resolveApi();

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private projectsSubject = new BehaviorSubject<IStafProject[]>([]);

  private projects: StafProject[] = [];

  currentDir;

  public testDirectory;

  public deleteFileModal = false;
  public deleteTestSuiteModal = false;
  public deleteFileConfirmed = false;
  private deleteOperation = () => { };

  constructor(
    private sequence: SequenceService,
    private http: HttpClient,
    private testSuiteService: TestSuiteService,
    private toastr: ToastrService) {
  }

  private getProjectConfig(project) {
    return project.content.find(file => file.type === FileType.File && file.name === 'config.json');  
  }

  fetchAllProjects(errCallback = null) {
    this.toastr.info('Loading projects');
    this.http.get(baseUrl + StafAPI.GET_PROJECTS).subscribe((projects: any) => {
      this.testDirectory = projects.path;
      this.projects = projects.content.map(this.createProject.bind(this))
        .filter(p => p != null);
      this.next();

      this.toastr.success('Projects loaded successfully');
    }, errCallback);
  }

  fetchProject(project: StafProject) {
    this.http.get(baseUrl + StafAPI.GET_PROJECTS + '/' + project.location)
      .subscribe((projectDirectory: any) => {
        const project = this.createProject(projectDirectory);
        const projectIndex = this.projects.findIndex(p => p.name === project.name);
        this.projects[projectIndex] = project;
        this.next();
        this.toastr.success('Project loaded');
      });
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
      this.createNewFile(file).subscribe((res: any) => {
        if (res.result == GenericResponse.Ok) {
          this.toastr.success('File created', 'Success');
        } else {
          this.toastr.error(res.error, 'Error');
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
      this.createNewDirectory(dir);
    }
  }

  createNewDirectory(directory: IDirectory) {
    this.createNewFile(directory).subscribe((res: any) => {
      if (res.result == GenericResponse.Ok) {
        this.toastr.success('Directory created', 'Success');
      } else {
        this.toastr.error(res.error, 'Error');
      }
    });
  }

  createNewFile(file: IFile) {
    return this.http.post(baseUrl + StafAPI.CREATE_FILE, file);
  }

  showDeleteFileDialog(file: IFile, parent) {
    this.deleteOperation = () => {
        this.deleteFile(file, parent);
    }
    this.deleteFileModal = true;
  }
  showDeleteTestSuiteDialog(file: ITestSuite, parent) {
    this.deleteOperation = () => {
      this.deleteTestSuite(file, parent);
    }
    this.deleteTestSuiteModal = true;
  }

  deleteFile(file, parent) {
    const errorToastr = () => this.toastr.error('Error deleting file', 'Error');
    this.http.delete(baseUrl + StafAPI.DELETE_FILE + '/' + file.path.replace(/\//g, '<sep>'))
      .subscribe((res: any) => {
        if (res.result == 'ok') {
          const fileKey = file.type === FileType.File ? file.path : file.name;
          parent.content.delete(fileKey);
          this.toastr.info('File deleted', 'Success');
        } else {
          errorToastr();
        }
      }, errorToastr);
  }

  deleteTestSuite(testSuite: ITestSuite, project:StafProject) {
    const errorToastr = () => this.toastr.error('Error deleting test suite', 'Error');
    this.http.delete(baseUrl + StafAPI.DELETE_TEST_SUITE + '/' + project.location + '/' + testSuite.name)
      .subscribe((res: any) => {
        if (res.result == 'ok') {
          const testSuiteIndex = project.testSuites.findIndex(ts => ts.id == testSuite.id);
          project.testSuites.splice(testSuiteIndex, 1);
          this.toastr.info('Test suite deleted', 'Success');
        } else {
          errorToastr();
        }
      }, errorToastr);
  }

  deleteProject(project: StafProject) {
    this.http.delete(baseUrl + StafAPI.DELETE_PROJECT + '/' + project.location)
      .subscribe((res: any) => {
        if (res.result === GenericResponse.Ok) {
          const projectIndex = this.projects.indexOf(project);
          this.projects.splice(projectIndex, 1);
          this.next();
          this.toastr.success('Project deleted');
        } else {
          this.toastr.error('Cannot delete project');
        }
      });
  }

  confirmDeleteFile() {
    this.deleteOperation();
    this.deleteFileModal = false;
    this.deleteTestSuiteModal = false;
  }

  createProject(project) {
    const configFile = this.getProjectConfig(project);
    if (configFile != null) {
      const config = JSON.parse(configFile.fileContent);
      let reportsDirectory;
      const reportsDirContent = project.content.find(dir => dir.type === FileType.Directory && dir.name === config.reportsDir);
      if (reportsDirContent) {
        reportsDirectory = this.createReportsDirectory(reportsDirContent);
      }
      
      const createdProject = StafProject.fromObject({
        id: this.sequence.getNext('project'),
        name: config.project,
        description: config.description,
        location: project.path.substr(project.path.lastIndexOf('/') + 1),
        type: config.type,
        testSuites: this.testSuiteService.extractTestSuitesFromProject(project, config),
        logDir: config.logDir,
        reportsDirPath: config.reportsDir,
      }, reportsDirectory);
      this.compileProject(project.name).subscribe((compiledTestSuites: CompiledTestSuite[]) => {
        createdProject.compiledFiles = compiledTestSuites;
      });
     
      return createdProject;
    }
    return null;
  }

  createReportsDirectory(reportsDirContent): IDirectory {
    return {
      name: reportsDirContent.name,
      type: FileType.Directory,
      content: this.testSuiteService.readDirectory(reportsDirContent)
    };
  }

  compileProject(projectLocation) {
    return this.http.get(baseUrl + StafAPI.COMPILE_PROJECT + '/' + projectLocation);
  }

  compileFile(filePath) {
    return this.http.get(baseUrl + StafAPI.COMPILE_FILE + '?filePath=' + filePath);
  }

  addProject(project: IStafProject) {
    this.http.post(baseUrl + StafAPI.CREATE_PROJECT, project)
      .subscribe((res: any) => {
        if (res.error) {
          this.toastr.error('Another project with the same name already exists', 'Error');
        } else {
          this.projects.push(this.createProject(res));
          this.projectsSubject.next(this.projects);
        }
        this.toastr.success('Project created', 'Success');
      }, err => { this.toastr.error('Error creating project', 'Error') });
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
    return this.projects.find(p => p.getNormalizedProjectName() == name);
  }

  getProjectByLocation(location: string): StafProject {
    return this.projects.find(p => p.location == location);
  }

  getEmptyProject(): IStafProject {
    return {
      id: 0,
      name: '',
      description: '',
      location: '',
      logDir: 'logs',
      reportsDirPath: 'reports',
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
    const payload = {
      content: file.content,
      name: file.name,
      path: file.path,
      type: file.type
    }
    return this.http.post(baseUrl + StafAPI.SAVE_FILE, payload);
  }

  getImage(screenShotPath: string): Observable<IGetImage64> {
    return this.http.get<IGetImage64>(baseUrl + StafAPI.GET_SCREENSHOT + '/' + screenShotPath.replace(/\//g, '<sep>'));
  }

  getReports(projectLocation: string) { // Get a flat list of all reports files
    return this.http.get(baseUrl + StafAPI.GET_PROJECT_REPORTS + '/' + projectLocation);
  }

  getTestReport(filePath: string) { // Get a specific test report file
    return this.http.get(baseUrl + StafAPI.GET_TEST_REPORT_FILE + '/' + filePath.replace(/\//g, '<sep>'));
  }

  getProjectReportsDirectory(projectLocaiton: string) {
    return this.http.get(baseUrl + StafAPI.GET_REPORTS_DIRECTORY + '/' + projectLocaiton);
  }

  searchFilesByExtension(project: StafProject, extension: string) {
    let foundFiles = [];
    project.testSuites.forEach(testSuite => {
      foundFiles = foundFiles.concat(this.searchDirectory(testSuite.content, (f: IFile) => f.extension === extension));
    });
    return foundFiles;
  }

  searchDirectory(directory: IDirectory, filter: Function) {
    let foundFiles = [];
    directory.content.forEach(f => {
      if (f.type == FileType.Directory) {
        foundFiles = foundFiles.concat(this.searchDirectory(f as IDirectory, filter));
      } else if (f.type == FileType.File) {
        if (filter(f)) {
          foundFiles.push(f);
        }
      }
    });
    return foundFiles;
  }

  renameTestSuite(project: StafProject, testSuite: ITestSuite, newName: string) {
    const payload = {
      projectName: project.getNormalizedProjectName(),
      oldTestSuiteName: testSuite.name,
      newTesSuiteName: newName
    }
    return this.http.put(baseUrl + StafAPI.RENAME_TEST_SUITE, payload)
      .subscribe((response: IGenericResponse) => {
        if (response.result == GenericResponse.Ok) {
          this.toastr.success('Test suite renamed successfully');
          this.reloadProject(project);
        } else {
          this.toastr.error('Error renaming test suite');
        }
      });
  }

  updateProjectData(project:StafProject, newName: string, description: string) {
    const payload = {
      oldProjectName: project.name,
      newProjectName: newName,
      description
    }
    this.http.put(baseUrl + StafAPI.UPDATE_PROJECT, payload)
    .subscribe((response: IGenericResponse) => {
      if (response.result == GenericResponse.Ok) {
        this.toastr.success('Project updated successfully');
        this.reloadProject(project);
      } else {
        this.toastr.error('Error updating project');
      }
    });
  }

  updateProjectConfig(project: StafProject, projectName: string, description: string, 
    logDirectory: string, reportDirectory: string, location: string, 
    originalLocation: string, reloadProject: boolean) {
    const payload = {
      project: projectName, 
      description,
      location,
      logDir: logDirectory,
      reportsDir: reportDirectory,
    };
    this.http.put(baseUrl + StafAPI.UPDATE_PROJECT_CONFIG + '/' + originalLocation, payload)
    .subscribe((response: IGenericResponse) => {
      if (response.result == GenericResponse.Ok) {
        this.toastr.success('Project config updated successfully');
        project.location = location;
        project.description = description;
        project.name = projectName;
        project.logDir = logDirectory;
        project.reportsDirPath = reportDirectory;
        if (reloadProject) {
          this.reloadProject(project);
        }
      } else {
        this.toastr.error('Error updating project');
      }
    });
  }

  reloadProject(project: StafProject) {
    this.toastr.info('Reloading project files');
    this.fetchProject(project);
  }

  renameFile(file: IFile, parent: IDirectory, newName: string) {
    const payload = {
      filePath: file.path,
      newName
    };
    this.http.put(baseUrl + StafAPI.RENAME_FILE, payload).subscribe((res: any) => {
      if (res.result == GenericResponse.Ok) {
        this.toastr.success('File renamed', 'Success');
        const originalName = file.name;
        file.name = newName;
        file.path = file.path.replace(/\/[^\/]*$/, '') + '/' + file.name;
        if (file.type === FileType.Directory) {
          this.fetchDirectory(file as IDirectory, parent, originalName);
        }

      } else {
        this.toastr.error('Cannot rename file', 'Error');
      }
    });
  }

  fetchDirectory(directory: IDirectory, parent: IDirectory, originalName: string) {
    this.http.get(baseUrl + StafAPI.GET_DIRECTORY + '?path=' + directory.path)
      .subscribe((res: any) => {
        const newDirectoryContent = this.testSuiteService.readDirectory(res);
        directory.content = newDirectoryContent;
        parent.content.delete(originalName);
        parent.content.set(res.name, directory); 
      });
  }

  updateDirectoryName(parent: IDirectory, directory: IDirectory, newName: string) {
    parent.content.delete(directory.name);
    parent.content.set(newName, directory);
    directory.name = newName;
    directory.content
  }

  uploadProject(projectFile) {
    const data: FormData = new FormData();
    data.append('file', projectFile);
    return this.http.post(baseUrl + StafAPI.UPLOAD_PROJECT, data);
  }
}
