import { IFile } from './../interfaces/ifile';
import { Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';

import * as ace from 'ace-builds/src-noconflict/ace';


ace.config.set('basePath', '/assets/');
ace.config.set('modePath', '/assets');
ace.config.set('themePath', '');

@Component({
  selector: 'app-ace-editor',
  templateUrl: './ace-editor.component.html',
  styleUrls: ['./ace-editor.component.css']
})
export class AceEditorComponent implements OnInit, OnDestroy {
  private _file;
  private originalContent = '';
  private textChanged = false;


  @Output() contentChanged = new EventEmitter();
  @Output() onQuit = new EventEmitter();

  @Input() set file(value: IFile) {
    this._file = value;
    if (this._file) {
      this.originalContent = this._file.content;
    }


  }
  get file() {
    return this._file;
  }

  constructor() { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    if (this._file && this._file.content != this.originalContent) {
      this.onQuit.emit(this.originalContent);
    }
  }

  getStringHash(s) {
    return s.split("").reduce((a, b) => { a = ((a << 5) - a) + b.charCodeAt(0); return a & a }, 0);
  }

}
