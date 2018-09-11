import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  authenticate(user: any) {
    const url = 'http://192.168.1.12:18080/Arka-web/api/demandes';
    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded'});
    const options = {headers : headers};
    let  body = new HttpParams();
    body = body.append('username', user.username);
    body = body.append('password', user.password);

    return this.http.post(url, body, options);

  }
}
