import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const baseUrl = 'http://127.0.0.1:8080';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) { }

  runTest(projectName) {
    return this.http.post(baseUrl + '/runTest', { project: projectName});
  }

}
