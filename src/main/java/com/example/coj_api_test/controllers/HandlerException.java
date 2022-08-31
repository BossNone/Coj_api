package com.example.coj_api_test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Request doest not exist"
)
public class HandlerException extends RuntimeException {
    public HandlerException(Throwable t){
        super(t);
    }
}
