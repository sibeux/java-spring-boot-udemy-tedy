package com.sibeux;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            new EmailService("sandbox.smtp.mailtrap.io", 2525, "0074f8da91b4d9", "94f41de68e4e30").sendMail();
            System.out.println("send");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}