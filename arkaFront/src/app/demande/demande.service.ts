import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DemandeService {

  constructor(private http: HttpClient) { }

  getData(){
    return this.http.get('http://localhost:18080/api/demandes');
    });
  }
}
