import { Component, OnInit } from '@angular/core';
import { User } from './entity/User';
import { UserService } from './service/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Product } from './entity/Product';
import { ProductService } from './service/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}