package com.example.graphqldemo.service;

import com.example.graphqldemo.entity.Book;
import com.example.graphqldemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(String isn){
        Optional<Book> returnedBook = bookRepository.findById(isn);
        if(returnedBook.isPresent()) {
            return returnedBook.get();
        }
        return null;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) throws Exception, IllegalArgumentException{
        Optional<Book> returnedBook = bookRepository.findById(book.getIsn());
        if(returnedBook.isPresent()) {
            return bookRepository.save(book);
        }
        throw new Exception("Book not present");
    }
}
