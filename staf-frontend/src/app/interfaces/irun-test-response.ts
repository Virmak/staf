import { TestSuiteReport } from '../types/test-suite-report';
export interface IRunTestResponse {
    reportFileName: string;
    testSuiteReports: TestSuiteReport[]
}