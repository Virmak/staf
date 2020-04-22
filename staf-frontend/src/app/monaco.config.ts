import { NgxMonacoEditorConfig } from 'ngx-monaco-editor';
    import { from } from 'rxjs';

export const monacoConfig: NgxMonacoEditorConfig = {
    baseUrl: './assets',
    onMonacoLoad: () => {
        (<any>window).monaco.languages.register({ id: 'staf' });
        (<any>window).monaco.languages.setMonarchTokensProvider('staf', monarchTokens);
        (<any>window).monaco.languages.registerCompletionItemProvider('staf', {
            provideCompletionItems: (model, position) => {
                // find out if we are completing a property in the 'dependencies' object.
                const textUntilPosition = model.getValueInRange({startLineNumber: 1, startColumn: 1, endLineNumber: position.lineNumber, endColumn: position.column});
                const word = model.getWordUntilPosition(position);
                /*console.log(word);
                console.log(model.getLineTokens());*/

                if (word.word == '$') {
                    const keywordDeclartion = textUntilPosition.match(/(?<=keywords[\s]*|end\s*)(([a-z0-9_ ]+)\(\s*(\$[a-z0-9_]+\s*,?\s*)*\s*\)[\S\s]*?)/gim);
                    if (keywordDeclartion) {
                        const keywordSignature = keywordDeclartion[keywordDeclartion.length - 1].trim();
                        //console.log(keywordSignature);

                    }
                }

                const range = {
                    startLineNumber: position.lineNumber,
                    endLineNumber: position.lineNumber,
                    startColumn: word.startColumn,
                    endColumn: word.endColumn
                };
                return {
                    suggestions: createImportsDependencyProposals(range)
                };              
            }
        });
        /*
        monaco.languages.registerHoverProvider('staf', {
            provideHover: function (model, position) {
                const tokens = (<any>window).monaco.editor.tokenize(model.getValue(), 'staf');
                console.log(tokens)
                return {
                    range: new monaco.Range(1, 1, model.getLineCount(), model.getLineMaxColumn(model.getLineCount())),
                    contents: [
                        { value: '**SOURCE**' },
                        { value: '```html\nhhhhhOKOKO\n```' }
                    ]
                }
            }
        });
        */
    }
}

