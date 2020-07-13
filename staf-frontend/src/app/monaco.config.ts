import { NgxMonacoEditorConfig } from 'ngx-monaco-editor';
import { createImportsDependencyProposals } from './auto-completion';
import { monarchTokens } from './monaco-tokens';
import { registerLenses } from './monaco.lens';

export const monacoConfig: NgxMonacoEditorConfig = {
    baseUrl: './assets',
    onMonacoLoad: () => {
        registerLenses();
        (<any>window).monaco.languages.register({ id: 'staf' });
        (<any>window).monaco.languages.setMonarchTokensProvider('staf', monarchTokens);
        
        
        
       
    }
}

