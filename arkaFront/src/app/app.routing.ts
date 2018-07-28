// app.routing.ts
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';


const APP_ROUTES: Routes = [
    {
        path: 'home',
        component: AppComponent,

    },
    {
        path: '',
        component: LoginComponent
    },
    {
      path: '**',
      redirectTo: '/home',
      pathMatch: 'full',
    }
];

export const Routing = RouterModule.forRoot(APP_ROUTES);
