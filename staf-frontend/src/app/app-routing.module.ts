import { AuthGuard } from './auth.guard';
import { LoginPageComponent } from './login-page/login-page.component';
import { ProjectsComponent } from './projects/projects.component';
import { DocsComponent } from './docs/docs.component';
import { NoFileComponent } from './no-file/no-file.component';
import { CsvEditorComponent } from './csv-editor/csv-editor.component';
import { ImageViewerComponent } from './image-viewer/image-viewer.component';
import { ViewDirectoryComponent } from './view-directory/view-directory.component';
import { EditFileComponent } from './edit-file/edit-file.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '', redirectTo: 'projects', pathMatch: 'full', canActivate: [AuthGuard]},
  {path: 'login', component: LoginPageComponent},
  {path: 'projects', component: ProjectsComponent, canActivate: [AuthGuard]},
  {path: 'createProject', component: CreateProjectComponent, canActivate: [AuthGuard]},
  {path: 'projectDetails/:id', component: ProjectDetailsComponent, canActivate: [AuthGuard]},
  {path: 'editFile/:project/:fileName/:fullPath', component: EditFileComponent, canActivate: [AuthGuard]},
  {path: 'viewImage/:project/:filePath/:fullPath', component: ImageViewerComponent, canActivate: [AuthGuard]},
  {path: 'directory/:project/:path', component: ViewDirectoryComponent, canActivate: [AuthGuard]},
  {path: 'csvEditor/:project/:path', component: CsvEditorComponent, canActivate: [AuthGuard]},
  {path: 'noFile', component: NoFileComponent, canActivate: [AuthGuard]},
  {path: 'docs', component: DocsComponent, canActivate: [AuthGuard]},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
