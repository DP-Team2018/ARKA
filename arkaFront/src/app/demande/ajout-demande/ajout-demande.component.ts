import { Component, OnInit, Input } from '@angular/core';
import { myData } from '../demande.component';
import { AjoutDemandeService } from './ajout-demande.service';
import { Demande } from './demande';
import { FormGroup, FormControl } from '@angular/forms';
import { Papa } from 'ngx-papaparse';
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
  open = false ; 
  
  demandForm = new FormGroup({
    nom : new FormControl(),
    commentaire : new FormControl(),
    idCartonClient : new FormControl(),
    demandType : new FormControl(),
  });

  constructor(private ajoutService: AjoutDemandeService, private papa:Papa) { }

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
  public changeListener(files: FileList) {
    console.log(files);
    if (files && files.length > 0) {
      let file: File = files.item(0);
      console.log(file.name);
      console.log(file.size);
      console.log(file.type);
      let j = 0 ;
      let demands = {};
      let all = [];
      let reader = new FileReader();
      reader.onload = (e) => {
        let csvData: string = reader.result;
        let options = {
          complete: (results, file) => {
            for (let index = 0; index < results['data'].length - 1; index++) {
              demands['nom'] = results['data'][index][j];
              demands['note'] = results['data'][index][j + 1];
              demands['codeClient'] = results['data'][index][j + 2];

              console.log(demands) ;
              all[index] =  { 'nom': demands['nom'], 'note': demands['note'], 'codeClient':  demands['codeClient'] };
              j = 0;
            }
            console.log('Parsed: ', JSON.stringify(all), file);
          }
          // Add your options here
        };
        this.papa.parse(csvData, options);

      }
      reader.readAsText(file, 'UTF-8');
    //     for (let i = 0; i < allTextLines.length; i++) {
    //       // split content based on comma  
    //       let data = allTextLines[i].split(',');
    //       if (data.length === headers.length) {
    //         let tarr = [];
    //         for (let j = 0; j < headers.length; j++) {
    //           tarr.push(data[j]);
    //         }

    //         // log each row to see output  
    //          console.log(tarr);
    //         // console.log("json convert" + JSON.stringify(tarr));
    //         lines.push(tarr);
    //       }
    //     }
    //     // all rows in the csv file  
    //     console.log(">>>>>>>>>>>>>>>>>", JSON.stringify(lines));  
    // }
  }
}
  // ajouterDemande() {
  //   open = true ;
  //   console.log(open);  
  // }
}