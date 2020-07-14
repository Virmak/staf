import { IDirectory } from './idirectory';
import { ITestCase } from './itest-case';
export interface ITestSuite {
    id: number;
    name: string;
    content: IDirectory;
    active?: boolean;
    testCases?: ITestCase[];
    syntaxErrors?: any[];
}