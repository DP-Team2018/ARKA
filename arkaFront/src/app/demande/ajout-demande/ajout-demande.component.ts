import { Component, OnInit, Input } from '@angular/core';
import { myData } from '../demande.component';
import { AjoutDemandeService } from './ajout-demande.service';
import { Demande } from './demande';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-ajout-demande',
  templateUrl: './ajout-demande.component.html',
  styleUrls: ['./ajout-demande.component.css'],
  providers: [AjoutDemandeService],
})
export class AjoutDemandeComponent implements OnInit {
  private fieldArray: Array<any> = [] ;
  private newAttribute: any = {};
  demandes: Array<Demande> = []  ;

  demandForm = new FormGroup({
    title : new FormControl(),
    userId : new FormControl(),
    // idCartonClient : new FormControl(),
    // demandType : new FormControl(),
  });

  constructor(private ajoutService : AjoutDemandeService) { }

  ngOnInit() {
    this.fieldArray.push(this.newAttribute) ;
    this.newAttribute = {};
  }

  addFieldValue(){
    this.fieldArray.push(this.newAttribute);
    this.newAttribute = {};
  }
  deleteFieldValue(index) {
    this.fieldArray.splice(index, 1);
  }
 onSubmit(data){
   this.demandes.push(data) ;
   console.log(this.demandes);
   this.ajoutService.addDemande(data).subscribe(status => console.log(status));
 }
}
