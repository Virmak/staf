export interface IFileSystemItem {
    name: string;
    content: IFileSystemItem[] | string;
    type: FileSystemItemType;
    path: string;
}

export enum FileSystemItemType {
    File = 'scroll', // icon to display
    Directory = 'folder',
    TestSuite = 'test_suite',
}