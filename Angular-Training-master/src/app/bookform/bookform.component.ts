import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.css']
})
export class BookformComponent implements OnInit {
  book = {
    title:"Learn angular"
  }
  constructor(private bookService : BookService) { }
  save(){
    console.log('saved');
    const observable= this.bookService.saveBook(this.book);
    observable.subscribe(response=>{
      console.log(response);
      
    })
  }

  ngOnInit(): void {
  }

} 
