package com.example.library_management_system.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.entity.Book;
import com.example.library_management_system.service.BookService;
import com.example.library_management_system.util.ResponseStructure;
@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private BookService bookService;

    
    /*{
    	"title":"harrypotter",
    	"author":"jk.rowling"
    }*/
    @PostMapping
    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{bookId}/{libraryId}")
    public ResponseEntity<ResponseStructure<Book>> addBookToLibrary(@PathVariable int bookId,@PathVariable int libraryId) {
        return bookService.addBookToLibrary(bookId,libraryId);
    }

    @PutMapping("/{userId}/{bookId}")
    public ResponseEntity<ResponseStructure<Book>> borrowBook(@PathVariable int userId,@PathVariable int bookId) {
        return bookService.borrowBook(userId,bookId);
    }
    
    @PutMapping("/return/{bookId}")
    public ResponseEntity<ResponseStructure<Book>> returnBook(@PathVariable int bookId) {
        return bookService.returnBook(bookId);
    }

    
}
