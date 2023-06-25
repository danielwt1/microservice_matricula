package com.acelerati.microservice.microservice_matricula.domain.exception;

public class TimeInvalidExeption extends RuntimeException{
    public TimeInvalidExeption(String message) {
        super(message);
    }
}
