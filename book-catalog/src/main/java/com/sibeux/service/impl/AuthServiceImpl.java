package com.sibeux.service.impl;

import com.sibeux.service.AuthService;
import com.sibeux.service.EmailService;

public class AuthServiceImpl implements AuthService {

    private final EmailService emailService;

    public AuthServiceImpl(EmailService emailService) {
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
        throw new UnsupportedOperationException("Unimplemented method 'confirmOTP'");
    }

}
