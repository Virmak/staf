
export function createImportsDependencyProposals(range) {
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
            insertText: 'Open browser("chrome")',
            range: range
        },
        {
            label: 'Trim',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Remove white space from the start and end of a string | Standard library",
            insertText: 'Trim($str)',
            range: range
        },
        {
            label: 'Get element attribute',
            kind: monaco.languages.CompletionItemKind.Function,
            documentation: "Get element attribute value | Selenium library",
            insertText: 'Get element attribute($selector, "attribute")',
            range: range
        },

    ];
}
