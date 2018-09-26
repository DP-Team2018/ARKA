import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Response, Http } from '@angular/http';
import { map, switchMap, catchError, mergeMap } from 'rxjs/operators';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import { myData } from './demande.component';
@Injectable()
export class DemandeService {
  demandes: any;
  constructor(private http: HttpClient) { }

  getData(): Observable<any[]> {
    return this.demandes = this.http.get<any[]>('http://127.0.0.1/demandes.php');
    }

  getDemand(): Observable<any[]> {
    return this.demandes = this.http.get<any[]>('http://127.0.0.1/demande.php');
  }

}
