import { IDirectory } from './../interfaces/idirectory';
import { ProjectService } from 'src/app/project.service';
import { IFile, FileType } from './../interfaces/ifile';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-rename-file-modal',
  templateUrl: './rename-file-modal.component.html',
  styleUrls: ['./rename-file-modal.component.css']
})
export class RenameFileModalComponent implements OnInit {
  fileTypes = FileType;
  @Input() renameModalOpened = false;
  @Input() file: IFile;
  @Input() parent: IDirectory;

  directoryHasOpenedFiles = false;
  newFileName: string;

  @Output() renameFileModalChanged = new EventEmitter();

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.newFileName = this.file.name;    
  }

  openChanged(e) {
    this.renameFileModalChanged.emit(e);
  }

  renameFile() {
    this.projectService.renameFile(this.file,  this.parent, this.newFileName);
    this.renameModalOpened = false;
  }

}
