import { TestSuiteReport } from './../types/test-suite-report';
import { ITestSuite } from './itest-suite';
export interface IStafProject extends IProjectConfig {
    testSuites: ITestSuite[];
    type: ProjectType;
    reports?: TestSuiteReport[];
}

export interface IProjectConfig {
    id: number;
    name: string;
    description: string;
    location: string;
    logDir: string;
    reportsDirPath: string;
}

export enum ProjectType {
    UITest = 'UITest',
    APITest = 'APITest',
    Custom = 'Custom',
}