import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers  } from '@angular/http';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'; 
import { myData } from '../demande.component';
import { Observable } from 'rxjs';
import { Demande } from './demande';

@Injectable()
export class AjoutDemandeService {

  constructor(private http: HttpClient) { }
  // post = {
  //     'title' : 'salut',
  //     'userId' : '2'
  // }
  addDemande(demande: any): Observable<any> {
    // tslint:disable-next-line:max-line-length
    const url = 'http://127.0.0.1/demandes.php';
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Cache-Control': 'no-cache',
      'Access-Control-Allow-Origin': '*',
    });
    const options = { headers: httpHeaders };
    return this.http.post(url, JSON.stringify(demande), options);

  }
}
