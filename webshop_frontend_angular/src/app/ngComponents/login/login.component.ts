import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entity/User';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  user: User = new User();

  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    
  }

  userLogin(){
    console.log(this.user);
    this.loginService.loginUser(this.user).subscribe(data =>{
      alert("Login erfolgreich!");
    }, 
    error => {
      alert("Geben Sie bitte eine korrekte E-Mail und Passwort ein.");
    });
    
  }

}
