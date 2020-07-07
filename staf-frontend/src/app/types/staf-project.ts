import { CompiledTestSuite } from './compiled-test-suite';
import { IDirectory } from './../interfaces/idirectory';
import { IStafProject, ProjectType } from '../interfaces/istaf-project';
import { ITestSuite } from '../interfaces/itest-suite';
import { TestSuiteReport } from './test-suite-report';
import { FileType } from '../interfaces/ifile';
import { Subject, BehaviorSubject } from 'rxjs';

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
    reports?: TestSuiteReport[];

    private _compiledFiles;
    compiledFilesSubject?: BehaviorSubject<CompiledTestSuite[]> = new BehaviorSubject([]);
    
    set compiledFiles(value) {
        this._compiledFiles = value;
        this.compiledFilesSubject.next(value);
    }

    get compiledFiles() {
        return this._compiledFiles;
    }

    
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

    getFile(filePath) {
        const splittedPath = filePath.split('/');
        const projectIndex = splittedPath.indexOf(this.location);
        const testSuite = this.testSuites.find(ts => ts.name === splittedPath[projectIndex + 1]);
        return this.searchFileInDirectory(testSuite.content, filePath);
    }

    private searchFileInDirectory(directory: IDirectory, path: string) {
        if (directory.content.has(path)) {
            return directory.content.get(path);
        }
        for (const item of directory.content.values()) {
            if (item.type === FileType.Directory) {
                const file = this.searchFileInDirectory(item as IDirectory, path);
                if (file != null) {
                    return file;
                }
            }
        }
        return null;
    }
}