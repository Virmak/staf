import { TestCaseReport } from './test-case-report';

export class TestSuiteReport {
    testSuite: string;
    message: string;
    result: TestSuiteResult;
    testCaseReports: TestCaseReport[];
}

export enum TestSuiteResult {
    Ok = "Ok",
    Error = "Error",
}