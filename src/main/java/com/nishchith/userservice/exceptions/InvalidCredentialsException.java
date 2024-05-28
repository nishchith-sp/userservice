package com.nishchith.userservice.exceptions;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String s) {
        super(s);
    }
}
