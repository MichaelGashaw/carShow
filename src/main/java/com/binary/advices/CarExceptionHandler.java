package com.binary.advices;


import com.binary.exceptions.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CarExceptionHandler extends RuntimeException{

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {CarNotFoundException.class})
    public ResponseEntity<Object> handleCarNotFoundException(CarNotFoundException carNotFoundException){

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("Message ", carNotFoundException.getMessage());
        errorMap.put("TimeStamp ", new Date().toString());
        errorMap.put("httpStatus ", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handelMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> errorMap = new HashMap<>();


        methodArgumentNotValidException.getFieldErrors().forEach(error -> {
                errorMap.put (error.getField(), error.getDefaultMessage());
    });
        errorMap.put("TimeStamp ", new Date().toString());
        errorMap.put("httpStatus ", HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}