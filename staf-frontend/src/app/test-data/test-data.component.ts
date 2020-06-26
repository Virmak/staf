import { IFile } from './../interfaces/ifile';
import { StafProject } from './../types/staf-project';
import { ProjectService } from 'src/app/project.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-test-data',
  templateUrl: './test-data.component.html',
  styleUrls: ['./test-data.component.css']
})
export class TestDataComponent implements OnInit {
  @Input() project: StafProject;
  dataFiles = [];
  createDataFileModal = false;
  

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    const projectName = this.project.getNormalizedProjectName();
    this.dataFiles = this.projectService.searchFilesByExtension(this.project, 'csv')
      .map((file:IFile) => {
        file.relativePath = file.path.substr(file.path.indexOf(projectName) + projectName.length + 1);
        return file;
      });
  }

  createDataFile() {

  }
}
