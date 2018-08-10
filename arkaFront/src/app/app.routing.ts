// app.routing.ts
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';


const APP_ROUTES: Routes = [
    {
        path: '',
        component: HomeComponent,

    },
    {
        path: 'login',
        component: LoginComponent,
        pathMatch: 'full',
    },
    {
      path: '**',
      redirectTo: '',
      pathMatch: 'full',
    }
];

export const Routing = RouterModule.forRoot(APP_ROUTES);
