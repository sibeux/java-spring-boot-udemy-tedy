package com.sibeux.service;

import com.sibeux.domain.Author;
import com.sibeux.domain.Book;

public class BookService {
    public BookService() {
        super();
        Author author = new Author();
        Book book = new Book(author);    
    }
}
