import { Injectable } from '@angular/core';
import { IFile } from './interfaces/ifile';

@Injectable({
  providedIn: 'root'
})
export class FileEditorService {

  openedFiles: Map<string, IFile> = new Map();

  constructor() { }

  setFile(file: IFile) {
    this.openedFiles.set(file.name, file);
  }

  getFile(name) {
    return this.openedFiles.get(name);
  }
}
