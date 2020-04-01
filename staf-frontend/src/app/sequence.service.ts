import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SequenceService { // service to generate auto increment ids for projects and testSuites;

  private sequences = {};

  constructor() { }

  getNext(sequenceName) {
    if (this.sequences[sequenceName] == undefined) {
      this.sequences[sequenceName] = 0;
    }
    return this.sequences[sequenceName]++;
  }

  getLast(sequenceName) {
    return this.sequences[sequenceName] || 0;
  }
}
