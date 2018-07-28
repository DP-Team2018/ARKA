import { Component, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';

@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.css']
})
export class DemandeComponent implements OnInit {

  constructor(private http:Http) { }

  ngOnInit() {
  }

  sentDemand(demande:any){
    let url     = 'http://127.0.0.1:8000/arka-web/api/demandes';
        let body     = new URLSearchParams();
        body.append('username', demande.id);
        body.append('password', demande.carton);
      let headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
        let options = new RequestOptions({headers: headers});

      return this.http
              .post(url, body.toString(), options)
          .map((data: Response) => data.json());
  }
}
