// app.routing.ts
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DemandeComponent } from './demande/demande.component';
import { AjoutDemandeComponent } from './demande/ajout-demande/ajout-demande.component';
import { DemandDetailsComponent } from './demande/demand-details/demand-details.component';
import { Component } from '@angular/core';

const APP_ROUTES: Routes = [
    {
        path: '',
        component: HomeComponent,
    },
    {
        path: 'login',
        component: LoginComponent,
    },
    // {
    //     path : 'home',
    //     component: HomeComponent,
    //     pathMatch: 'full'
    // },
    {
        path: 'demande',
        component : DemandeComponent,
        // children : [
        //     // {path: 'ajout', component: AjoutDemandeComponent},
        //     {path: ':id', component: DemandDetailsComponent}
        // ]
    },
    {
        path: 'demandeDetails/:id',
        component: DemandDetailsComponent,
    },
    {
        path: 'demande/ajout',
        component : AjoutDemandeComponent,
    },
    {
      path: '**',
      redirectTo: '',
      pathMatch: 'full',
    }
];

export const Routing = RouterModule.forRoot(APP_ROUTES);
