package com.example.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.entity.Book;
import com.example.graphqldemo.repository.BookRepository;
import com.example.graphqldemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksQuery implements GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public String firstQuery(){
        return "First query";
    }

    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    public Book getBook(String isn){
        return bookService.getBook(isn);
    }
}
