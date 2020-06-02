import { IFile } from './ifile';
export interface ICreateTestSuite {
    name: string;
    content: IFile[];
    type: string;
    projectName: string;
}