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
            System.out.println(author.getId());
            System.out.println(author.getName());

            Book book = (Book) appContext.getBean("book");
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor().getName());
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
