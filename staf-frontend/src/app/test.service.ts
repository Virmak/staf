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
  public webDriverAddress;

  constructor(private http: HttpClient, private toastr: ToastrService) {
    
    this.webDriverAddress = localStorage.getItem('webDriverAddr');

   }

  runTest(runTest: RunTestRequest) {
    if (this.webDriverAddress) {
      runTest.webDriverAddress = this.webDriverAddress;
    } else {
      this.toastr.error('You need to set the web driver address before continuing', 'Error running tests');
      return throwError({});
    }
    this.toastr.info(runTest.project + ' Tests are running', 'Test');
    return this.http.post(baseUrl + '/runTest', runTest);
  }

  setWebDriverAddress(addr, port) {
    this.webDriverAddress = addr + ':' + port;
    localStorage.setItem('webDriverAddr', this.webDriverAddress);
    this.toastr.success('Web driver address set', 'Success');
    
  }

}
