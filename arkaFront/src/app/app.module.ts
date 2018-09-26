import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Routes, ROUTES} from '@angular/router';
import { Routing } from './app.routing';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './/app-routing.module';
import { HomeComponent } from './home/home.component';
import { DemandeComponent } from './demande/demande.component';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule} from '@angular/common/http';
import { Http, HttpModule, RequestOptions } from '@angular/http';
import { AjoutDemandeComponent } from './demande/ajout-demande/ajout-demande.component';
import { FormsModule } from '@angular/forms';

import { ReactiveFormsModule } from '@angular/forms';
import { ContactComponent } from './contact/contact.component';
import { DemandDetailsComponent } from './demande/demand-details/demand-details.component';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    HomeComponent,
    DemandeComponent,
    AjoutDemandeComponent,
    ContactComponent,
    DemandDetailsComponent
  ],
  imports: [
    BrowserModule,
    Routing,
    AppRoutingModule,
    DataTablesModule,
    HttpClientModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
