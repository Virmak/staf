import { HttpClient } from '@angular/common/http';
import { SequenceService } from './sequence.service';
import { ITestSuite } from './interfaces/itest-suite';
import { ICreateTestSuite } from './interfaces/icreate-test-suite';
import { Injectable } from '@angular/core';
import { IDirectory } from './interfaces/idirectory';
import { FileType} from './interfaces/ifile';
import { environment } from '../environments/environment';
import { Observable } from 'rxjs';

const baseUrl = environment.resolveApi();
const LOGS_DIR = '/logs';
const RESULTS_DIR = '/reports';

@Injectable({
  providedIn: 'root'
})
export class TestSuiteService {

  constructor(private sequence: SequenceService, private http: HttpClient) { }

  createTestSuite(createTestSuite: ICreateTestSuite): Observable<any> {
    let testSuiteContentDir: IDirectory = {
      name: createTestSuite.name,
      type: FileType.Directory,
      content: new Map(),
    }
    if (createTestSuite.type == 'UITest') {
      testSuiteContentDir.content.set('pages', {
        name: 'Pages',
        type: FileType.Directory,
        content: new Map(),
      });
      testSuiteContentDir.content.set('steps', {
        name: 'Steps',
        type: FileType.Directory,
        content: new Map(),
      });
      testSuiteContentDir.content.set('main.staf', {
        name: 'main.staf',
        type: FileType.File,
        content: '',
      });
      
    } else if (createTestSuite.type == 'APITest') {
      testSuiteContentDir.content.set('config', {
        name: 'Config',
        type: FileType.Directory,
        content: new Map(),
      });
      testSuiteContentDir.content.set('requests', {
        name: 'Requests',
        type: FileType.Directory,
        content: new Map(),
      });
      testSuiteContentDir.content.set('main.staf', {
        name: 'Steps',
        type: FileType.File,
        content: '',
      });
    }
    return this.http.post(baseUrl + '/testSuite', createTestSuite);
  }

  extractTestSuitesFromProject(project): ITestSuite[] {
    return project.folders.filter(folder => !folder.name.endsWith(LOGS_DIR) && !folder.name.endsWith(RESULTS_DIR))
    .map(folder => {
      const testSuiteName = folder.name.substring(folder.name.lastIndexOf('/') + 1);
      let testSuiteContentDir: IDirectory = {
        name: testSuiteName,
        type: FileType.Directory,
        content: this.readDirectory(folder),
      }
      return {
        id: this.sequence.getNext('testSuite'),
        name: testSuiteName,
        content: testSuiteContentDir,
      };
    });
  }

  readDirectory(dir) {
    let dirMap = new Map();
    dir.files.forEach(file => {
      let filePath = Object.keys(file)[0];
      const fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
      const extension = fileName.substr(1+ fileName.lastIndexOf("."));
      dirMap.set(filePath, {
        name: fileName,
        type: FileType.File,
        content: file[filePath].fileContent,
        path: filePath,
        extension,
      });
      if (this.isStafScript(extension)) {
        const keywordsDeclarations = file[filePath].fileContent
          .match(/(?<=keywords[\s]*|end\s*|return.*\s*)(([a-z0-9_ ]+)\(\s*(\$[a-z0-9_]+\s*,?\s*)*\s*\)[\S\s]*?)/gim);
        if (keywordsDeclarations) {
          (<any>window).userKeywords[filePath] = keywordsDeclarations.map(k => {
            const keywordSignature = k.trim();
            const keywordName = keywordSignature.substr(0, keywordSignature.indexOf('('));
            return {
              keywordSignature,
              keywordName
            }
          });
        }
        
      }
    });
    dir.folders.forEach(folder => {
      const folderName = folder.name.substring(folder.name.lastIndexOf('/') + 1);
      dirMap.set(folderName, {
        name: folderName,
        type: FileType.Directory,
        content: this.readDirectory(folder),
        path: folder.path
      });
    });
    return dirMap;
  }

  isStafScript(extension) {
    return extension == 'staf' || extension == 'page'
      || extension == 'steps';
  }

  getTestSuiteDetails(project, testSuite) {
    return this.http.get(environment.resolveApi() + '/testSuite/' + project + '/' + testSuite);
  }
}
