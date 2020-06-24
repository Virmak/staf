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
    private toastr: ToastrService) { }

  setFile(file: IFile) {
    this.openedFiles.forEach(f => f.active = false);
    this.openedFiles.set(file.path, file);
    file.active = true;
  }

  closeFile(file: IFile, key: string, save: boolean) {
    if (save) {
      this.projectService.saveFile(file).subscribe(res => {
        this.toastr.success('File saved', 'Success');
        file.changed = false;
        file.originalContent = file.content as string;
        this.openedFiles.delete(key);
      }, err => this.toastr.error('Cannot save file', 'Error'));
    } else {
      file.content = file.originalContent;
      this.openedFiles.delete(key);
    }
  }

  saveFile(file) {
    this.projectService.saveFile(file).subscribe(res => {
      this.toastr.success('File saved', 'Success');
      file.changed = false;
      file.originalContent = file.content as string;
    }, err => this.toastr.error('Cannot save file', 'Error'));
  }

  getFile(name) {
    return this.openedFiles.get(name);
  }

  openFile(item: any, project: StafProject) {
    if (item.type == FileType.Directory) {
      this.projectService.currentDir = item;
      this.router.navigate(['directory', project.getNormalizedProjectName(), item.name]);
    } else if (this.isTextFile(item)) {
      if (item.project == undefined) { item.project = project; }
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
