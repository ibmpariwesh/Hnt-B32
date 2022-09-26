import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})
export class FormsComponent implements OnInit {
  user = {
    username : "author1",
    password : "testing123"
  }

  save(){
    const observable = this.userService.createUser(this.user);
    observable.subscribe(
      (response:any) => {
        console.log(response);
        sessionStorage.setItem('credentials', JSON.stringify(response));
        this.router.navigate(['']);
      },function(error) {
        console.log("Something went worng" , error);
        
      }
    )
  }
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

}
