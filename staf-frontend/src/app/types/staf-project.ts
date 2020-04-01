import { IStafProject, ProjectType } from '../interfaces/istaf-project';
import { ITestSuite } from '../interfaces/itest-suite';

export class StafProject implements IStafProject {
    id: number;
    name: string;
    description: string;
    location: string;
    logDir: string;
    reportsDir: string;
    testSuites: ITestSuite[];
    type: ProjectType;

    getNormalizedProjectName() {
        return StafProject.getNormalizedProjectName(this.name);
    }
    
    static getNormalizedProjectName(name) {
        return name.replace(/[ \t]/g, '-').toLowerCase();
    }

    static fromObject(project: IStafProject) {
        const p = new StafProject();
        p.id = project.id;
        p.name = project.name;
        p.description = project.description;
        p.location = project.location;
        p.logDir = project.logDir;
        p.reportsDir = project.reportsDir;
        p.testSuites = project.testSuites;
        p.type = project.type;
        return p;
    }
}