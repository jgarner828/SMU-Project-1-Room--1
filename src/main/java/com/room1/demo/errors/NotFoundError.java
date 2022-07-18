package com.room1.demo.errors;

public class NotFoundError extends RuntimeException{
    public NotFoundError() {
        super();
    }

    public NotFoundError(String msg) {
        super(msg);
    }
}
