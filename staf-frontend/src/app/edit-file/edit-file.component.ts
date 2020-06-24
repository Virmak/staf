import { ITestSuite } from './../interfaces/itest-suite';
import { StafProject } from './../types/staf-project';
import { FileType, IFile } from './../interfaces/ifile';
import { FileEditorService } from './../file-editor.service';
import { ProjectService } from './../project.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit-file',
  templateUrl: './edit-file.component.html',
  styleUrls: ['./edit-file.component.css']
})
export class EditFileComponent implements OnInit, OnDestroy {

  filePath;
  project: StafProject;
  file: IFile;

  vsThemes = [
    {value:'vs', name: 'Light theme'},
    {value:'vs-dark', name: 'Dark theme'},
    {value:'hc-black', name: 'High contrast'}
  ];
  selectedTheme = this.vsThemes[1];
  editorOptions = {theme: this.selectedTheme.value, language: 'staf'};

  pathSplitted = [];

  allTestSuite = {id:999, name: 'All', content: null};
  testSuites: ITestSuite[];
  selectedTestSuite: ITestSuite = this.allTestSuite;

  private keyEventListener = e => {
    if (this.file.content != this.file.originalContent) {
      this.file.changed = true;
    } else {
      this.file.changed = false;
    }

    if (!(e.which == 83 && e.ctrlKey)) return true;
    this.saveFile();
    event.preventDefault();
    return false;
  };



  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private projectService: ProjectService, 
    public fileEditorService: FileEditorService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    document.addEventListener('keydown', this.keyEventListener);
    this.route.paramMap.subscribe( paramMap => {
      const projectName = this.route.snapshot.paramMap.get('project');
      this.filePath = this.route.snapshot.paramMap.get('fullPath');
      this.project = this.projectService.getProjectByName(projectName);
      if (this.project == null) {
        this.router.navigate(['/']);
        return;
      }
      this.testSuites = [this.allTestSuite, ...this.project.testSuites];
      this.openFile();
    });
  }

  ngOnDestroy(): void {
    document.removeEventListener('keydown', this.keyEventListener);
  }

  openFile() {
    let file = this.fileEditorService.getFile(this.filePath);
    if (file == null) {
      this.router.navigate(['/']);
    } else {
      this.file = file;
      this.file.originalContent = this.file.content as string;
      this.pathSplitted = file.path.split('/');
      
      let i;
      for (i = 0; i < this.pathSplitted.length - 1; i++) {
        this.pathSplitted[i] = {
          name: this.pathSplitted[i],
          type: FileType.Directory,
        }
      }
      this.pathSplitted[i] = {
        name: this.pathSplitted[i],
        type: FileType.File,
      }
    }
  }

  saveFile() {
    this.fileEditorService.saveFile(this.file);
  }

  onInitEditor(editor) {

  }
}
