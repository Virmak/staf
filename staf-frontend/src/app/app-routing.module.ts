import { ProjectsComponent } from './projects/projects.component';
import { DocsComponent } from './docs/docs.component';
import { NoFileComponent } from './no-file/no-file.component';
import { CsvEditorComponent } from './csv-editor/csv-editor.component';
import { ImageViewerComponent } from './image-viewer/image-viewer.component';
import { ViewDirectoryComponent } from './view-directory/view-directory.component';
import { EditFileComponent } from './edit-file/edit-file.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '', redirectTo: 'projects', pathMatch: 'full'},
  {path: 'projects', component: ProjectsComponent},
  {path: 'createProject', component: CreateProjectComponent},
  {path: 'projectDetails/:id', component: ProjectDetailsComponent},
  {path: 'editFile/:project/:fileName/:fullPath', component: EditFileComponent},
  {path: 'viewImage/:project/:filePath/:fullPath', component: ImageViewerComponent},
  {path: 'directory/:project/:path', component: ViewDirectoryComponent},
  {path: 'csvEditor/:project/:path', component: CsvEditorComponent},
  {path: 'noFile', component: NoFileComponent},
  {path: 'docs', component: DocsComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
