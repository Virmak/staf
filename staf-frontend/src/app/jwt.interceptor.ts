import { environment } from './../environments/environment';
import { AuthService } from './auth.service';
import { Injectable, Injector } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = environment.resolveApi();

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private auth: AuthService) {
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

   if (this.auth) {
    const currentUser = this.auth.getCurrentUser();
    const isLoggedIn = currentUser && currentUser.token;
    const isApiUrl = request.url.startsWith(baseUrl);
    if (isLoggedIn && isApiUrl) {
        request = request.clone({
            setHeaders: {
                Authorization: `Bearer ${currentUser.token}`
            }
        });
    }
   }

    return next.handle(request);
  }
}
