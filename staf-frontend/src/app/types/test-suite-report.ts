import { TestCaseReport } from './test-case-report';

export class TestSuiteReport {
    testSuite: string;
    message: string;
    result: TestSuiteResult;
    testCaseReports: TestCaseReport[];
    start: string;
    end: string;
}

export enum TestSuiteResult {
    Ok = "Ok",
    Error = "Error",
}