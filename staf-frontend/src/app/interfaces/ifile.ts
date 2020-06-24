import { StafProject } from './../types/staf-project';

export interface IFile {
    name: string;
    content: Map<string, IFile> | string;
    type: FileType;
    extension?: string;
    path?: string;
    active?: boolean;
    project?: StafProject;
    changed?: boolean;
    originalContent?: string;
}

export enum FileType {
    File = 'scroll', // icon to display
    Directory = 'folder',
    TestSuite = 'test_suite',
}