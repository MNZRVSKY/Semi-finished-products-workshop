package com.your.choice.brigadeservice.exception;

public class UserNotFoundExcetion extends RuntimeException{
    public UserNotFoundExcetion(String message) {
        super(message);
    }
}
