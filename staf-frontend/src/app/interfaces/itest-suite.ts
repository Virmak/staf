import { IDirectory } from './idirectory';
export interface ITestSuite {
    id: number;
    name: string;
    content: IDirectory;
}