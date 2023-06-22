import { Component } from '@angular/core';
import { empty } from 'rxjs';
import { User } from 'src/app/entity/User';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user: User = new User();

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    
  }

  register(){
    this.user.address = null as any;
    this.user.shoppingCart = null as any;
    this.user.payments = null as any;
    this.userService.createUser(this.user).subscribe();
    console.log(this.user);
  }
}
