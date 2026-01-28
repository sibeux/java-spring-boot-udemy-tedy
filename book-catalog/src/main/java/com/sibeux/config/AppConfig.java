package com.sibeux.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sibeux.domain.Author;
import com.sibeux.domain.Book;
import com.sibeux.service.EmailService;
import com.sibeux.service.impl.EmailServiceImpl;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

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

    @Bean
    public Properties mailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", 2525);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.starttls.enable", true);
        return props;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("0074f8da91b4d9", "94f41de68e4e30");
    }

    @Bean
    // Mengapa perlu @Qualifier? Karena ada 2 bean dengan class Properties.
    // Satu adalah mailProperties dan satu lagi adalah default properties:
    // systemProperties
    public Session mailSession(@Qualifier("mailProperties") Properties mailProperties,
            PasswordAuthentication passwordAuthentication) {
        return Session.getInstance(mailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }

    @Bean
    public EmailService emailService(Session mailSession) {
        return new EmailServiceImpl(mailSession);
    }
}
