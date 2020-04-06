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


const reports = [{"testSuite":"purchase","message":null,"result":"Pass","source":"purchase/main.staf","start":"2020-04-06T22:19:05.418+0000","end":"2020-04-06T22:19:20.964+0000","testCaseReports":[{"testSuite":"purchase","testCase":"SETUP","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":null,"keywordName":"openbrowser","argumentsList":[{"value":"chrome","type":"STRING","primitive":true}],"lineNumber":19,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"result":"Pass","errorMessage":null,"start":"2020-04-06T22:19:05.953+0000","end":"2020-04-06T22:19:07.057+0000"}],"startTime":"2020-04-06T22:19:05.953+0000","endTime":"2020-04-06T22:19:07.057+0000"},{"testSuite":"purchase","testCase":"settingthinsup","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":null,"keywordName":"log","argumentsList":[{"value":"set ok","type":"STRING","primitive":true}],"lineNumber":23,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"result":"Pass","errorMessage":null,"start":"2020-04-06T22:19:07.057+0000","end":"2020-04-06T22:19:07.058+0000"}],"startTime":"2020-04-06T22:19:07.057+0000","endTime":"2020-04-06T22:19:07.058+0000"},{"testSuite":"purchase","testCase":"first","errorMessage":null,"result":"Fail","statementReports":[{"statement":{"object":{"value":"$res","type":"VAR_REF","primitive":false},"value":{"value":null,"type":null,"keywordName":"opengooglepage","argumentsList":[],"lineNumber":27,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false}},"result":"Fail","errorMessage":"Keyword call : inputtext [\"css:elemNot\", \"test automation\"] at tests/stark-erp-ui-test/purchase/main.staf  at line 14\norg.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"elemNot\"}\n  (Session info: chrome=80.0.3987.163)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'\nSystem info: host: 'virmak-arch', ip: '192.168.1.228', os.name: 'Linux', os.arch: 'amd64', os.version: '5.5.13-arch1-1', java.version: '11.0.6'\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 80.0.3987.163, chrome: {chromedriverVersion: 80.0.3987.163 (e7fbe071abe9..., userDataDir: /tmp/.org.chromium.Chromium...}, goog:chromeOptions: {debuggerAddress: localhost:42881}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: LINUX, platformName: LINUX, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: a52f2f5dc4dcfe4473851b9cac2302db\n*** Element info: {Using=css selector, value=elemNot}","start":"2020-04-06T22:19:07.058+0000","end":"2020-04-06T22:19:20.850+0000"}],"startTime":"2020-04-06T22:19:07.058+0000","endTime":"2020-04-06T22:19:20.850+0000"},{"testSuite":"purchase","testCase":"TEARDOWN","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":null,"keywordName":"closebrowser","argumentsList":[],"lineNumber":31,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"result":"Pass","errorMessage":null,"start":"2020-04-06T22:19:20.850+0000","end":"2020-04-06T22:19:20.964+0000"}],"startTime":"2020-04-06T22:19:20.850+0000","endTime":"2020-04-06T22:19:20.964+0000"}]}];
