// app.routing.ts
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DemandeComponent } from './demande/demande.component';
import { AjoutDemandeComponent } from './demande/ajout-demande/ajout-demande.component';


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
    },
    {
        path: 'demande/ajout',
        component : AjoutDemandeComponent
    },
    {
      path: '**',
      redirectTo: '',
      pathMatch: 'full',
    }
];

export const Routing = RouterModule.forRoot(APP_ROUTES);
