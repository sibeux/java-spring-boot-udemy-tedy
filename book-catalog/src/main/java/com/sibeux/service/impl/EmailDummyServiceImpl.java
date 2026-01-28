package com.sibeux.service.impl;

import org.springframework.stereotype.Service;

import com.sibeux.service.EmailService;

@Service
public class EmailDummyServiceImpl implements EmailService {

    @Override
    public void sendMail(String destinationAddress, String mailSubject, String messageContent) throws Exception {
        System.out.println("Destination address=" + destinationAddress);
        System.out.println("Mail subject=" + mailSubject);
        System.out.println("Message content=" + messageContent);
    }

}
