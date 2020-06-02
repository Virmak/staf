import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-dir-stack-block',
  templateUrl: './dir-stack-block.component.html',
  styleUrls: ['./dir-stack-block.component.css']
})
export class DirStackBlockComponent implements OnInit {

  @Input() directory;

  constructor() { }

  ngOnInit(): void {
  }

}
