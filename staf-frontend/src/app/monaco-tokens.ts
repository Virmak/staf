export const monarchTokens = {
	// Set defaultToken to invalid to see what you do not tokenize yet
	defaultToken: 'invalid',
  
	  ignoreCase: true,
	keywords: [
	  'test suite',
		  'test cases',
		  'vars',
		  'imports',
		  'import',
		  'keywords',
		  'test cases',
		  'setup:',
		  'teardown:',
		  'end',
		  'endfor',
	  'return',
		  'for',
	  'ignore',
  
	  'given',
	  'then',
	  'when',
	  'and',
	],
  
	typeKeywords: [
	],
  
	operators: [
	  '=', '>', '<', '!', '~', '?', ':', '==', '<=', '>=', '!=',
	  '&&', '||', '++', '--', '+', '-', '*', '/', '&', '|', '^', '%',
	  '<<', '>>', '>>>', '+=', '-=', '*=', '/=', '&=', '|=', '^=',
	  '%=', '<<=', '>>=', '>>>='
	],
  
	// we include these common regular expressions
	symbols:  /[=><!~?:&|+\-*\/\^%]+/,
  
	// C# style strings
	escapes: /\\(?:[abfnrtv\\"']|x[0-9A-Fa-f]{1,4}|u[0-9A-Fa-f]{4}|U[0-9A-Fa-f]{8})/,
  
	// The main tokenizer for our languages
	tokenizer: {
	  root: [
  
		[/^\s*(given|then|when|and)/,'keyword'],
		[/(test suite|test cases|keywords|imports|endfor|end|return|vars|for(?=\(.*:.*\))|setup:|teardown:|ignore(?=\s*\-))/, { cases: { '@typeKeywords': 'keyword',
									 '@keywords': 'keyword' } }],
		[/import(?!.*(\(|:))/, 'keyword'],
  
		[/\$[a-z0-9_]*/, 'type'],
		[/[a-z0-9_ ]*:$/, 'keyword'],
  
		[/[a-z_$][\w$]*/, {cases: {'@default': 'identifier'}}],
		// identifiers and keywords
		//[/^imports|/, 'type.identifier' keyword],  // to show class names nicely
  
		// whitespace
		{ include: '@whitespace' },
  
		// delimiters and operators
		[/[{}()\[\]]/, '@brackets'],
		[/[<>](?!@symbols)/, '@brackets'],
		[/@symbols/, { cases: { '@operators': 'operator',
								'@default'  : '' } } ],
  
		// @ annotations.
		// As an example, we emit a debugging log message on these tokens.
		// Note: message are supressed during the first load -- change some lines to see them.
		[/@\s*[a-zA-Z_\$][\w\$]*/, { token: 'annotation', log: 'annotation token: $0' }],
  
		// numbers
		[/\d*\.\d+([eE][\-+]?\d+)?/, 'number.float'],
		[/0[xX][0-9a-fA-F]+/, 'number.hex'],
		[/\d+/, 'number'],
  
		// delimiter: after number because of .\d floats
		[/[;,.]/, 'delimiter'],
  
		// strings
		[/"([^"\\]|\\.)*$/, 'string.invalid' ],  // non-teminated string
		[/"/,  { token: 'string.quote', bracket: '@open', next: '@string' } ],
  
		[/'([^'\\]|\\.)*$/, 'string.invalid' ],  // non-teminated string
		[/'/,  { token: 'string.quote', bracket: '@open', next: '@string_single' } ],
  
	  ],
	  keywordDeclare: [
		[/.*\(/, 'keyword', '@popall']
	  ],
	  testCaseDeclare: [
		[/.*:/, 'keyword', '@popall']
	  ],
	  comment: [
		[/[^\n]*/, 'comment', '@pop' ],
	  ],
  
	  string: [
		[/[^\\"]+/,  'string'],
		[/@escapes/, 'string.escape'],
		[/\\./,      'string.escape.invalid'],
		[/"/,        { token: 'string.quote', bracket: '@close', next: '@pop' } ]
	  ],
  
  
  
		  string_single: [
			  [/[^\\']+/, 'string'],
			  [/@escapes/, 'string.escape'],
			  [/\\./, 'string.escape.invalid'],
			  [/'/, 'string', '@pop']
		  ],
  
  
	  whitespace: [
		[/[ \t\r\n]+/, 'white'],
		[/#(?=.*)/,       'comment', '@comment' ],
		[/\/\/.*$/,    'comment'],
	  ],
	},
  };
  