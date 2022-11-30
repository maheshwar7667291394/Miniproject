package com.masai.service;

import java.util.List;

import com.masai.exception.BookException;
import com.masai.model.Book;

public interface BookService {
	 public Book SaveBook(Book book);
	 public String DelateBook(Integer id)throws BookException;
	 
	 public List<Book> getAllInformation() throws BookException;
	 
	 public Book getInformationofParticularbook(Integer id)throws BookException;
	 
	 public Book UpdatateBook(Book book)throws BookException;
}
