import { ProjectService } from 'src/app/project.service';
import { ActivatedRoute } from '@angular/router';
import { FileEditorService } from './../file-editor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-image-viewer',
  templateUrl: './image-viewer.component.html',
  styleUrls: ['./image-viewer.component.css']
})
export class ImageViewerComponent implements OnInit {

  file;
  filePath;

  constructor(private fileEditorService: FileEditorService,
    private projectService: ProjectService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
      this.filePath = paramMap.get('filePath');
      this.file = this.fileEditorService.getFile(this.filePath);
      this.projectService.getImage(this.file.path)
        .subscribe(image => {
          this.file.content = image.imageData;
        });
    })
  }

}
