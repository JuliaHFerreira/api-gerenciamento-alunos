package com.consumption.crud.exceptions.handlers;

import com.consumption.crud.exceptions.DadoJaCadastradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConstumizacaoHandlerException {

    @ExceptionHandler(DadoJaCadastradoException.class)
    public ResponseEntity<String> handleDadoJaCadastradoException (DadoJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
