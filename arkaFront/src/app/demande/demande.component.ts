import { AfterViewInit, Component, OnDestroy, OnInit, Input, Renderer, Output } from '@angular/core';
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
  dtTrigger = new Subject<any>();
 // demandes: myData;
 // data: myData;
  demandes: any[] = []  ;
  error = '';
  constructor(private renderer: Renderer,  private myService: DemandeService, private router:Router) { }

  ngOnInit() {
    this.myService.getData()
      .subscribe(data  => { this.demandes = data;
        this.dtTrigger.next();
      });
  }
  // ngAfterViewInit(): void {
  //   this.renderer.listenGlobal('document', 'click', (event) => {
  //     if (event.target.hasAttribute("view-demand-id")) {
  //       this.router.navigate(["/demand/" + event.target.getAttribute("view-demand-id")]);
  //     }
  //   });
  showDetails(demand){
    // this.selectedDemand = demand ;
    // this.id = demand.idDemand ; 
    console.log(demand.idDemand);
    this.router.navigate(['demandeDetails', demand.idDemand]) ;
    // this.selectedIndex = i ;
  }


}
