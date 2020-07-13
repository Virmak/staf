import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const baseUrl = environment.resolveApi();

@Injectable({
  providedIn: 'root'
})
export class DocsService {

  private builtinLibrariesBehaviorSubject = new BehaviorSubject([]);

  constructor(private http: HttpClient) { 
    this.http.get(baseUrl + '/docs/builtinKeywords').subscribe((builtinLibraries: any[]) => {
      this.builtinLibrariesBehaviorSubject.next(builtinLibraries);
    })
  }

  getBuiltinLibrariesKeywords() {
    return this.builtinLibrariesBehaviorSubject;
  }
}
