
export interface IFile {
    name: string;
    content: Map<string, IFile> | string;
    type: FileType;
    extension?: string;
    path?: string;
}

export enum FileType {
    File = 'scroll', // icon to display
    Directory = 'folder',
    TestSuite = 'test_suite',
}