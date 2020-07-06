import { HttpClient } from "@angular/common/http";
import { SequenceService } from "./sequence.service";
import { ITestSuite } from "./interfaces/itest-suite";
import { ICreateTestSuite } from "./interfaces/icreate-test-suite";
import { Injectable } from "@angular/core";
import { IDirectory } from "./interfaces/idirectory";
import { FileType } from "./interfaces/ifile";
import { environment } from "../environments/environment";
import { Observable } from "rxjs";

const baseUrl = environment.resolveApi();
const LOGS_DIR = "/logs";
const RESULTS_DIR = "/reports";

@Injectable({
  providedIn: "root",
})
export class TestSuiteService {
  constructor(private sequence: SequenceService, private http: HttpClient) {}

  createTestSuite(createTestSuite: ICreateTestSuite): Observable<any> {
    return this.http.post(baseUrl + "/testSuite", createTestSuite);
  }

  extractTestSuitesFromProject(project): ITestSuite[] {
    return project.content
      .filter((item) => item.type === FileType.Directory)
      .map((directory) => {
        const testSuiteContentDirectory: IDirectory = {
          name: directory.name,
          type: FileType.Directory,
          content: this.readDirectory(directory),
        };
        return {
          id: this.sequence.getNext("testSuite"),
          name: directory.name,
          content: testSuiteContentDirectory,
        };
      });
  }

  readDirectory(dir) {
    let dirMap = new Map();
    dir.content.forEach((file) => {
      if (file.type === FileType.File) {
        const extension = file.name.substr(1 + file.name.lastIndexOf("."));
        dirMap.set(file.path, {
          name: file.name,
          type: FileType.File,
          content: file.fileContent,
          path: file.path,
          extension,
        });
        if (this.isStafScript(extension)) {
          this.registerKeywords(file);
        }
      } else {
        
        dirMap.set(file.name, {
          name: file.name,
          type: FileType.Directory,
          content: this.readDirectory(file),
          path: file.path,
        });
      }
    });
    
    return dirMap;
  }

  registerKeywords(file: any) {
    const keywordsDeclarations = file.fileContent.match(
      /(?<=keywords[\s]*|end\s*|return.*\s*)(([a-z0-9_ ]+)\(\s*(\$[a-z0-9_]+\s*,?\s*)*\s*\)[\S\s]*?)/gim
    );
    if (keywordsDeclarations) {
      (<any>window).userKeywords[file.path] = keywordsDeclarations.map((k) => {
        const keywordSignature = k.trim();
        const keywordName = keywordSignature.substr(
          0,
          keywordSignature.indexOf("(")
        );
        return {
          keywordSignature,
          keywordName,
        };
      });
    }
  }

  isStafScript(extension) {
    return extension == "staf" || extension == "page" || extension == "steps";
  }

  getTestSuiteDetails(project, testSuite) {
    return this.http.get(
      environment.resolveApi() + "/testSuite/" + project + "/" + testSuite
    );
  }
}
