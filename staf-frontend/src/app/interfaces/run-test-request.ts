export class RunTestRequest {
    project: string;
    testSuites: string[];
    webDriverAddress?: string;
    sessionCount: number;
}