package com.biblioteca.exceptions;

public class LivroJaExisteException extends RuntimeException{
    public LivroJaExisteException(String  message){
        super(message);
    }
}
