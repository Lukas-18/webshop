import { Observable } from 'rxjs';
import { User } from '../entity/User';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private apiServerUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) { }

    public getAllUsers(): Observable<User[]> {
        return this.http.get<User[]>(`${this.apiServerUrl}/webshop_user/all`);
    }

    public getUserById(id: number): Observable<User> {
        return this.http.get<User>(`${this.apiServerUrl}/webshop_user/${id}`);
    }

    public createUser(user: User): Observable<User> {
        alert("Registrierung erfolgreich!");
        return this.http.post<User>(`${this.apiServerUrl}/webshop_user/create`, user);
    }

    public updateUser(user: User): Observable<User> {
        return this.http.put<User>(`${this.apiServerUrl}/webshop_user/update`, user);
    }

    public deleteUser(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/webshop_user/delete/${id}`);
    }
}