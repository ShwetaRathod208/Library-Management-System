package com.example.library_management_system.service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.BookDao;
import com.example.library_management_system.dao.LibraryDao;
import com.example.library_management_system.dao.UserDao;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.entity.Library;
import com.example.library_management_system.entity.User;
import com.example.library_management_system.util.ResponseStructure;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private LibraryDao libraryDao;
    
    @Autowired
    private UserDao userDao;
    
    
    public ResponseEntity<ResponseStructure<Book>>saveBook(Book book) {
        Book saved = bookDao.saveBook(book);
        ResponseStructure<Book> response = new ResponseStructure<>();
        
        response.setData(saved);
        response.setMessage("Book Saved");
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Book>>(response,HttpStatus.OK);
    }

    
    public ResponseEntity<ResponseStructure<Book>> addBookToLibrary(int bookId,int libraryId){
    	
		//finding library by id
    	Library libraryById=libraryDao.getLibraryById(libraryId);
    	//in that library getting old list of books if any
    	List<Book>allBooksInLibrary=libraryById.getBooks();
    	//finding book by id
    	Book bookById=bookDao.getBookById(bookId);
    	///adding new book to old list
    	allBooksInLibrary.add(bookById);
    	//updating library
    	libraryDao.updateLibrary(libraryById);
    	
        ResponseStructure<Book> response = new ResponseStructure<>();
        
        response.setData(bookById);
        response.setMessage("Book added to library successfully");
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Book>>(response,HttpStatus.OK);
    }
    	
    
    public ResponseEntity<ResponseStructure<Book>>borrowBook(int userId,int bookId) {
        	User user=userDao.getUserById(userId);
        	Book book=bookDao.getBookById(bookId);
        	
        	if(user!=null && book!=null &&!book.isBorrowed()) {
        		book.setBorrowed(true);
        		book.setUser(user);
        		book.setBorrowedTime(LocalDateTime.now());
        		bookDao.updateBook(bookId,book);
        		ResponseStructure<Book>responseStructure=new ResponseStructure<>();
        		
        		responseStructure.setData(book);
        		responseStructure.setMessage("Book borrowed successfully");
        		responseStructure.setStatusCode(HttpStatus.OK.value());
        		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
        	}
        	else {
        		 ResponseStructure<Book>responseStructure=new ResponseStructure<>();
        		 
        		 responseStructure.setData(null);
        		 responseStructure.setMessage("Book unable to borrow");
        		 responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        		 return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.BAD_REQUEST); 
        	}
        	
        }
    
   /* public ResponseEntity<ResponseStructure<Book>>returnBook(int bookId) {
    	/*
    	 * fetch book using bookid
    	 * book.setUser(null)
    	 * setBorrowed(false)
    	 * setReturnTime()
    	 * updateBook
    	 */
    	
    public ResponseEntity<ResponseStructure<Book>> returnBook(int bookId) {
        Book book = bookDao.getBookById(bookId);

        if (book != null && book.isBorrowed()) {
            book.setUser(null);
            book.setBorrowed(false);
            book.setReturnTime(LocalDateTime.now());
            Book updatedBook = bookDao.updateBook(bookId, book);

            ResponseStructure<Book> response = new ResponseStructure<>();
            response.setData(updatedBook);
            response.setMessage("Book returned successfully");
            response.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Book>>(response,HttpStatus.OK);
        } else {
            ResponseStructure<Book> response = new ResponseStructure<>();
            response.setData(null);
            response.setMessage("Book is not borrowed or doesn't exist");
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<ResponseStructure<Book>>(response,HttpStatus.BAD_REQUEST); 
        }
    }


   
}