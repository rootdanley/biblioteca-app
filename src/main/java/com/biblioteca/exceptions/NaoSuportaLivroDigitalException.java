package com.biblioteca.exceptions;

public class NaoSuportaLivroDigitalException extends RuntimeException{
    public NaoSuportaLivroDigitalException(String message){
        super(message);
    }
}
