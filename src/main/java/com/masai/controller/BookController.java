package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BookController {
    @Autowired
	public BookService bsrvice;
    
    @PostMapping("/bookservice")
    public ResponseEntity<Book> SaveBook(@RequestBody Book book){
    	Book bk=bsrvice.SaveBook(book);
    	return new ResponseEntity<Book>(book,HttpStatus.OK);
    }
    
    @DeleteMapping("/bookservice/{id}")
    public ResponseEntity<String> delateBook(@PathVariable Integer id) throws BookException{
    	
    	String result=bsrvice.DelateBook(id);
    	return  new ResponseEntity<String>(result,HttpStatus.OK);
    	
    }
    
    @GetMapping("/bookservice/books")
    public ResponseEntity<List<Book>> getAllBook() throws BookException{
    	
    	List<Book> books=bsrvice.getAllInformation();
    	
    	return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
    }
    @GetMapping("/bookservice/{id}")
    public ResponseEntity<Book> findInformationById(@PathVariable Integer id) throws BookException{
    	
    	Book book=bsrvice.getInformationofParticularbook(id);
    	return new ResponseEntity<Book>(book,HttpStatus.OK);
    	
    	
    }
    
    @PutMapping("/bookservice/books")
    public ResponseEntity<Book> UpdateBook(@RequestBody Book book) throws BookException{
    	Book bk=bsrvice.UpdatateBook(book);
    	return new ResponseEntity<Book>(bk,HttpStatus.OK);
    }
}
