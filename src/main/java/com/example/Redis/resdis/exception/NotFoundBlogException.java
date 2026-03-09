package com.example.Redis.resdis.exception;

public class NotFoundBlogException extends RuntimeException {
    public NotFoundBlogException(String message) {
        super(message);
    }
}
