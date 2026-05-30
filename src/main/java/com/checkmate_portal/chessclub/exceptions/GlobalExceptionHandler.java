package com.checkmate_portal.chessclub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.sun.tools.javac.jvm.ByteCodes.error;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex){
         Map<String,String> errors=new HashMap<>();
         ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));

         Map<String,Object> response = new HashMap<>();
         response.put("message","validation failed");
         response.put("error",errors);

         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
