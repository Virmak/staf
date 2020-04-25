export const monarchTokens = {
	//defaultToken: 'invalid',
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
    'return',
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
			[/end|return/, 'regexp']
		],
    keywordBody: [
			{include: '@statement', next: '@push'},
			[/end|return/, {
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
