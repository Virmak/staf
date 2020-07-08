import { DocsService } from './../docs.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-docs',
  templateUrl: './docs.component.html',
  styleUrls: ['./docs.component.css']
})
export class DocsComponent implements OnInit {

  librariesDocs = [];

  constructor(private docsService: DocsService) { }

  ngOnInit(): void {
    this.docsService.getBuiltinLibrariesKeywords()
      .subscribe((librariesDoc: any[]) => {
        this.librariesDocs = librariesDoc;
      });
  }

}
