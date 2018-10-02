import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Routing } from '../app.routing';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  sIndex : number ;
  constructor(private router: Router) { }

  ngOnInit() {
  }
  setIndex(i){
    this.sIndex = i;
  }
}