import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  BASE_URL = "http://localhost:8010/api/auth/";
  signup(user: any) {
      return this.http.post(this.BASE_URL+'signup', user);

  }

  createUser(user:any) {
    return this.http.post(this.BASE_URL+'signin', user);
  }

  constructor(private http: HttpClient) { }
}
