import { IWebDriverOptions } from './web-driver-options';
export class RunTestRequest {
    project: string;
    testSuites: string[];
    webDriverOptions?: IWebDriverOptions;
}