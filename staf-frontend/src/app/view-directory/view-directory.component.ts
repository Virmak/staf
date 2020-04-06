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

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectService: ProjectService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( paramMap => {
      console.log(this.projectService.currentDir);
      this.directory = this.projectService.currentDir;
      if (this.directory == null) {
        this.router.navigate(['/']);
      }
    })
  }

}
