import { Component, OnInit, Input } from '@angular/core';
import {  myData } from '../demande.component';
import { ActivatedRoute } from '@angular/router';
import { DemandeService } from '../demande.service' ;
import { Subject } from 'rxjs';
@Component({
  selector: 'app-demand-details',
  templateUrl: './demand-details.component.html',
  styleUrls: ['./demand-details.component.css'],
  providers : [DemandeService],
})
export class DemandDetailsComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger = new Subject<any>();
  id = null ;
  demandes: any ;
  constructor(private Service: DemandeService,  private route: ActivatedRoute ) { }

  ngOnInit() {
    this.dtOptions = {
    };
    this.route.params.subscribe(params => {
      console.log(params);
      console.log(params['id']);
      this.id = params['id'];
    });
    this.Service.getData().subscribe(data => {
      this.demandes = data;
      this.dtTrigger.next();
    });
    console.log(this.demandes);

    // console.log(this.id);
  }
  // getDemande(id) {
  //   return this.demandes.find(d => d.id === id);
  // }

}
