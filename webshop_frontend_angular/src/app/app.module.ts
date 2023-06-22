import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { ShopComponent } from './ngComponents/shop/shop.component';
import { LoginComponent } from './ngComponents/login/login.component';
import { NavbarNotLogedInComponent } from './ngComponents/navbar-not-loged-in/navbar-not-loged-in.component';
import { FormsModule } from '@angular/forms';

import {RouterModule} from "@angular/router";
import {APP_ROUTES} from "./app.routes";
import { RegisterComponent } from './ngComponents/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    LoginComponent,
    NavbarNotLogedInComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(APP_ROUTES),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
