package com.sibeux.service;

public interface AuthService {
    public Boolean login(String email) throws Exception;

    public Boolean confirmOTP(String sessionId, String otp) throws Exception;
}
