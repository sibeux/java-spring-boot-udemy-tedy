package com.sibeux.config;

import org.springframework.beans.factory.annotation.Qualifier;
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
    public Author author2() {
        Author author = new Author();
        author.setId(2L);
        author.setName("Uzumaki Naruto");
        return author;
    }

    @Bean
    // Fungsi @Qualifier adalah untuk memberitahu bean mana yang akan digunakan.
    // Jika tidak ada @Qualifier, make akan terjadi error karena ada 2 bean dengan
    // class yang sama.
    public Book book1(@Qualifier("author1") Author author1) {
        Book book = new Book("Jujutsu Kaisen", author1);
        return book;
    }

    @Bean
    public Book book2(@Qualifier("author2") Author author2) {
        Book book = new Book("Naruto Shippuden", author2);
        return book;
    }

}