function createImportsDependencyProposals(range) {
    // returning a static list of proposals, not even looking at the prefix (filtering is done by the Monaco editor),
    // here you could do a server side lookup
    return [

        {
            label: 'teardown:',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'TEARDOWN:\nEND',
            documentation: "SETUP, execute before running test cases",
            range: range
        },
        {
            label: 'setup:',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertTextRules: monaco.languages.CompletionItemInsertTextRule.InsertAsSnippet,
            insertText: 'SETUP:\nEND',
            documentation: "SETUP, execute before running test cases",
            range: range
        },
        {
            label: '"tag',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'tag:',
            documentation: "Tag selector",
            range: range
        },
        {
            label: '"name',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'name:',
            documentation: "Element name selector",
            range: range
        },
        {
            label: '"id',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'id:',
            documentation: "Element id selector",
            range: range
        },
        {
            label: '"class',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'class:',
            documentation: "Class name selector",
            range: range
        },
        {
            label: '"css',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'css:',
            documentation: "CSS selector",
            range: range
        },
        {
            label: '"xpath',
            kind: monaco.languages.CompletionItemKind.Snippet,
            insertText: 'xpath:',
            documentation: "XPath selector",
            range: range
        },
        {
            label: 'given',
            kind: monaco.languages.CompletionItemKind.Keyword,
            insertText: 'GIVEN ',
            range: range
        },
        {
            label: 'when',
            kind: monaco.languages.CompletionItemKind.Keyword,
            insertText: 'WHEN ',
            range: range
        },
        {
            label: 'then',
            kind: monaco.languages.CompletionItemKind.Keyword,
            insertText: 'THEN ',
            range: range
        },
        {
            label: 'and',
            kind: monaco.languages.CompletionItemKind.Keyword,
            insertText: 'AND ',
            range: range
        },
        {
            label: 'import',
            kind: monaco.languages.CompletionItemKind.Keyword,
            insertText: 'import ',
            range: range
        },
        {
            label: 'selenium',
            kind: monaco.languages.CompletionItemKind.Constant,
            documentation: "Selenium browser automation library",
            insertText: 'selenium',
            range: range
        },
        {
            label: 'ws',
            kind: monaco.languages.CompletionItemKind.Constant,
            documentation: "Web services library",
            insertText: 'ws',
            range: range
        },
        {
            label: 'json',
            kind: monaco.languages.CompletionItemKind.Constant,
            documentation: "Json library",
            insertText: 'json',
            range: range
        },
        {
            label: 'logger',
            kind: monaco.languages.CompletionItemKind.Constant,
            documentation: "Logging library",
            insertText: 'logger',
            range: range
        },
        {
            label: 'std',
            kind: monaco.languages.CompletionItemKind.Constant,
            documentation: "Standard library",
            insertText: 'std',
            //insertTextRules: monaco.languages.CompletionItemInsertTextRule.InsertAsSnippet,
            range: range
        },
        {
            label: 'Wait until element is visible',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Wait until element is visible ($selector [, $timeout]) | Selenium library",
            insertText: 'Wait until element is visible ($selector)',
            range: range
        },
        {
            label: 'Wait until element is enabled',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Wait until element is enabled ($selector [, $timeout]) | Selenium library",
            insertText: 'Wait until element is enabled ($selector)',
            range: range
        },
        {
            label: 'Element should be visible',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Element with $selector should be visible or fail | Selenium library",
            insertText: 'Element should be visible($selector)',
            range: range
        },
        {
            label: 'Element should contain',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Element with $selector should contain $expected or fail with [$message] if provided or default error message | Selenium library",
            insertText: 'Element should contain($selector, $expected)',
            range: range
        },
        {
            label: 'Capture screenshot',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Take screenshot of the current page | Selenium library",
            insertText: 'Capture screenshot($filename)',
            range: range
        },
        {
            label: 'Input value',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Returns input value | Selenium library",
            insertText: 'Input value($selector)',
            range: range
        },
        {
            label: 'Click element',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Click element | Selenium library",
            insertText: 'Click element($selector)',
            range: range
        },
        {
            label: 'Input text',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Types the given text into text field identified by locator | Selenium library",
            insertText: 'Input text($selector)',
            range: range
        },
        {
            label: 'Maximize browser window',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Maximize current browser window | Selenium library",
            insertText: 'Maximize browser window()',
            range: range
        },
        {
            label: 'Close browser',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Close browser | Selenium library",
            insertText: 'Close browser()',
            range: range
        },
        {
            label: 'Close browsers',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Close all browsers instances | Selenium library",
            insertText: 'Close browsers()',
            range: range
        },
        {
            label: 'Open browser',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Open browser | Selenium library",
            insertText: 'Open browser()',
            range: range
        },
    ];
}

