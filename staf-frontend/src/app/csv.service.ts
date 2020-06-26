import { Injectable } from '@angular/core';
import { FileEditorService } from './file-editor.service';
import { Papa } from 'ngx-papaparse';
import { IFile } from './interfaces/ifile';

@Injectable({
  providedIn: 'root'
})
export class CsvService {

  headers = [];
  cellModels = [];
  csvRecords = [];

  constructor(
    private papa: Papa) { }

  readCsvFile(file: IFile) {
    file.originalContent = file.content as string;
    this.papa.parse(file.content as string, {
      complete: (result) => {
        this.cellModels = [];

        this.headers = result.data.slice(0, 1);
        this.csvRecords = result.data.slice(1);
        this.csvRecords.forEach(lines => {
          this.cellModels.push([]);
          lines.forEach(cell => this.cellModels[this.cellModels.length - 1].push(cell));
        });
      },
      skipEmptyLines: true,
    });
  }

  writeCsvFile(file: IFile) {
    const csvString = this.papa.unparse([...this.headers, ...this.cellModels], {header: true});
    file.content = csvString;
  }
}
