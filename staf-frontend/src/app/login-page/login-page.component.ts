import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  form = {
    type: 'admin',
    username: '',
    password: '',
    rememberMe: false,
  };
  hasErrors = false;

  constructor(private authSerivce: AuthService) { }

  ngOnInit() {
    
  }

  doLogin() {
    this.authSerivce.login(this.form.username, this.form.password, err => {
      this.hasErrors = true;
    });
  }

}
