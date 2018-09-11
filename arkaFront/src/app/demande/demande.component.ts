import { Component, OnDestroy, OnInit, Input } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Subject } from 'rxjs';
import { DemandeService } from './demande.service';
import { Router } from '@angular/router';

export interface myData {
  idDemand: number;
  Representant: string;
  note: string;
  demandType: string;
}

@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.css'],
  providers: [DemandeService]
})
export class DemandeComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject = new Subject<any>();
 // demandes: myData;
 // data: myData;
  demandes: myData[] = []  ;
  error = '';

  constructor(private myService: DemandeService) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10
    };
    this.myService.getData()
      .subscribe(data  => { this.demandes = data;
        this.dtTrigger.next();
      });

  }



}
