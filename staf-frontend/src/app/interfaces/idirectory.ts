import { IFile } from './ifile';

export interface IDirectory extends IFile {
    content: Map<string, IFile|IDirectory>;
}