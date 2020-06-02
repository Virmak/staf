import { LogServiceService } from './../log-service.service';
import { WebSocketApiService } from './../web-socket-api.service';
import { Component, OnInit, Input, OnDestroy, ViewChild, ElementRef } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'log-console',
  templateUrl: './log-console.component.html',
  styleUrls: ['./log-console.component.css']
})
export class LogConsoleComponent implements OnInit, OnDestroy {
  @ViewChild('logConsole') logConsole: ElementRef;
  logSubscription: Subscription;
  constructor(private webSocket: WebSocketApiService,
    public logService: LogServiceService) { }

  ngOnInit(): void {
    this.logSubscription = this.webSocket.messageSubject.subscribe((message: string) => {
      this.logService.addMessage(message);
      this.logConsole.nativeElement.scrollTop = this.logConsole.nativeElement.scrollHeight;
    });
  }


  ngOnDestroy(): void {
    this.logSubscription.unsubscribe();
  }

}
