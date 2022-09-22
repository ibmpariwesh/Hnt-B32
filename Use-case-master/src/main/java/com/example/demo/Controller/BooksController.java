package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.IBookrepo;
import com.example.demo.Services.BookService;
import com.example.demo.Services.Paymentservice;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/auth") 
public class BooksController {  
	 
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private IBookrepo repo;
	
	@PreAuthorize("hasRole('ROLE_AUTHOR')")

	@PostMapping("/createbook")
	public String  newbook(@RequestBody Book book)
	{
		bookservice.savebook(book);
		return "Book is created succsefully";
		
	}
	
	@PreAuthorize("hasRole('ROLE_AUTHOR')")

	@PutMapping("/updatebook/{bookid}")
	public Book updatebook(@RequestBody Book book, @PathVariable("bookid") Long bookid)
	{
		book.setBookID(bookid);
		bookservice.updateBookService(book);
		return book;
		
	}
//	@GetMapping("/searchbook/{byauthor}")
//	public  Book getbyauthor(@RequestBody Book book,@PathVariable("byauthor") String author)
//	{
//		book.setAuthor(author);
//		
//		Book bk=new Book();
//		bk.getBookID();
//		bk.getAuthor();
//        bk.getTitle();
//        bk.getPublisher();
//        bk.getReleaseDate();
//        bk.getCategory();
//        bk.getPrice();
//        bk.getContent();
//        
//		
//        repo.findByAuthor(author);
//		return bk;
//	}
	@PreAuthorize("hasRole('ROLE_READER')")
    @GetMapping("/searcbycategory/{category}")
	public List<Book> searchbooks(@PathVariable String category)
	{
		
		return bookservice.getbycategory(category);
		
		
		
	}
	@PreAuthorize("hasRole('ROLE_READER')")

	@GetMapping("/searchbook/{price}")
	public List<Book> searchbooksby(@PathVariable Double price)
	{
		return bookservice.price(price);
				
	}
	@PreAuthorize("hasRole('ROLE_READER')")

	@GetMapping("/getallbooks")
	public List<Book> allbooks()
	{
		return bookservice.allbooks();
	}
	@PreAuthorize("hasRole('ROLE_READER')")

	@GetMapping("/searchbyauthor/{author}")
	public List<Book> searchbooksbyauthor(@PathVariable String author)
	{
		return bookservice.byauthor(author);
				
	}
	@PreAuthorize("hasRole('READER')")
    @GetMapping("/searchBooks")
    @ResponseBody
    public ResponseEntity<Map<String, String>> SearchBooks(@RequestParam String catagory,@RequestParam String author,@RequestParam Double price,@RequestParam String publisher) throws JsonProcessingException {
        
        List<Book>BooksList=bookservice.findByCatagoryAndAuthorAndPriceAndPublisher(catagory, author, price, publisher);
            Map<String,String>result = new HashMap<>();
            BooksList.forEach(Book->{
                result.put("author",Book.getAuthor());
                result.put("catagory",Book.getCatagory());
                result.put("publishedDate",Book.getReleaseDate());
                result.put("publisher",Book.getPublisher());
                result.put("title",Book.getTitle());
                result.put("price",String.valueOf(Book.getPrice()));
                
            });
            ResponseEntity<Map<String, String>> responseEntity = new ResponseEntity(result , HttpStatus.OK);
        return responseEntity;
        }
	    @PreAuthorize("hasRole('READER')")

	    @GetMapping("/readbookbyid/{bookid}")
	    public Optional<Book> readbookbyid(@PathVariable("bookid") Long bookid)
	    {
	     return	bookservice.byid(bookid);
	    }
	    

	    
	
	
	
	
	

}
