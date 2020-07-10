import { ToastrService } from 'ngx-toastr';
import { IStafProject } from './../../interfaces/istaf-project';
import { Component, OnInit, Input } from '@angular/core';
import { ProjectService } from 'src/app/project.service';
import { IGetReportsResponse } from 'src/app/interfaces/iget-reports-response';

@Component({
  selector: 'app-view-log',
  templateUrl: './view-log.component.html',
  styleUrls: ['./view-log.component.css']
})
export class ViewLogComponent implements OnInit {
  private currentProject: IStafProject;

  @Input() set project(project: IStafProject) {
    this.currentProject = project;
  }

  get project() {
    return this.currentProject;
  }
  
  @Input() reports = [];

  reportsFileList = [];
  selectedTestReportPath = '';
  selectedDate = '';

  private allReportsFileNameList

  constructor(
    private projectService: ProjectService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.projectService.getReports(this.project.name)
    .subscribe((fileList: IGetReportsResponse) => {
      this.reportsFileList = fileList.reportsFileNameList;
      this.allReportsFileNameList = this.reportsFileList;
    });
  }

  loadTestReport() {
    this.projectService.getTestReport(this.selectedTestReportPath)
    .subscribe((res: any) => {
      this.reports = res;
    }, err => {
      this.toastr.error('Report file corrupted', 'Error');
      this.reports = [];
    });
  }

  filterReportsList() {
    console.log(this.selectedDate);
    this.reportsFileList = this.allReportsFileNameList.filter(r => {

    });
  }

}
