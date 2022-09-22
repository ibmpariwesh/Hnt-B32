package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.IBookrepo;

@Service
public class BookService { 
  
	@Autowired
	private IBookrepo bookrepo;
	
	public Book savebook(Book book)
	{
		bookrepo.save(book);
		return book;
	}

	public Book updateBookService(Book book) {
		return bookrepo.save(book);
	
		
	}

	public List<Book> getbycategory(String category) {
		List<Book> book=bookrepo.findByCatagory(category);
		
		return book;
	}
	public List<Book> price(Double price)
	{
		List<Book> book=bookrepo.findByPrice(price);
		return book;
	}
	public List<Book> allbooks()
	{
		List<Book> book=bookrepo.findAll();
		return book;
	}
	public List<Book> byauthor(String author)
	{
		List<Book> book=bookrepo.findByAuthor(author);
		return book;
	}
	public List<Book> findByCatagoryAndAuthorAndPriceAndPublisher(String catagory, String author, Double price,
            String publisher) {
        return bookrepo.findByCatagoryAndAuthorAndPriceAndPublisher( catagory,  author,  price,
                 publisher);
    }

	public Optional<Book> byid(Long bookid) {
		
		return bookrepo.findById(bookid);
	}

	

	

}
