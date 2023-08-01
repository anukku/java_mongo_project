package com.shopAPI.refreshME.other;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
        super("Passwords do not match");
    }

}