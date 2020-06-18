import { IFile } from './interfaces/ifile';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FileExplorerService {
  openedFiles = [];

  constructor() { }

  openFile(file: IFile) {
    if (this.openedFiles.indexOf(file) == -1) {
      this.openedFiles.push(this.openedFiles);
    }
  }

  closeFile(file: IFile) {
    const fileIndex = this.openedFiles.indexOf(file);
    this.openedFiles.splice(fileIndex, 1);
  }
}
