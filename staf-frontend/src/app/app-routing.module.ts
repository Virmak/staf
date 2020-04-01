import { ViewDirectoryComponent } from './view-directory/view-directory.component';
import { EditFileComponent } from './edit-file/edit-file.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'createProject', component: CreateProjectComponent},
  {path: 'projectDetails/:id', component: ProjectDetailsComponent},
  {path: 'editFile/:project/:filePath/:fullPath', component: EditFileComponent},
  {path: 'directory/:project/:path', component: ViewDirectoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
