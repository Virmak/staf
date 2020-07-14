import { StafProject } from './types/staf-project';
import { ProjectService } from './project.service';
import { DocsService } from "./docs.service";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class AutoCompleteService {
  builtinKeywords = [];

  constructor(private docsService: DocsService) {
    docsService
      .getBuiltinLibrariesKeywords()
      .subscribe((builtInLibsKeywords: any) => {
        this.builtinKeywords = builtInLibsKeywords;
      });    
  }

  getGlobalVariablesCompletion(project: StafProject) {
    project.compiledFilesSubject.subscribe()
  }

  getBuiltInLibsKeywordsProposals(range) {
    const keywordsProposals = [];
    this.builtinKeywords.forEach(lib => {
      keywordsProposals.push(lib.keywords.map(keyword => {
        const keywordName = this.transformKeywordName(keyword.name);
        return {
          label: keywordName,
          kind: monaco.languages.CompletionItemKind.Function,
          insertText: keywordName + ' (' + this.getParamsString(keyword.parameters) + ')',
          documentation: keyword.description,
          range: range,
        };
      }))
    });
    return [].concat.apply([], keywordsProposals);
  }

  getParamsString(paramsList: any[]) {
    return paramsList.reduce((acc, currentParam, index) => {
        let paramName = '$' + currentParam.name;
        if (currentParam.optional) {
          paramName = '[' + paramName + ']';
        }

        return acc + paramName + (index + 1 < paramsList.length ? ', ' : '');
    }, '');
  }

  transformKeywordName(name) {
    return name.charAt(0).toUpperCase() + name.slice(1);
  }

  getGenericAutoCompleteProposals(range) {
    return [
      {
        label: "teardown:",
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "TEARDOWN:\nEND",
        documentation: "SETUP, execute before running test cases",
        range: range,
      },
      {
        label: "setup:",
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertTextRules:
          monaco.languages.CompletionItemInsertTextRule.InsertAsSnippet,
        insertText: "SETUP:\nEND",
        documentation: "SETUP, execute before running test cases",
        range: range,
      },
      {
        label: '"tag',
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "tag:",
        documentation: "Tag selector",
        range: range,
      },
      {
        label: '"name',
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "name:",
        documentation: "Element name selector",
        range: range,
      },
      {
        label: '"id',
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "id:",
        documentation: "Element id selector",
        range: range,
      },
      {
        label: '"class',
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "class:",
        documentation: "Class name selector",
        range: range,
      },
      {
        label: '"css',
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "css:",
        documentation: "CSS selector",
        range: range,
      },
      {
        label: '"xpath',
        kind: monaco.languages.CompletionItemKind.Snippet,
        insertText: "xpath:",
        documentation: "XPath selector",
        range: range,
      },
      {
        label: "given",
        kind: monaco.languages.CompletionItemKind.Keyword,
        insertText: "GIVEN ",
        range: range,
      },
      {
        label: "when",
        kind: monaco.languages.CompletionItemKind.Keyword,
        insertText: "WHEN ",
        range: range,
      },
      {
        label: "then",
        kind: monaco.languages.CompletionItemKind.Keyword,
        insertText: "THEN ",
        range: range,
      },
      {
        label: "and",
        kind: monaco.languages.CompletionItemKind.Keyword,
        insertText: "AND ",
        range: range,
      },
      {
        label: "import",
        kind: monaco.languages.CompletionItemKind.Keyword,
        insertText: "import ",
        range: range,
      },
      {
        label: "selenium",
        kind: monaco.languages.CompletionItemKind.Constant,
        documentation: "Selenium browser automation library",
        insertText: "selenium",
        range: range,
      },
      {
        label: "ws",
        kind: monaco.languages.CompletionItemKind.Constant,
        documentation: "Web services library",
        insertText: "ws",
        range: range,
      },
      {
        label: "json",
        kind: monaco.languages.CompletionItemKind.Constant,
        documentation: "Json library",
        insertText: "json",
        range: range,
      },
      {
        label: "logger",
        kind: monaco.languages.CompletionItemKind.Constant,
        documentation: "Logging library",
        insertText: "logger",
        range: range,
      },
      {
        label: "std",
        kind: monaco.languages.CompletionItemKind.Constant,
        documentation: "Standard library",
        insertText: "std",
        range: range,
      },
      {
        label: "csv",
        kind: monaco.languages.CompletionItemKind.Constant,
        documentation: "CSV library",
        insertText: "csv",
        range: range,
      },
    ];
  }
}
