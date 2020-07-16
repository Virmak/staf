import { CsvService } from './csv.service';
import { ToastrService } from 'ngx-toastr';
import { StafProject } from './types/staf-project';
import { Router } from '@angular/router';
import { ProjectService } from './project.service';
import { Injectable } from '@angular/core';
import { IFile, FileType } from './interfaces/ifile';

@Injectable({
  providedIn: 'root'
})
export class FileEditorService {

  openedFiles: Map<string, IFile> = new Map();

  constructor(
    private projectService: ProjectService,
    private router: Router,
    private toastr: ToastrService,
    private csv: CsvService) { }

  setFile(file: IFile) {
    this.openedFiles.forEach(f => f.active = false);
    this.openedFiles.set(file.path, file);
    file.active = true;
  }

  unsetFile(file: IFile) {
    file.active = false;
    file.changed = false;
    this.openedFiles.delete(file.path);
    if (this.openedFiles.size == 0) {
      this.router.navigate(['noFile']);
    } else {
      let nextFile: any = this.openedFiles.values().next().value;
      this.openFile(nextFile, nextFile.project);
    }
  }

  closeFile(file: IFile, key: string, save: boolean) {
    if (save) {
      if (this.isCsvFile(file)) {
        this.csv.writeCsvFile(file);
      }
      this.projectService.saveFile(file).subscribe(res => {
        this.toastr.success('File saved', 'Success');
        file.changed = false;
        file.originalContent = file.content as string;
        this.unsetFile(file);
      }, err => this.toastr.error('Cannot save file', 'Error'));
    } else {
      file.content = file.originalContent;
      if (this.isCsvFile(file)) {
        this.csv.readCsvFile(file).then(r => {});
      }
      this.unsetFile(file);
    }
  }

  saveFile(file, completeCallback = null) {
    this.projectService.saveFile(file).subscribe(res => {
      this.toastr.success('File saved', 'Success');
      file.changed = false;
      file.originalContent = file.content as string;
      if (completeCallback) {
        completeCallback();
      }
    }, err => {console.error(err); this.toastr.error('Cannot save file', 'Error')});
  }

  getFile(name): IFile {
    return this.openedFiles.get(name);
  }

  openFile(item: any, project: StafProject) {
    if (item.type == FileType.Directory) {
      debugger
      this.projectService.currentDir = item;
      this.router.navigate(['directory', project.getNormalizedProjectName(), item.name]);
    } else if (this.isTextFile(item)) {
      if (item.project == undefined) { item.project = project; }
      this.setFile(item);
      this.router.navigate(['editFile', project.getNormalizedProjectName(), item.name, item.path]);
    } else if (this.isCsvFile(item)) {
      this.setFile(item);
      this.router.navigate(['csvEditor', item.project.getNormalizedProjectName(), item.path]);
    } else if (this.isImageFile(item)) {
      this.setFile(item);
      this.router.navigate(['viewImage', project.getNormalizedProjectName(), item.path, item.path]);
    }
  }

  openFileByPath(filePath) {
    const splittedPath = filePath.split("/");
    
    const relativeFilePath = filePath.substr(
      filePath.indexOf(this.projectService.testDirectory)
    );

    return this.router.navigate([
      "editFile",
      splittedPath[0],
      splittedPath[splittedPath.length - 1],
      relativeFilePath,
    ]);
  }

  isTextFile(file) {
    return file.extension == 'txt' 
      || file.extension == "staf"
      || file.extension == "page"
      || file.extension == "steps"
      || file.extension == "step"
  }

  isCsvFile(file) {
    return file.extension == 'csv';
  }

  isImageFile(item) {
    return item.extension == "png"
      || item.extension == "jpg"
      || item.extension == "jpeg"
  }
}
