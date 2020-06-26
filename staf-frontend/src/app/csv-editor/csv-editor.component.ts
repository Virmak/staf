import { CsvService } from './../csv.service';
import { IFile } from "./../interfaces/ifile";
import { StafProject } from "./../types/staf-project";
import { Component, OnInit, OnDestroy } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { ProjectService } from "../project.service";
import { FileEditorService } from "../file-editor.service";

@Component({
  selector: "app-csv-editor",
  templateUrl: "./csv-editor.component.html",
  styleUrls: ["./csv-editor.component.css"],
})
export class CsvEditorComponent implements OnInit, OnDestroy {
  file: IFile;
  filePath;
  project: StafProject;
  selectAllCheckbox = false;
  selectedRows = [];
  rowsCheckboxModels = [];

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
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((paramMap) => {
      const projectName = this.route.snapshot.paramMap.get("project");
      this.filePath = this.route.snapshot.paramMap.get("path");
      this.project = this.projectService.getProjectByName(projectName);
      if (this.project == null) {
        this.router.navigate(["/"]);
        return;
      }
      this.file = this.fileEditor.getFile(this.filePath);
      this.csv.readCsvFile(this.file);
      this.rowsCheckboxModels = Array(this.csv.cellModels.length).fill(false);
    });
  }

  newLine() {
    const columnsCount = this.csv.csvRecords[0].length;
    const newRow = Array(columnsCount).fill('');
    this.csv.csvRecords.push(newRow);
    this.csv.cellModels.push(Array(columnsCount).fill(''));
    this.rowsCheckboxModels.push(false);
    this.file.changed = true;
  }

  save() {
    this.csv.writeCsvFile(this.file);
    this.fileEditor.saveFile(this.file);
  }

  deleteLines() {
    let removedLines = 0;
    this.rowsCheckboxModels.forEach((rowCheckBox, index)  => {
      if (rowCheckBox) {
        this.removeLine(index - removedLines);
        removedLines++;
      }
    });
    this.rowsCheckboxModels = this.rowsCheckboxModels.filter(rowCheckBox => !rowCheckBox);
    if (removedLines > 0) {
      this.file.changed = true;
    }
    
  }

  removeLine(index) {
    this.csv.csvRecords.splice(index, 1);
    this.csv.cellModels.splice(index, 1);
  }


  fileChanged() {
    this.file.changed = true;
  }

  toggleSelectAllRows(e) {
    this.rowsCheckboxModels = this.rowsCheckboxModels.map(cb => e.target.checked);
  }
}
