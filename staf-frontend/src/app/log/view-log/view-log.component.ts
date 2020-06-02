import { IStafProject } from './../../interfaces/istaf-project';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-view-log',
  templateUrl: './view-log.component.html',
  styleUrls: ['./view-log.component.css']
})
export class ViewLogComponent implements OnInit {
  @Input() reports = [];

  constructor() { }

  ngOnInit(): void {
  }

}
