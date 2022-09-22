import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = {
    username: "pariwesh",
    password: "12345",
    email:'pariwesh@gmail.com'
  }
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
  signup() {
    const observable: Observable<any> = this.userService.signup(this.user);
    observable.subscribe(
      response =>{//success function
        console.log(response);
      },

      error=>{
        console.log(error);
        
      }

    )
  }
}
