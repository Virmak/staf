import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const baseUrl = environment.resolveApi();

@Injectable({
  providedIn: 'root'
})
export class DocsService {

  constructor(private http: HttpClient) { }

  getBuiltinLibrariesKeywords() {
    return this.http.get(baseUrl + '/docs/builtinKeywords');
  }
}
