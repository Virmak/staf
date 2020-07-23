import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';
import { IUser } from './interfaces/iuser';
import { IAuthResponse } from './interfaces/iauth-response';
import { StafAPI } from './api-endpoints';
import { environment } from './../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const baseUrl = environment.resolveApi();

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authenticatedUserSubject: BehaviorSubject<IAuthResponse> = new BehaviorSubject(null);
  isAutheticated = false;
  static token;

  constructor(private http: HttpClient, private router: Router) {     
    const savedUserJson = localStorage.getItem('authenticatedUser');
    if (savedUserJson) {
      const savedUser: IAuthResponse = JSON.parse(savedUserJson);
      if (savedUser) {
        this.authenticatedUserSubject.next(savedUser);
        this.isAutheticated = true;
        this.router.navigate(['/projects']);
      }
    } else {
      this.router.navigate(['/login']);
    }
  }

  login(username: string, password: string, errorCallback = null) {
    this.http.post(baseUrl + StafAPI.LOGIN, {username, password})
      .subscribe((res: IAuthResponse) => {
        this.authenticatedUserSubject.next(res);
        localStorage.setItem('authenticatedUser', JSON.stringify(res));
        this.isAutheticated = true;
        AuthService.token = res.token;
        this.router.navigate(['/projects']);
      }, errorCallback);
  }

  logout() {
    this.isAutheticated = false;
    this.authenticatedUserSubject.next(null);
    localStorage.removeItem('authenticatedUser');
    this.router.navigate(['/login']);
  }

  getCurrentUser() {
    return this.authenticatedUserSubject.value;
  }
}
