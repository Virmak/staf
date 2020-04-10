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
import { AceEditorComponent } from './ace-editor/ace-editor.component';
import { AceEditorModule } from 'ng2-ace-editor';
import { ViewDirectoryComponent } from './view-directory/view-directory.component';
import { ToastrModule } from 'ngx-toastr';
import { RunTestComponent } from './run-test/run-test.component';
import { ReportComponent } from './report/report.component';
import { DirStackBlockComponent } from './dir-stack-block/dir-stack-block.component';
import { ImageViewerComponent } from './image-viewer/image-viewer.component';
import { SafeHtmlPipe } from './safe-html.pipe';

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
    AceEditorComponent,
    ViewDirectoryComponent,
    RunTestComponent,
    ReportComponent,
    DirStackBlockComponent,
    ImageViewerComponent,
    SafeHtmlPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ClarityModule,
    BrowserAnimationsModule,
    ContextMenuModule.forRoot(),
    AceEditorModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    LogModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }