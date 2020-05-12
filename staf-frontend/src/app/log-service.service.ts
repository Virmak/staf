import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogServiceService {

  logContent;
  debug = true;

  constructor() { }

  addMessage(message) {
    if (message.indexOf('ERROR') > -1) {
      message = '<span class="log-error">' + message + '</span>';
    }
    if (message.indexOf('WARN') > -1) {
      message = '<span class="log-warn">' + message + '</span>';
    }
    if (message.indexOf('INFO') > -1) {
      message = '<span class="log-info">' + message + '</span>';
    }
    if (this.debug && message.indexOf('DEBUG') > -1) {
      message = '<span class="log-debug">' + message + '</span>';
    }
    this.logContent += message + '<br>';
  }
  
  newSession() {
    this.logContent = '';
  }
}
