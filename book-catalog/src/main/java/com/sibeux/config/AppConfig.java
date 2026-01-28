package com.sibeux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sibeux.domain.Author;
import com.sibeux.domain.Book;

@Configuration
public class AppConfig {

    @Bean
    public Author author1() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Itadori Yuji");
        return author;
    }

    @Bean
    public Book book1(Author author1) {
        Book book = new Book("Jujutsu Kaisen", author1);
        return book;
    }

}
