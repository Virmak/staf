import { ProjectService } from './../project.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {
  projects = [];
  project;
  projectId;
  reportTabActive = false;
  reports = [];
  
  constructor(private route: ActivatedRoute, private projectService: ProjectService) { }

  ngOnInit(): void {
    this.projectService.getProjectsSubject().subscribe(projects => {
      this.projects = projects;
      this.project = this.projectService.getProjectById(this.projectId);
      console.log(this.projectId, this.project)
    });
    this.route.paramMap.subscribe(paramMap => {
      this.projectId = paramMap.get('id');
      this.project = this.projectService.getProjectById(this.projectId);
      console.log(this.projectId)
    });
    this.reports = reports;
  }

  onTestCompleted(reports) {
    this.reportTabActive = true;
    this.reports = reports;
  }
}


const reports = [{"testSuite":"purchase","message":null,"result":"Pass","source":"purchase/main.staf","start":"2020-04-08T18:05:53.351+0000","end":"2020-04-08T18:06:12.373+0000","testCaseReports":[{"testSuite":"purchase","testCase":"SETUP","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"openbrowser","argumentsList":[{"value":"chrome","type":"STRING","primitive":true}],"lineNumber":26,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:53.502+0000","end":"2020-04-08T18:05:54.144+0000"}],"start":"2020-04-08T18:05:53.501+0000","end":"2020-04-08T18:05:54.144+0000"},{"testSuite":"purchase","testCase":"settingthinsup","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"set ok","type":"STRING","primitive":true}],"lineNumber":30,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:05:54.145+0000"}],"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:05:54.145+0000"},{"testSuite":"purchase","testCase":"first","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"object":{"value":"$res","type":"VAR_REF","primitive":false},"value":{"value":null,"type":"KEYWORD_CALL","keywordName":"opengooglepage","argumentsList":[{"value":"$googleUrl","type":"VAR_REF","primitive":false},{"value":"$searchInput","type":"VAR_REF","primitive":false},{"value":"$searchBtn","type":"VAR_REF","primitive":false}],"lineNumber":34,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"nested","argumentsList":[],"lineNumber":17,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"hello world","type":"STRING","primitive":true}],"lineNumber":13,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"error","type":"STRING","primitive":true}],"lineNumber":14,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"}],"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:05:54.145+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"goto","argumentsList":[{"value":"$url","type":"VAR_REF","primitive":false}],"lineNumber":18,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:05:59.090+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"waituntilelementisvisible","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false}],"lineNumber":19,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:59.090+0000","end":"2020-04-08T18:05:59.146+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"inputtext","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false},{"value":"test automation","type":"STRING","primitive":true}],"lineNumber":20,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:59.146+0000","end":"2020-04-08T18:05:59.503+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"clickelement","argumentsList":[{"value":"$searchBtn","type":"VAR_REF","primitive":false}],"lineNumber":21,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:59.503+0000","end":"2020-04-08T18:06:02.369+0000"}],"primitive":false},"statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"nested","argumentsList":[],"lineNumber":17,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"hello world","type":"STRING","primitive":true}],"lineNumber":13,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"error","type":"STRING","primitive":true}],"lineNumber":14,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"}],"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:05:54.145+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"goto","argumentsList":[{"value":"$url","type":"VAR_REF","primitive":false}],"lineNumber":18,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:05:59.090+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"waituntilelementisvisible","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false}],"lineNumber":19,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:59.090+0000","end":"2020-04-08T18:05:59.146+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"inputtext","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false},{"value":"test automation","type":"STRING","primitive":true}],"lineNumber":20,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:59.146+0000","end":"2020-04-08T18:05:59.503+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"clickelement","argumentsList":[{"value":"$searchBtn","type":"VAR_REF","primitive":false}],"lineNumber":21,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:59.503+0000","end":"2020-04-08T18:06:02.369+0000"}]},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:06:02.369+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"opengooglepage","argumentsList":[{"value":"https://google.fr","type":"STRING","primitive":true},{"value":"$searchInput","type":"VAR_REF","primitive":false},{"value":"$searchBtn","type":"VAR_REF","primitive":false}],"lineNumber":36,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"nested","argumentsList":[],"lineNumber":17,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"hello world","type":"STRING","primitive":true}],"lineNumber":13,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"log","argumentsList":[{"value":"error","type":"STRING","primitive":true}],"lineNumber":14,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"}],"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:02.369+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"goto","argumentsList":[{"value":"$url","type":"VAR_REF","primitive":false}],"lineNumber":18,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:05.044+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"waituntilelementisvisible","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false}],"lineNumber":19,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:05.044+0000","end":"2020-04-08T18:06:05.092+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"inputtext","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false},{"value":"test automation","type":"STRING","primitive":true}],"lineNumber":20,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:05.092+0000","end":"2020-04-08T18:06:05.392+0000"},{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"clickelement","argumentsList":[{"value":"$searchBtn","type":"VAR_REF","primitive":false}],"lineNumber":21,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:05.392+0000","end":"2020-04-08T18:06:12.263+0000"}],"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:02.369+0000","end":"2020-04-08T18:06:12.263+0000"}],"start":"2020-04-08T18:05:54.145+0000","end":"2020-04-08T18:06:12.263+0000"},{"testSuite":"purchase","testCase":"TEARDOWN","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":"KEYWORD_CALL","keywordName":"closebrowser","argumentsList":[],"lineNumber":40,"file":"tests/stark-erp-ui-test/purchase/main.staf","statementReports":null,"primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-08T18:06:12.263+0000","end":"2020-04-08T18:06:12.373+0000"}],"start":"2020-04-08T18:06:12.263+0000","end":"2020-04-08T18:06:12.373+0000"}]}]