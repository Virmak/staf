import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ViewLogComponent } from './view-log/view-log.component';
import { TestSuiteResultComponent } from './test-suite-result/test-suite-result.component';
import { TestCaseResultComponent } from './test-case-result/test-case-result.component';
import { StatementTestResultComponent } from './statement-test-result/statement-test-result.component';
import { StatementNameComponent } from './statement-name/statement-name.component';



@NgModule({
  declarations: [
    ViewLogComponent,
    TestSuiteResultComponent,
    TestCaseResultComponent,
    StatementTestResultComponent,
    StatementNameComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ViewLogComponent,
  ]
})
export class LogModule { }
