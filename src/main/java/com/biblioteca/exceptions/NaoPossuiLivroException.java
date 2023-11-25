package com.biblioteca.exceptions;

public class NaoPossuiLivroException extends RuntimeException{
    public NaoPossuiLivroException(String message){
        super(message);
    }
}
