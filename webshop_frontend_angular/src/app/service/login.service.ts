import { Injectable } from '@angular/core';
import { User } from '../entity/User';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiServerUrl = 'http://localhost:8080/webshop_user/login';

  constructor(private http: HttpClient) { }

  public loginUser(user: User): Observable<object> {
      return this.http.post(`${this.apiServerUrl}`, user);
  }
}
