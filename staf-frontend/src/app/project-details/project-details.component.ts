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


const reports = [{"testSuite":"purchase","message":null,"result":"Pass","source":"purchase/main.staf","start":"2020-04-07T21:30:02.566+0000","end":"2020-04-07T21:46:36.468+0000","testCaseReports":[{"testSuite":"purchase","testCase":"SETUP","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":null,"keywordName":"openbrowser","argumentsList":[{"value":"chrome","type":"STRING","primitive":true}],"lineNumber":19,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-07T21:30:13.231+0000","end":"2020-04-07T21:30:26.043+0000"}],"start":"2020-04-07T21:30:03.958+0000","end":"2020-04-07T21:30:26.043+0000"},{"testSuite":"purchase","testCase":"settingthinsup","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":null,"keywordName":"log","argumentsList":[{"value":"set ok","type":"STRING","primitive":true}],"lineNumber":23,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-07T21:30:31.266+0000","end":"2020-04-07T21:30:35.468+0000"}],"start":"2020-04-07T21:30:26.043+0000","end":"2020-04-07T21:30:35.468+0000"},{"testSuite":"purchase","testCase":"first","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"object":{"value":"$res","type":"VAR_REF","primitive":false},"value":{"value":null,"type":null,"keywordName":"opengooglepage","argumentsList":[{"value":"$googleUrl","type":"VAR_REF","primitive":false},{"value":"$searchInput","type":"VAR_REF","primitive":false}],"lineNumber":27,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false}},"children":[{"statement":{"value":null,"type":null,"keywordName":"goto","argumentsList":[{"value":"$url","type":"VAR_REF","primitive":false}],"lineNumber":12,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-07T21:31:00.684+0000","end":"2020-04-07T21:31:41.663+0000"},{"statement":{"value":null,"type":null,"keywordName":"waituntilelementisvisible","argumentsList":[{"value":"$searchInput","type":"VAR_REF","primitive":false}],"lineNumber":13,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-07T21:31:45.391+0000","end":"2020-04-07T21:31:50.878+0000"},{"statement":{"value":null,"type":null,"keywordName":"inputtext","argumentsList":[{"value":"css:elemNot","type":"STRING","primitive":true},{"value":"test automation","type":"STRING","primitive":true}],"lineNumber":14,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"children":null,"result":"Fail","errorMessage":"no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"elemNot\"}\n  (Session info: chrome=80.0.3987.163)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'\nSystem info: host: 'virmak-arch', ip: '192.168.1.228', os.name: 'Linux', os.arch: 'amd64', os.version: '5.5.13-arch1-1', java.version: '11.0.6'\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 80.0.3987.163, chrome: {chromedriverVersion: 80.0.3987.163 (e7fbe071abe9..., userDataDir: /tmp/.org.chromium.Chromium...}, goog:chromeOptions: {debuggerAddress: localhost:44949}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: LINUX, platformName: LINUX, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: f93ae2642f60b792ecf412320ec65a73\n*** Element info: {Using=css selector, value=elemNot}","screenShot":"tests/stark-erp-ui-test/purchase/reports/screenshot-purchase-first-1586295221252.png","start":"2020-04-07T21:31:54.530+0000","end":"2020-04-07T21:34:07.281+0000"}],"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-07T21:30:39.251+0000","end":"2020-04-07T21:46:35.452+0000"}],"start":"2020-04-07T21:30:35.468+0000","end":"2020-04-07T21:46:35.453+0000"},{"testSuite":"purchase","testCase":"TEARDOWN","errorMessage":null,"result":"Pass","statementReports":[{"statement":{"value":null,"type":null,"keywordName":"closebrowser","argumentsList":[],"lineNumber":31,"file":"tests/stark-erp-ui-test/purchase/main.staf","primitive":false},"children":null,"result":"Pass","errorMessage":null,"screenShot":null,"start":"2020-04-07T21:46:36.392+0000","end":"2020-04-07T21:46:36.468+0000"}],"start":"2020-04-07T21:46:35.453+0000","end":"2020-04-07T21:46:36.468+0000"}]}]