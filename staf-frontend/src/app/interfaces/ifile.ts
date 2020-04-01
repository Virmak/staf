
export interface IFile {
    name: string;
    content: Map<string, IFile> | string;
    type: FileType;
}

export enum FileType {
    File = 'scroll', // icon to display
    Directory = 'folder',
    TestSuite = 'test_suite',
}