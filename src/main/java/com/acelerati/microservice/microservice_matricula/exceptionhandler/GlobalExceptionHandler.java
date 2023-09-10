package com.acelerati.microservice.microservice_matricula.exceptionhandler;

import com.acelerati.microservice.microservice_matricula.domain.exception.CourseUniqueGroupSemesterException;
import com.acelerati.microservice.microservice_matricula.domain.exception.DateTimeException;
import com.acelerati.microservice.microservice_matricula.domain.exception.MaxTimeTablesException;
import com.acelerati.microservice.microservice_matricula.domain.exception.ResourceNotFoundException;
import com.acelerati.microservice.microservice_matricula.domain.exception.TimeInvalidExeption;
import com.acelerati.microservice.microservice_matricula.exceptionhandler.response.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException exception, WebRequest request){
        String message = String.format("%s, %s",exception.getMessage(),"the user haven't the permission necessary that realize this action");

        ErrorDetails res = new ErrorDetails(LocalDate.now(), message, request.getDescription(false));

        return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<ErrorDetails> handleDateTimeException(DateTimeException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseUniqueGroupSemesterException.class)
    public ResponseEntity<ErrorDetails> handleCourseUniqueGroupSemesterException(CourseUniqueGroupSemesterException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MaxTimeTablesException.class)
    public ResponseEntity<ErrorDetails> handleMaxTimeTablesException(MaxTimeTablesException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TimeInvalidExeption.class)
    public ResponseEntity<ErrorDetails> handleTimeInvalidExeption(TimeInvalidExeption ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField()+":"+fieldError.getDefaultMessage()).collect(Collectors.joining(", "));

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),message , request.getDescription(false));


        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
}
