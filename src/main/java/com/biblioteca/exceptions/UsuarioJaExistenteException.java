package com.biblioteca.exceptions;

public class UsuarioJaExistenteException extends RuntimeException{
    public UsuarioJaExistenteException(String message){
        super(message);
    }
}
