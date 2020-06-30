import { Injectable } from '@angular/core';
import { FileEditorService } from './file-editor.service';
import { Papa } from 'ngx-papaparse';
import { IFile } from './interfaces/ifile';

@Injectable({
  providedIn: 'root'
})
export class CsvService {

  headers = [];
  csvRecords = [];
  originalDataset;

  constructor(
    private papa: Papa) { }

  readCsvFile(file: IFile) {
    const promise = new Promise((resolve, reject) => {
      file.originalContent = file.content as string;
      this.papa.parse(file.content as string, {
        complete: (result) => {
          this.csvRecords = result.data;
          this.headers = result.meta.fields;
          resolve(result);
        },
        skipEmptyLines: true,
        header: true,
      });
    });
    return promise;
  }

  writeCsvFile(file: IFile) {
    const csvString = this.papa.unparse(this.csvRecords, {header: true});
    file.content = csvString;
  }
}
