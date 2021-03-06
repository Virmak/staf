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
    relativePath?: string;
}

export enum FileType {
    File = 'FILE', // icon to display
    Directory = 'DIRECTORY',
}