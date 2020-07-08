import { Subscription } from 'rxjs';
import { TestSuiteService } from "./../test-suite.service";
import { ITestSuite } from "./../interfaces/itest-suite";
import { StafProject } from "./../types/staf-project";
import { FileType, IFile } from "./../interfaces/ifile";
import { FileEditorService } from "./../file-editor.service";
import { ProjectService } from "./../project.service";
import { Component, OnInit, OnDestroy, NgZone } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { CompiledTestSuite } from '../types/compiled-test-suite';

@Component({
  selector: "app-edit-file",
  templateUrl: "./edit-file.component.html",
  styleUrls: ["./edit-file.component.css"],
})
export class EditFileComponent implements OnInit, OnDestroy {
  private compiledFilesSubscription: Subscription;

  filePath;
  project: StafProject;
  file: IFile;

  vsThemes = [
    { value: "vs", name: "Light theme" },
    { value: "vs-dark", name: "Dark theme" },
    { value: "hc-black", name: "High contrast" },
  ];
  selectedTheme = this.vsThemes[1];
  editorOptions = { theme: this.selectedTheme.value, language: "staf" };

  pathSplitted = [];

  allTestSuite = { id: 999, name: "All", content: null };
  testSuites: ITestSuite[];
  selectedTestSuite: ITestSuite = this.allTestSuite;
  editorInstance;

  hoverProvider: monaco.IDisposable;

  private keyEventListener = (e) => {
    if (this.file.content != this.file.originalContent) {
      this.file.changed = true;
    } else {
      this.file.changed = false;
    }

    if (!(e.which == 83 && e.ctrlKey)) return true;
    if (e.which == 83) {
      this.saveFile();
    }
    event.preventDefault();
    return false;
  };

  private navigationListener = (e: CustomEvent) => {
    this.router.navigate(e.detail);
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private projectService: ProjectService,
    public fileEditorService: FileEditorService,
    private zone: NgZone
  ) {}

  ngOnInit(): void {
    document.addEventListener("keydown", this.keyEventListener);
    this.route.paramMap.subscribe(() => {
      if (this.hoverProvider) {
        this.hoverProvider.dispose();
        this.registerHoverProvider();
      }
      const projectName = this.route.snapshot.paramMap.get("project");
      this.filePath = this.route.snapshot.paramMap.get("fullPath");
      this.project = this.projectService.getProjectByName(projectName);
      if (this.project == null) {
        this.router.navigate(["/"]);
        return;
      }
      this.testSuites = [this.allTestSuite, ...this.project.testSuites];
      this.openFile();
      if (this.compiledFilesSubscription) {
        this.compiledFilesSubscription.unsubscribe(); 
        this.compiledFilesSubscription = this.project.compiledFilesSubject.subscribe((cf) => setTimeout(() => this.handleTestSuiteErrors(cf), 0));
      }
    });
  }

  ngOnDestroy(): void {
    document.removeEventListener("keydown", this.keyEventListener);
  }

  openFile() {
    let file: any = this.fileEditorService.getFile(this.filePath);
    if (file == null) {
      file = this.project.getFile(this.filePath);
      this.fileEditorService.openFile(file, this.project);
    }
    this.file = file;
    this.file.originalContent = this.file.content as string;
    this.pathSplitted = file.path.split("/");
    let i;
    for (i = 0; i < this.pathSplitted.length - 1; i++) {
      this.pathSplitted[i] = {
        name: this.pathSplitted[i],
        type: FileType.Directory,
      };
    }
    this.pathSplitted[i] = {
      name: this.pathSplitted[i],
      type: FileType.File,
    };
  }

  saveFile() {
    this.fileEditorService.saveFile(this.file, () => {
      this.projectService.compileProject(this.project.location).subscribe((compiledTestSuites: CompiledTestSuite[]) => {
        this.project.compiledFiles = compiledTestSuites;
      });
    });
  }

  onInitEditor(editor) {
    this.editorInstance = editor;

    this.compiledFilesSubscription = this.project.compiledFilesSubject.subscribe((cf) => this.handleTestSuiteErrors(cf));

    editor.addAction({
      id: "go-to-keyword",
      label: "Go to keyword definition",
      keybindings: [monaco.KeyMod.CtrlCmd | monaco.KeyCode.F10],
      precondition: null,
      keybindingContext: null,
      contextMenuGroupId: "navigation",
      contextMenuOrder: 1.5,
      run: (ed) => {
        const line = ed.getModel().getLineContent(ed.getPosition().lineNumber);
        const keywordName = this.extractKeywordName(line, ed.getPosition().column.valueOf());
        if (keywordName) {
          const delcarationFilePath = this.getKeywordDelarationFile(
            keywordName
          );
          this.zone.run(() => {
            this.openFileByFullPath(delcarationFilePath);
          });
        }
        return null;
      },
    });
    if (!this.hoverProvider) {
      this.registerHoverProvider();
    }
  }

