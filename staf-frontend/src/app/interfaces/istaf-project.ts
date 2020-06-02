import { TestSuiteReport } from './../types/test-suite-report';
import { ITestSuite } from './itest-suite';
export interface IStafProject {
    id: number;
    name: string;
    description: string;
    location: string;
    logDir: string;
    reportsDir: string;
    testSuites: ITestSuite[];
    type: ProjectType;
    reports?: TestSuiteReport[];
}

export enum ProjectType {
    UITest = 'UITest',
    APITest = 'APITest',
    Custom = 'Custom',
}