package com.biblioteca.exceptions;

public class LivroInexistenteException extends RuntimeException{
    public LivroInexistenteException(String message){
        super(message);
    }
}
