import { LogServiceService } from './../log-service.service';
import { WebSocketApiService } from './../web-socket-api.service';
import { Component, OnInit, Input, OnDestroy, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'log-console',
  templateUrl: './log-console.component.html',
  styleUrls: ['./log-console.component.css']
})
export class LogConsoleComponent implements OnInit, OnDestroy {
  interval;
  @ViewChild('logConsole') logConsole: ElementRef;

  constructor(private webSocket: WebSocketApiService,
    public logService: LogServiceService) { }

  ngOnInit(): void {
    this.webSocket.messageSubject.subscribe((message: string) => {
      this.logService.addMessage(message);
      this.logConsole.nativeElement.scrollTop = this.logConsole.nativeElement.scrollHeight + 50;
    });
  }


  ngOnDestroy(): void {
  }

  clearInterval() {
    clearInterval(this.interval);
  }

}
