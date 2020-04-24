import { FileType } from './../interfaces/ifile';
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
  project;
  file;
  content = '';
  fileChanged = false;
  saveModal = false;

  editorOptions = {theme: 'vs-dark', language: 'staf'};

  pathSplitted = [];

  private keyEventListener = e => {

    if (this.file.content != this.content) {
      this.fileContentChanged(this.file);
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
      this.filePath = this.route.snapshot.paramMap.get('filePath');
      this.project = this.projectService.getProjectByName(projectName);
      
      if (this.file && this.file.content != this.content) {
        this.showSaveDialog(this.content)
      } else {
        this.openFile();
      }
    });
  }

  ngOnDestroy(): void {
    document.removeEventListener('keydown', this.keyEventListener);
  }

  openFile() {
    this.saveModal = false;
    let file = this.fileEditorService.getFile(this.filePath);
    if (file == null) {
      this.router.navigate(['/']);
    } else {
      this.file = file;
      this.content = file.content as string;
      this.fileChanged = false;
      this.pathSplitted = file.path.split('/');
      let origPaths = this.pathSplitted.shift();
      
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

  fileContentChanged(file) {
    console.log('file chagned')
    this.fileChanged = true;
  }

  saveFile() {
    this.fileChanged = false;
    this.file.content = this.content;
    this.projectService.saveFile(this.file).subscribe(res => {
      this.toastr.success('File saved', 'Success');
    }, err => this.toastr.error('Cannot save file', 'Error'));
  }

  showSaveDialog(orig) {
    this.saveModal = true;
  }

  resetFileContent() {
    this.file.content = this.content;
    this.saveModal = false;
    this.openFile();
  }
}