const monarchTokens = {
	defaultToken: 'invalid',
	tokenPostfix: '.staf',
	ignoreCase: true,
	keywords: [
		'test suite',
		'test cases',
		'vars',
		'imports',
		'keywords',
		'test cases',
		'setup:',
		'teardown:',
		'end',
		'for',
	],

	brackets: [
		{ open: '{', close: '}', token: 'delimiter.curly' },
		{ open: '[', close: ']', token: 'delimiter.bracket' },
		{ open: '(', close: ')', token: 'delimiter.parenthesis' }
	],

	tokenizer: {
		root: [
			{ include: '@whitespace' },
			{ include: '@numbers' },
			{ include: '@strings' },
			{ include: '@variable' },
			[/[,:;]/, 'delimiter'],
			[/[{}\[\]()]/, '@brackets'],

			[/(test suite|test cases|keywords|imports|vars|end|for|setup:|teardown:|given)/, {
				cases: {
					'@keywords': {
						cases: {
							'test suite': { token: 'keyword', next: '@testSuite' },
							'vars*': { token: 'keyword', next: '@varsSection' },
							'imports*': { token: 'keyword', next: '@importsSection' },
							'keywords*': { token: 'keyword', next: '@keywordsSection' },
							'test cases': { token: 'keyword', next: '@testCasesSection' },
						}
					},
					'@default': 'identifier'
				}
			}]
		],
		testSuite: [
			{
				include: '@strings' 
			},
			[/imports/, 'keyword', '@pop']
		],
		varsSection: [
      {include: '@assignment'},
			[/(?=keywords|test cases)/, 'keyword', '@popall'],
		],
		statement: [
			{
				include: '@keywordCall'
			},
			{
				include: '@assignment',
			}
		],
		assignment:[
			{
				include: '@variable',
			},
			[/=/, ''],
			{
				include: '@object',
			},
			{
				include: '@keywordCall',
			},
		],
    testCasesSection: [
      {include: '@testCaseDeclaration'},
			[/(?=test cases)/, '', '@popall']
    ],
    testCaseDeclaration: [
      [/[a-z_][a-z0-9_ ]+:/, 'type'],
      {include: '@statement',},
      [/end/, 'type', ] 
    ],
		importsSection:[
			{ include: '@importStat'},
			[/(keywords|vars)/, 'keyword', '@popall']
		],
		importStat: [
			[/(?=import)/, 'keyword', '@imp'],
			[/(?=vars)/, '', '@popall']
		],
		imp: [
			[/(import)(\s+)("[^"]*")/, ['keyword', '', 'string']],
			[/(import)(\s+)('[^']*')/, ['keyword', '', 'string']],
			[/(import)(\s+)([a-z_][a-z0-9_]*)/, ['keyword', '', '']] ,
			[/(?=keywords)/, 'keyword', '@popall'],
			[/(?=vars)/, '', '@popall']
		],
		keywordCall: [
			[/([a-z_][a-z0-9_ ]+)(\()/, ['keyword.call', '']],
			{include: '@parameters'},
		],
		keywordsSection: [
			[/keywords/, 'keyword'],
			{include: '@keywordDeclaration'},
			[/(?=test cases)/, '', '@popall']
		],
		keywordDeclaration: [ 
			{include: '@keywordSignature', next: '@push'},
			{include: '@keywordBody', next: '@push'},
			[/end/, 'regexp']
		],
    keywordBody: [
			{include: '@statement', next: '@push'},
			[/end/, {
        cases: {
          '@keywords': {token: 'regexp', next: '@keywordDeclaration'} 
        }
      }],
			[/(?=test cases)/, '', '@popall']
    ],
		keywordSignature: [
			[/[a-z_][a-z0-9_ ]+(?=\()/, {token:'regexp', next: '@declParameters'}],
			[/\)/, 'regexp'],
		],
		declParameters:[ 
			[/\(/, 'predefined'],
			{
				include: '@variable'
			},
			[/,/, 'keyword'],
			[/\)/, 'predefined', '@keywordBody'],
		],
		parameters:[ 
			[/\(/, {token:'predefined', next:'@push'}], 
			{
				include: '@param'
			},
			[/\)/,  {token:'predefined',}],
		],
		param: [
			{
				include: '@object'
			},
			[/,/, 'nothing'],
		],
		variable: [
			[/\$[a-z0-9_]+/, 'variable'],
		],
		object: [
			{
				include: '@variable'
			},
			{
				include: '@numbers',
			},
			[/"[^"]*"/, 'string'],
			[/'[^']*'/, 'string'],
		],
		// Deal with white space, including single and multi-line comments
		whitespace: [
			[/\s+/, 'white'],
			[/(^#.*$)/, 'comment'],
			[/('''.*''')|(""".*""")/, 'string'],
			[/'''.*$/, 'string', '@endDocString'],
			[/""".*$/, 'string', '@endDblDocString']
		],
		endDocString: [
			[/\\'/, 'string'],
			[/.*'''/, 'string', '@popall'],
			[/.*$/, 'string']
		],
		endDblDocString: [
			[/\\"/, 'string'],
			[/.*"""/, 'string', '@popall'],
			[/.*$/, 'string']
		],

		// Recognize hex, negatives, decimals, imaginaries, longs, and scientific notation
		numbers: [
			[/-?0x([abcdef]|[ABCDEF]|\d)+[lL]?/, 'number.hex'],
			[/-?(\d*\.)?\d+([eE][+\-]?\d+)?[jJ]?[lL]?/, 'number']
		],

		// Recognize strings, including those broken across lines with \ (but not without)
		strings: [
			[/'$/, 'string.escape', '@popall'],
			[/'/, 'string.escape', '@stringBody'],
			[/"$/, 'string.escape', '@popall'],
			[/"/, 'string.escape', '@dblStringBody']
		],
		stringBody: [
			[/[^\\']+$/, 'string', '@popall'],
			[/[^\\']+/, 'string'],
			[/\\./, 'string'],
			[/'/, 'string.escape', '@popall'],
			[/\\$/, 'string']
		],
		dblStringBody: [
			[/[^\\"]+$/, 'string', '@popall'],
			[/[^\\"]+/, 'string'],
			[/\\./, 'string'],
			[/"/, 'string.escape', '@popall'],
			[/\\$/, 'string']
		]
	}
};
