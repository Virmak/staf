import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private serverUrl = 'http://127.0.0.1:8080/staf-websocket';
  private stompClient;

  constructor() { }

  initializeSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/tests', message => {
        console.log(message);
      });
    });
  }

  sendMessage(message) {
    this.stompClient.send('/app/runTests', {}, message);
    console.log('sent message');
  }
}
