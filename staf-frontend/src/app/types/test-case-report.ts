export class TestCaseReport {
    testSuite: string;
    testCase: string;
    result: TestCaseResult;
    startTime: Date;
    endTime: Date;
}

export enum TestCaseResult {
    Failed,
    Passed,
    Pending,
    Warning,
}