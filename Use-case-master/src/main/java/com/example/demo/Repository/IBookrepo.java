package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Book;


public interface IBookrepo extends JpaRepository<Book, Long> {

	 public List<Book>  findByCatagory(String category);
	 public List<Book>  findByPrice(Double price);
     public List<Book> findByPublisher(String publisher);	 
	 public List<Book> findAll();
	 public List<Book> findByAuthor(String author);
 List<Book> findByCatagoryAndAuthorAndPriceAndPublisher(String catagory, String author, Double price, String publisher);
	 
	


}
