package com.consumption.crud.exceptions;

public class DocumentoInvalidoException extends IllegalArgumentException {
    public DocumentoInvalidoException(String message) {
        super(message);
    }
}
