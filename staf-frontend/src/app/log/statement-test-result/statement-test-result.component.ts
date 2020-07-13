import { ProjectService } from './../../project.service';
import { Component, OnInit, Input } from '@angular/core';
import { TestSuiteResultComponent } from '../test-suite-result/test-suite-result.component';

@Component({
  selector: 'app-statement-test-result',
  templateUrl: './statement-test-result.component.html',
  styleUrls: ['./statement-test-result.component.css']
})
export class StatementTestResultComponent implements OnInit {

  _statement;

  screenshotModalOpenend = false;

  @Input() set statement(value) {
    this._statement = value;
    this._statement.elapsed = TestSuiteResultComponent.getTimeString((new Date(value.end)).getTime()
      - (new Date(value.start)).getTime());
    this._statement.expanded = '+';
    this._statement.badge = this._statement.result == 'Pass' ? 'badge-success' : 'badge-danger';
    
    if (this._statement.screenShot) {
      this.projectService.getImage(this._statement.screenShot)
      .subscribe((img:any) => this._statement.imageBase64 = img.imageData);
    }
  }

  get statement() {
    return this._statement;
  }

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
  }

  toggleExpand() {
    this._statement.expanded = this._statement.expanded == '+' ? '-' : '+';
  }
}
