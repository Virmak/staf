import { ToastrService } from "ngx-toastr";
import { ProjectService } from "src/app/project.service";
import { ActivatedRoute } from "@angular/router";
import { StafProject } from "./../types/staf-project";
import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-project-config",
  templateUrl: "./project-config.component.html",
  styleUrls: ["./project-config.component.css"],
})
export class ProjectConfigComponent implements OnInit {
  @Input() project: StafProject;
  projectName: string;
  description: string;
  logDirectory: string;
  reportDirectory: string;
  location: string;

  projectConfigWarningModal = false;

  constructor(
    private route: ActivatedRoute,
    private projectService: ProjectService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((paramMap) => {
      setTimeout(() => {
        // wait for parent element to update project
        this.resetFields();
      }, 0);
    });
  }

  saveConfig(ignoreLocationCheck) {
    let reloadProject = false;
    if (!ignoreLocationCheck) {
      if (this.location !== this.project.location) {
        this.projectConfigWarningModal = true;
        return;
      }
    } else {
      reloadProject = true;
    }
    if (
      this.projectName === "" ||
      this.logDirectory === "" ||
      this.reportDirectory === "" ||
      this.location === ""
    ) {
      this.toastr.error("Some required fields are empty");
      return;
    }
    this.projectService.updateProjectConfig(
      this.project,
      this.projectName,
      this.description,
      this.logDirectory,
      this.reportDirectory,
      this.location,
      this.project.location,
      reloadProject
    );
    this.projectConfigWarningModal = false;
  }
  resetFields() {
    this.projectName = this.project.name;
    this.description = this.project.description;
    this.logDirectory = this.project.logDir;
    this.reportDirectory = this.project.reportsDir;
    this.location = this.project.location;
  }

  normalizeProjectLocation() {
    this.location = StafProject.getNormalizedProjectName(this.location);
  }
}
