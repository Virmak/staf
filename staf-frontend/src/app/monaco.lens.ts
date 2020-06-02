

export function getLenses() {
    return [
        {
            range: {
                startLineNumber: 1,
                startColumn: 1,
                endLineNumber: 2,
                endColumn: 1
            },
            id: "First Line",
            command: {
                id: 0,
                title: "First Line"
            }
        }
    ]
}
export function registerLenses() {
    //alert('registering lenses');
    (<any>window).monaco.languages.registerCodeLensProvider('json', {
        provideCodeLenses: function (model, token) {
            return {
                lenses: getLenses()
            };
        },
        resolveCodeLens: function (model, codeLens, token) {
            return codeLens;
        }
    });
}
