import { IStafProject, ProjectType } from '../interfaces/istaf-project';
import { ITestSuite } from '../interfaces/itest-suite';

export class StafProject implements IStafProject {
    id: number;
    name: string;
    description: string;
    location: string;
    logDir: string;
    reportsDir: string;
    testSuites: ITestSuite[] = [];
    type: ProjectType;
    expanded: boolean;

    getNormalizedProjectName() {
        return StafProject.getNormalizedProjectName(this.name);
    }
    
    static getNormalizedProjectName(name) {
        return name.replace(/[ \t]/g, '-').toLowerCase();
    }

    static fromObject(project: IStafProject) {
        const newStafProject = new StafProject();
        newStafProject.id = project.id;
        newStafProject.name = project.name;
        newStafProject.description = project.description;
        newStafProject.location = project.location;
        newStafProject.logDir = project.logDir;
        newStafProject.reportsDir = project.reportsDir;
        newStafProject.testSuites = project.testSuites;
        newStafProject.type = project.type;
        return newStafProject;
    }
}