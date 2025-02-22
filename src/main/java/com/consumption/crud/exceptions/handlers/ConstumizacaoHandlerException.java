package com.consumption.crud.exceptions.handlers;

import com.consumption.crud.exceptions.DocumentoInvalidoException;
import com.consumption.crud.exceptions.DadoJaCadastradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ConstumizacaoHandlerException {

    @ExceptionHandler(DadoJaCadastradoException.class)
    public ResponseEntity<String> handleDadoJaCadastradoException (DadoJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DocumentoInvalidoException.class)
    public ResponseEntity<String> handleDocumentoInvalidoException (DocumentoInvalidoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

     @ExceptionHandler(Exception.class) // 🔹 Captura QUALQUER erro inesperado (500)
    public ResponseEntity<Map<String, String>> handleInternalServerError(Exception ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Erro interno no servidor.");
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
