import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})
export class FormsComponent implements OnInit {
  user = {
    userName : "",
    password : ""
  }

  save(){
    const observable = this.userService.createUser(this.user);
    observable.subscribe(
      (response:any) => {
        console.log(response);
      },function(error) {
        console.log("Something went worng" , error);
        
      }
    )
  }
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
