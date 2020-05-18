import { environment } from './../environments/environment';
import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class WebSocketApiService {
  topic: string = "/staf/logs";
  stompClient: any;
  messageSubject = new Subject();

  constructor() { }

  _connect() {
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(environment.resolveApi() + '/staf-ws');
    this.stompClient = Stomp.over(ws);
    const _this = this;
    _this.stompClient.connect({}, function (frame) {
      
      _this._send({message: 'okok'})
      _this.stompClient.subscribe('/staf/logs', function (sdkEvent) {
        _this.onMessageReceived(sdkEvent);
      });
      //_this.stompClient.reconnect_delay = 2000;
    }, this.errorCallBack);
  }

  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    console.log("Disconnected");
  }

  // on error, schedule a reconnection attempt
  errorCallBack(error) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
      this._connect();
    }, 5000);
  }

  _send(message) {
    console.log("calling logout api via web socket");
    this.stompClient.send("/app/hello", {}, JSON.stringify(message));
  }

  onMessageReceived(message) {
    console.log("Message Recieved from Server :: " + message);
    this.messageSubject.next(message.body);

  }

}
