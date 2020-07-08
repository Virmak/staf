import { monacoConfig } from './monaco.config';
import { LogModule } from './log/log.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClarityModule } from '@clr/angular';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { EditFileComponent } from './edit-file/edit-file.component';
import { ProjectOverviewComponent } from './project-overview/project-overview.component';
import { ContextMenuModule } from 'ngx-contextmenu';
import { SidenavDirectoryComponent } from './sidenav-directory/sidenav-directory.component';
import { ViewDirectoryComponent } from './view-directory/view-directory.component';
import { ToastrModule } from 'ngx-toastr';
import { RunTestComponent } from './run-test/run-test.component';
import { ReportComponent } from './report/report.component';
import { DirStackBlockComponent } from './dir-stack-block/dir-stack-block.component';
import { ImageViewerComponent } from './image-viewer/image-viewer.component';
import { SafeHtmlPipe } from './safe-html.pipe';
import { MonacoEditorModule } from 'ngx-monaco-editor';
import { ItemTypePipe } from './item-type.pipe';
import { LogConsoleComponent } from './log-console/log-console.component';
import { SettingsModalComponent } from './settings-modal/settings-modal.component';
import { TestDataComponent } from './test-data/test-data.component';
import { CsvEditorComponent } from './csv-editor/csv-editor.component';
import { NoFileComponent } from './no-file/no-file.component';
import { HotTableModule } from '@handsontable/angular';
import { TestSuiteOverviewComponent } from './test-suite-overview/test-suite-overview.component';
import { TestSuiteRowDetailsComponent } from './test-suite-row-details/test-suite-row-details.component';
import { CreateFileModalComponent } from './create-file-modal/create-file-modal.component';
import { RenameTestSuiteComponent } from './rename-test-suite/rename-test-suite.component';
import { ProjectConfigComponent } from './project-config/project-config.component';
import { RenameFileModalComponent } from './rename-file-modal/rename-file-modal.component';
import { DocsComponent } from './docs/docs.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidenavComponent,
    CreateProjectComponent,
    DashboardComponent,
    ProjectDetailsComponent,
    EditFileComponent,
    ProjectOverviewComponent,
    SidenavDirectoryComponent,
    ViewDirectoryComponent,
    RunTestComponent,
    ReportComponent,
    DirStackBlockComponent,
    ImageViewerComponent,
    SafeHtmlPipe,
    ItemTypePipe,
    LogConsoleComponent,
    SettingsModalComponent,
    TestDataComponent,
    CsvEditorComponent,
    NoFileComponent,
    TestSuiteOverviewComponent,
    TestSuiteRowDetailsComponent,
    CreateFileModalComponent,
    RenameTestSuiteComponent,
    ProjectConfigComponent,
    RenameFileModalComponent,
    DocsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ClarityModule,
    BrowserAnimationsModule,
    ContextMenuModule.forRoot(),
    MonacoEditorModule.forRoot(monacoConfig),
    HttpClientModule,
    ToastrModule.forRoot(),
    HotTableModule,
    LogModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
