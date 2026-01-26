package com.sibeux.service;

public interface EmailService {
    public void sendMail(String destinationAddress, String mailSubject, String messageContent) throws Exception;
}
