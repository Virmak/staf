import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-statement-name',
  templateUrl: './statement-name.component.html',
  styleUrls: ['./statement-name.component.css']
})
export class StatementNameComponent implements OnInit {
  private _statement;
  assign;
  keyword;
  arguments = "";

  @Input() set statement(value) {
    this._statement = value;
    if (this._statement.object && this._statement.object.type == 'VAR_REF') {
      this.assign = this._statement.object.value + " = ";
      this.keyword = this._statement.value.keywordName;

      for (let i = 0; i < this._statement.value.argumentsList.length; i++) {
        this.arguments += this._statement.value.argumentsList[i].value + ", ";
      }
      this.arguments = this.arguments.substr(0, this.arguments.length - 2);
    } else if (this._statement.type == 'KEYWORD_CALL'){ 
      this.keyword = this._statement.keywordName;

      for (let i = 0; i < this._statement.argumentsList.length; i++) {
        this.arguments += this._statement.argumentsList[i].value + ", ";
      }

      this.arguments = this.arguments.substr(0, this.arguments.length - 2);
    } else if (this._statement.iterator != undefined) {
      this.keyword = 'FOR ';
      this.arguments = this._statement.var.value + ' IN ' + this._statement.iterator.type;
    }
  }

  get statement() {
    return this._statement;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
