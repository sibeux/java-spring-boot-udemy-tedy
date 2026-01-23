package com.sibeux;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sibeux.domain.Author;
import com.sibeux.domain.Book;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
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
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
