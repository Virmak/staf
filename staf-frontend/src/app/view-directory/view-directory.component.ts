import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-directory',
  templateUrl: './view-directory.component.html',
  styleUrls: ['./view-directory.component.css']
})
export class ViewDirectoryComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( paramMap => {
      console.log(paramMap);
    })
  }

}