  registerHoverProvider() {
    if (!window.monaco) {
      return;
    }
    this.hoverProvider = window.monaco.languages.registerHoverProvider("staf", {
      provideHover: (model, position) => {
        const line = model.getLineContent(position.lineNumber);

        const keywordName = this.extractKeywordName(line, position.column.valueOf());

        if (keywordName) {
          const delcarationFilePath = this.getKeywordDelarationFile(
            keywordName
          );
          if (delcarationFilePath) {
            const fileUrl = this.extractFileRoute(delcarationFilePath);
            return {
              range: new monaco.Range(
                position.lineNumber,
                line.indexOf(keywordName),
                position.lineNumber,
                model.getLineMaxColumn(position.lineNumber)
              ),
              contents: [
                { value: "**Keyword definition : "+ keywordName + "**" },
                { value: "File : **" + fileUrl + "**" },
              ],
            };
          }
        }
      },
    });
  }

  getKeywordDelarationFile(keywordName) {
    keywordName = keywordName.toLowerCase();
    if (this.project.compiledFiles) {
      for (const filePath in this.project.compiledFiles.fileMap) {
        const file = this.project.compiledFiles.fileMap[filePath];
        if (file.keywordDeclarationMap) {
          if (Object.keys(file.keywordDeclarationMap).map(key => key.toLowerCase()).includes(keywordName)) {
            return file.filePath;
          }
        }
      }
    }
    return "";
  }

  private extractFileRoute(fullFilePath: string) {
    const splittedPath = fullFilePath.split("/");
    const projectIndex = splittedPath.indexOf(this.project.location);
    return (
      splittedPath[projectIndex] +
      "/" +
      splittedPath[projectIndex] +
      "/" +
      splittedPath[splittedPath.length - 1]
    );
  }

  private extractKeywordName(line: string, column: number) {
    const keywordCallMatchs = line.match(
      /([a-z][a-z0-9_ ]+)(?=\()/ig
    );
    if (keywordCallMatchs) {
      let min = {
        index: 0,
        value:  Number.MAX_VALUE
      }; // select the nearest hovered keyword
      for (let i = 0; i < keywordCallMatchs.length; i++) {
        const difference =  column - line.indexOf(keywordCallMatchs[i]);
        if (difference > 0 && difference < min.value) {
          min.value = difference;
          min.index = i;
        }
      }

      const keywordSignature = keywordCallMatchs[min.index].replace(/^(and|given|then|when)/i, '').trim();
      return keywordSignature;
    }
    return null;
  }

  private openFileByFullPath(filePath) {
    const splittedPath = filePath.split("/");
    const projectIndex = splittedPath.indexOf(this.project.location);
    const relativeFilePath = filePath.substr(
      filePath.indexOf(this.projectService.testDirectory)
    );

    this.router.navigate([
      "editFile",
      splittedPath[projectIndex],
      splittedPath[splittedPath.length - 1],
      relativeFilePath,
    ]);
  }

  private handleTestSuiteErrors(compiledTestSuite) {debugger;
    let modelMarkers = [];
    for (const filePath in compiledTestSuite.fileMap) {
      if (this.file.path === filePath) {
        const compiledFile = compiledTestSuite.fileMap[filePath];
        if (compiledFile.syntaxErrors) {
          modelMarkers = [
            ...modelMarkers,
            ...compiledFile.syntaxErrors.map((syntaxError) => {
              return {
                startLineNumber: syntaxError.line,
                startColumn: syntaxError.charPositionInLine,
                endColumn:
                  syntaxError.stop -
                  syntaxError.start +
                  syntaxError.charPositionInLine,
                endLineNumber: syntaxError.line,
                message: syntaxError.message,
                severity: monaco.MarkerSeverity.Error,
              };
            }),
          ];
        }
        if (compiledFile.semanticErrors) {
          modelMarkers = [
            ...modelMarkers,
            ...compiledFile.semanticErrors.map((semanticError) => {
              return {
                startLineNumber: semanticError.position.line,
                startColumn: semanticError.position.charPositionInLine + 1,
                endColumn:
                  semanticError.position.stop -
                  semanticError.position.start +
                  semanticError.position.charPositionInLine +
                  1,
                endLineNumber: semanticError.position.line,
                message: semanticError.message,
                severity: monaco.MarkerSeverity.Error,
              };
            }),
          ];
        }
      }
    }
    monaco.editor.setModelMarkers(
      this.editorInstance.getModel(),
      "owner",
      modelMarkers
    );
  }
}
