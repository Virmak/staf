import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ViewLogComponent } from './view-log/view-log.component';
import { TestSuiteResultComponent } from './test-suite-result/test-suite-result.component';



@NgModule({
  declarations: [
    ViewLogComponent,
    TestSuiteResultComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ViewLogComponent,
  ]
})
export class LogModule { }
