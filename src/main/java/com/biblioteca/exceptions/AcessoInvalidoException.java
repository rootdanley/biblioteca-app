package com.biblioteca.exceptions;

public class AcessoInvalidoException extends RuntimeException{
    public AcessoInvalidoException(String msg){
        super(msg);
    }
}
