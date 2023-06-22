import { Routes } from "@angular/router";
import { LoginComponent } from "./ngComponents/login/login.component";
import { NavbarNotLogedInComponent } from "./ngComponents/navbar-not-loged-in/navbar-not-loged-in.component";
import { ShopComponent } from "./ngComponents/shop/shop.component";
import { RegisterComponent } from "./ngComponents/register/register.component";

export const APP_ROUTES: Routes = [

    {
        path:"",
        redirectTo:"shop",
        pathMatch:"full"
    },
    {
        path:"shop",
        component: ShopComponent
    },
    {
        path:"login",
        component: LoginComponent
    },
    {
        path:"navbar-not-loged-in",
        component: NavbarNotLogedInComponent
    },
    {
        path:"register",
        component: RegisterComponent
    }

]