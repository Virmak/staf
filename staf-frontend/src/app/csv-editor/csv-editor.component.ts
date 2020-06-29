import { CsvService } from './../csv.service';
import { IFile } from "./../interfaces/ifile";
import { StafProject } from "./../types/staf-project";
import { Component, OnInit, OnDestroy, ViewChild } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { ProjectService } from "../project.service";
import { FileEditorService } from "../file-editor.service";
import { HotTableComponent } from '@handsontable/angular';
import Handsontable from 'handsontable';

@Component({
  selector: "app-csv-editor",
  templateUrl: "./csv-editor.component.html",
  styleUrls: ["./csv-editor.component.css"],
})
export class CsvEditorComponent implements OnInit, OnDestroy {
  file: IFile;
  filePath;
  project: StafProject;
  showEditColumnsModal = false;
  newColName = '';
  newColData = '';

  @ViewChild("hot", { static: false }) hot: HotTableComponent;

  private keyEventListener = e => {
    if (this.file.content != this.file.originalContent) {
      this.file.changed = true;
    } else {
      this.file.changed = false;
    }

    if (!(e.which == 83 && e.ctrlKey)) return true;
    this.save();
    event.preventDefault();
    return false;
  };


  fileChanged = (hotInstance, changes, source) => {
    if (changes == 'edit' && this.file) {
      this.file.changed = true;
    }
  }

  rowRemoved = () => {
    this.file.changed = true;
  }

  rowCreated = () => {
    this.file.changed = true;
  }

  settings:any = {
    data: Handsontable.helper.createSpreadsheetData(10, 10),
    colHeaders: true,
    rowHeaders: true,
    stretchH: 'all',
    contextMenu: true,
    licenseKey: 'non-commercial-and-evaluation'
  }


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectService: ProjectService,
    public fileEditor: FileEditorService,
    public csv: CsvService
  ) {}
  ngOnDestroy(): void {
    if (this.file) {
      this.csv.writeCsvFile(this.file);
    }
    document.removeEventListener('keydown', this.keyEventListener);
  }

  ngOnInit(): void {
    document.addEventListener('keydown', this.keyEventListener);
    let init = true; // used to determine if last route was csv-editor
    this.route.paramMap.subscribe((paramMap) => {
      if (!init && this.file && this.file.changed) {
        this.csv.writeCsvFile(this.file);
      }
      const projectName = this.route.snapshot.paramMap.get("project");
      this.filePath = this.route.snapshot.paramMap.get("path");
      this.project = this.projectService.getProjectByName(projectName);
      if (this.project == null) {
        this.router.navigate(["/"]);
        return;
      }
      this.file = this.fileEditor.getFile(this.filePath);
      this.file.originalContent = this.file.content as string;
      this.csv.readCsvFile(this.file).then((result: any) => {
        this.settings.data = this.csv.csvRecords;
        this.settings.columns = result.meta.fields.map(f => {
          return {data: f, title: f};
        });
        this.updateTable();
      });
    });
    init = false;
  }

  
  save() {
    this.csv.writeCsvFile(this.file);
    this.fileEditor.saveFile(this.file);
  }

  selectModalColumn(col) {
    this.newColData = col.data;
    this.newColName = col.title;
  }

  saveColumn() {
    const col = this.settings.columns.find(col => col.data === this.newColData);
    if (col) {
      col.title = this.newColName;
    } else {
      this.settings.columns.push({
        data: this.newColData,
        title: this.newColName,
      });
    }
    if (this.csv.csvRecords == null || this.csv.csvRecords.length == 0) {
      const rowData = {};
      this.settings.columns.forEach(col => rowData[col.data] = '');
      this.csv.csvRecords.push(rowData);
    }
  }

  newColumn() {
    this.newColData = '';
    this.newColName = '';
  }

  closeColumnsModal() {
    this.showEditColumnsModal = false;
    this.updateTable();
  }

  updateTable() {
    this.hot.updateHotTable(this.settings);
    this.file.changed = true;
  }

  removeColumn() {
    const colIndex = this.settings.columns.findIndex(col => col.data === this.newColData);
    if (colIndex > -1) {
      this.settings.columns.splice(colIndex, 1);
      this.updateTable();
    }
  }
}
