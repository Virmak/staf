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
  showConsole = false;
  constructor(private webSocket: WebSocketApiService,
    public logService: LogServiceService) { }

  ngOnInit(): void {
    this.logSubscription = this.webSocket.messageSubject.subscribe((message: string) => {
      this.showConsole = true;
      this.logService.addMessage(message);
      setTimeout(() => this.logConsole.nativeElement.scrollTop = 10000000, 0);
    });
  }


  ngOnDestroy(): void {
    this.logSubscription.unsubscribe();
  }

  toggleConsoleLog() {
    this.showConsole = !this.showConsole;
  }

  clearConsole() {
    this.logService.logContent = '';
  }

}
