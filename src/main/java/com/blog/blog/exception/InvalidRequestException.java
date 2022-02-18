package com.blog.blog.exception;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message + " Invalid Request");
    }
}
