package com.sibeux.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sibeux.service.AuthService;
import com.sibeux.service.EmailService;

@Service
public class AuthServiceImpl implements AuthService {

    private final EmailService emailService;

    // @Qualifier("emailDummyServiceImpl") digunakan untuk memberitahu bean mana
    // yang akan digunakan.
    public AuthServiceImpl(@Qualifier("emailDummyServiceImpl") EmailService emailService) {
        super();
        this.emailService = emailService;
    }

    @Override
    public Boolean login(String email) throws Exception {
        emailService.sendMail(email, "Your OTP", "123456");
        return null;
    }

    @Override
    public Boolean confirmOTP(String sessionId, String otp) {
        return null;
    }

}
