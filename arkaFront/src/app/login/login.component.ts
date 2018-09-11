import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers : [LoginService]
})
export class LoginComponent implements OnInit {

  error = ''; 
  status = '';

  loginForm = new FormGroup({
    username : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  }) ;

  constructor( private loginService : LoginService,
              private router: Router ) { }

  ngOnInit() {
  }

  onSubmit(data){
    this.loginService
      .authenticate(data);
    this.router.navigate(['home']);
  }

}
