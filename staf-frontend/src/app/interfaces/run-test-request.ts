import { IWebDriverOptions } from './web-driver-options';
export class RunTestRequest {
    project: string;
    testSuites: RunTestSuite[];
    webDriverOptions?: IWebDriverOptions;
}

export interface RunTestSuite {
    name: string;
    testCases: RunTestCase[];
}

export interface RunTestCase {
    name: string;
    order: number;
    enabled: boolean;
}