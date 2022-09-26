import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FormsComponent } from './forms/forms.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './signup/signup.component'
import { Route, RouterModule } from '@angular/router';
import { SearchBookComponent } from './search-book/search-book.component';

const routes: Route[] = [
  { path: 'search', component: SearchBookComponent },
  { path: '', component: SearchBookComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'signin', component: FormsComponent }

];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FormsComponent,
    SignupComponent,
    SearchBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
