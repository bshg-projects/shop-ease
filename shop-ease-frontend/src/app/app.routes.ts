import { Routes } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { authGuard } from "src/app/controller/auth/auth.guard";
import { DashboardComponent } from 'src/app/view/pages/dashboard/dashboard.component';
import { LoginComponent } from 'src/app/view/pages/login/login.component';
import { NotFoundComponent } from 'src/app/view/pages/error-pages/not-found/not-found.component';
import { AccessDeniedComponent } from 'src/app/view/pages/error-pages/access-denied/access-denied.component';

export const routes: Routes = [
    {path: "", component: AppComponent},
    {path: "dashboard", canActivate: [authGuard], component: DashboardComponent},
    {path: "login", component: LoginComponent},
    {path: "access-denied", component: AccessDeniedComponent},
    {path: "not-found", component: NotFoundComponent},
    {path: "**", redirectTo: "not-found"}
];
