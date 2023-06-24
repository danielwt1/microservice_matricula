package com.acelerati.microservice.microservice_matricula.domain.exception;

public class DayOfWeekNotFoundException extends RuntimeException{
    public DayOfWeekNotFoundException(String message) {
        super(message);
    }
}
