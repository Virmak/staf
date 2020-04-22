import { FileEditorService } from './../file-editor.service';
import { StafProject } from './../types/staf-project';
import { IDirectory } from './../interfaces/idirectory';
import { ProjectService } from './../project.service';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-directory',
  templateUrl: './view-directory.component.html',
  styleUrls: ['./view-directory.component.css']
})
export class ViewDirectoryComponent implements OnInit {

  @Input() directory: IDirectory;
  project: StafProject;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectService: ProjectService,
    public fileEditor: FileEditorService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( paramMap => {
      this.directory = this.projectService.currentDir;
      if (this.directory == null) {
        this.router.navigate(['/']);
      } else {
        this.project = this.projectService.getProjectByName(paramMap.get('project'))
      }
    });
  }

  openItem(item) {
    this.fileEditor.openFile(item.value, this.project);
  }
}
