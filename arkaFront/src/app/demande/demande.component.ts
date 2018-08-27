import { Component, OnDestroy, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Subject } from 'rxjs';
import { DemandeService } from './demande.service';

interface myData{
  obj: Object;
}

@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.css']
})
export class DemandeComponent implements OnInit {
  demandes = {} ;

  constructor(private MyService: DemandeService) { }

  ngOnInit() {
    this.MyService.getData().subscribe(data => {
      this.demandes = data.obj;
    });
  }



}
