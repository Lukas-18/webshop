import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/entity/Product';
import { User } from 'src/app/entity/User';
import { ProductService } from 'src/app/service/product.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  // variable holds all our users whenever we get them back
  public users: User[] | undefined;
  public products: Product[] | undefined;

  constructor(private userService: UserService, private productService: ProductService) {}

  ngOnInit(): void {
    this.getUsers();
    this.getProducts();
  }

  public getUsers(): void {
    this.userService.getAllUsers().subscribe(
      (response: User[]) => {
      this.users = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getProducts(): void {
    this.productService.getAllProducts().subscribe(
      (response: Product[]) => {
      this.products = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
