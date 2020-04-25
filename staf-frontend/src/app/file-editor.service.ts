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
    private router: Router) { }

  setFile(file: IFile) {
    this.openedFiles.set(file.name, file);
  }

  getFile(name) {
    return this.openedFiles.get(name);
  }

  openFile(item: any, project: StafProject) {debugger;
    if (item.type == FileType.Directory) {
      this.projectService.currentDir = item;
      this.router.navigate(['directory', project.getNormalizedProjectName(), item.name]);
    } else if (this.isTextFile(item)) {
      this.setFile(item);
      this.router.navigate(['editFile', project.getNormalizedProjectName(), item.name, item.path]);
    } else if (this.isImageFile(item)) {
      this.setFile(item);
      this.router.navigate(['viewImage', project.getNormalizedProjectName(), item.name, item.path]);
    }
  }


  isTextFile(file) {
    return file.extension == 'txt' 
      || file.extension == "staf"
      || file.extension == "page"
      || file.extension == "steps"
      || file.extension == "step"
  }

  isImageFile(item) {
    return item.extension == "png"
      || item.extension == "jpg"
      || item.extension == "jpeg"
  }
}
