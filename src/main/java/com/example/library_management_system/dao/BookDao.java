package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.entity.Address;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.repository.BookRepository;

@Repository
public class BookDao {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
         bookRepository.save(book);
         return book;
    }

    /*public Book updateBook(int id,Book book) {
    	Optional<Book>findById=bookRepository.findById(id);
		if(findById.isPresent()) {
			book.setBookId(book.getBookId());
			bookRepository.save(findById.get());
		}
		return findById.get();
    }*/

    public Book getBookById(int id) {
    	Optional<Book>optional=bookRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
    }

    public Book updateBook(int id, Book book) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            book.setBookId(id); 
            return bookRepository.save(book);
        }
        return null;
    }

  
}
