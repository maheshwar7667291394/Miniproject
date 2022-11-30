package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.BookDao;
import com.masai.exception.BookException;
import com.masai.model.Book;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	public BookDao bdao;

	@Override
	public Book SaveBook(Book book) {
		Book bk=bdao.save(book);
		return bk;
		
	}



	@Override
	public String DelateBook(Integer id) throws BookException {
		Optional<Book> bk=bdao.findById(id);
		if(bk.isEmpty()) {
			throw new BookException("Book no present");
		}
		bdao.deleteById(id);
		return "delation successfull";
	}

	@Override
	public List<Book> getAllInformation() throws BookException {
		List<Book> books=bdao.findAll();
		if(books.size()==0) {
			throw new BookException("no any book present");
		}
		return books;
	}



	@Override
	public Book getInformationofParticularbook(Integer id) throws BookException {
		Optional<Book> book=bdao.findById(id);
		Book bk=book.get();
		if(bk==null) {
			throw new BookException("no any book present");
		}
		return bk;
	}



	@Override
	public Book UpdatateBook(Book book) throws BookException {
		Optional<Book> bk=bdao.findById(book.getBookid());
		if(bk.isEmpty()) {
			throw new BookException("no any book present");
		}
		
		Book bo=bdao.save(book);
		return bo;
		
	}

}
