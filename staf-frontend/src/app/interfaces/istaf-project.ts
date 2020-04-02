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
    reports?: any[];
}

export enum ProjectType {
    UITest = 'UITest',
    APITest = 'APITest',
    Custom = 'Custom',
}