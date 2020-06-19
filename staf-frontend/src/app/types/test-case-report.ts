import { StatementReport } from './statement-report';
export class TestCaseReport {
    testSuite: string;
    testCase: string;
    result: TestCaseResult;
    start: Date;
    end: Date;
    errorMessage: string;
    statemmentReports: StatementReport[];
    elapsed?: string;
}

export enum TestCaseResult {
    Failed,
    Passed,
    Pending,
    Warning,
}