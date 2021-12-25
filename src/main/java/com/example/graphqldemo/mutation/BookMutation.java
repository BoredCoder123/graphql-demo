package com.example.graphqldemo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqldemo.entity.Book;
import com.example.graphqldemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    private BookService bookService;

    public Book addBook(Book book){
        return bookService.addBook(book);
    }

    public Book updateBook(Book book) throws Exception{
        try {
            return bookService.updateBook(book);
        }
        catch(Exception e){
            throw new Exception("unable to update book");
        }
    }

    public String deleteBook(String isn) throws Exception{
        try{
            return bookService.deleteBook(isn);
        }
        catch(Exception e){
            throw new Exception("unable to find book");
        }
    }
}
