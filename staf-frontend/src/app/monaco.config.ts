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
        (<any>window).monaco.languages.registerCompletionItemProvider('staf', {
            provideCompletionItems: (model, position) => {
                // find out if we are completing a property in the 'dependencies' object.
                const textUntilPosition = model.getValueInRange({startLineNumber: 1, startColumn: 1, endLineNumber: position.lineNumber, endColumn: position.column});
                const word = model.getWordUntilPosition(position);
                let fileImports = model.getValue().match(/(?<=import\s+["']).*?(?=["'])/g);
                if (fileImports) {
                    fileImports = fileImports.map(i => i.replace(/\.+\//g, ''));
                }
                
                //console.log(model.getLineTokens());

                const keywordDeclartion = textUntilPosition.match(/(?<=keywords[\s]*|end\s*)(([a-z0-9_ ]+)\(\s*(\$[a-z0-9_]+\s*,?\s*)*\s*\)[\S\s]*?)/gim);
                if (keywordDeclartion) {
                    const keywordSignature = keywordDeclartion[keywordDeclartion.length - 1].trim();
                    console.log(keywordSignature);

                }

                const range = {
                    startLineNumber: position.lineNumber,
                    endLineNumber: position.lineNumber,
                    startColumn: word.startColumn,
                    endColumn: word.endColumn
                };

                const isFileImported = filePath => {
                    if (fileImports == null) {
                        return false;
                    }
                    for (let i = 0; i < fileImports.length; i++) {
                        if (filePath.indexOf(fileImports[i]) != -1) {
                            return true;
                        } 
                    }
                    return false;
                }
                let userDefined = [];
                for (const filePath in (<any>window).userKeywords) {
                   if (isFileImported(filePath)) {
                    userDefined = userDefined.concat((<any>window).userKeywords[filePath].map((k:any) => {
                        return {
                            label: k.keywordName,
                            kind: monaco.languages.CompletionItemKind.Function,
                            documentation:  k.keywordName + " | User defined",
                            insertText: k.keywordSignature,
                            range,
                        };
                    }));
                   }
                }
                return {
                    suggestions: [ ...createImportsDependencyProposals(range), ...userDefined]
                };              
            }
        });
        
        
       
    }
}

