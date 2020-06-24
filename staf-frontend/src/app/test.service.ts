import { IWebDriverOptions } from './interfaces/web-driver-options';
import { environment } from './../environments/environment';
import { RunTestRequest } from './interfaces/run-test-request';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { throwError } from 'rxjs';

const baseUrl = environment.resolveApi();

@Injectable({
  providedIn: 'root'
})
export class TestService {
  public driverOptions: IWebDriverOptions;
  constructor(private http: HttpClient, private toastr: ToastrService) {
    this.driverOptions = JSON.parse(localStorage.getItem('webDriverOptions'));
   }

  runTest(runTest: RunTestRequest) {
    if (this.driverOptions) {
      runTest.webDriverOptions = this.driverOptions;
    } else {
      this.toastr.error('You need to set the web driver address before continuing', 'Error running tests');
      return throwError({});
    }
    this.toastr.info(runTest.project + ' Tests are running', 'Test');
    return this.http.post(baseUrl + '/runTest', runTest);
  }

  setWebDriverOptions(options: IWebDriverOptions) {
    this.driverOptions = options;
    localStorage.setItem('webDriverOptions', JSON.stringify(options));
    this.toastr.success('Web driver address set', 'Success');
  }

  stopTest() {
    return this.http.post(baseUrl + '/terminateTest', {});
  }

}
