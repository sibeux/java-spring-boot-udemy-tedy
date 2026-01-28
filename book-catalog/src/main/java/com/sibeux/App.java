package com.sibeux;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sibeux.config.AppConfig;
import com.sibeux.domain.Author;
import com.sibeux.domain.Book;
import com.sibeux.service.AuthService;
import com.sibeux.service.EmailService;
import com.sibeux.service.impl.EmailServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        // XML based configuration
        try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "application-context.xml")) {
            Author author = (Author) appContext.getBean("author");
            System.out.println("Id: " + author.getId() + " Name: " + author.getName());

            // Multiple bean with same class
            Author author2 = (Author) appContext.getBean("author2");
            System.out.println("Id: " + author2.getId() + " Name: " + author2.getName());

            Book book = (Book) appContext.getBean("book");
            System.out.println("Title: " + book.getTitle() + ". Author: " + book.getAuthor().getName());

            // Multiple bean with same class
            Book book2 = (Book) appContext.getBean("book2");
            System.out.println("Title: " + book2.getTitle() + ". Author: " + book2.getAuthor().getName());

            // EmailServiceImpl emailService = (EmailServiceImpl)
            // appContext.getBean("emailService");
            // emailService.sendMail("test@gmail.com", "Your OTP", "Your OTP is 123456");

            // AuthService authService = (AuthService) appContext.getBean("authService");
            // authService.login("test@gmail.com");
        } catch (BeansException e) {
            e.printStackTrace();
        }

        // Java based configuration
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // Author 1
            Author author = (Author) appContext.getBean("author1");
            System.out.println("Id: " + author.getId() + " Name: " + author.getName());

            // Book 1
            Book book = (Book) appContext.getBean("book1");
            System.out.println("Title: " + book.getTitle() + ". Author: " + book.getAuthor().getName());

            // Book 2
            Book book2 = (Book) appContext.getBean("book2");
            System.out.println("Title: " + book2.getTitle() + ". Author: " + book2.getAuthor().getName());

            // Email Service
            EmailService emailService = (EmailService) appContext.getBean("emailService");
            // emailService.sendMail("test@gmail.com", "Your OTP", "Your OTP is 123456");

            // Auth Service
            AuthService authService = (AuthService) appContext.getBean("authService");
            authService.login("test@jujutsu.com");
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
