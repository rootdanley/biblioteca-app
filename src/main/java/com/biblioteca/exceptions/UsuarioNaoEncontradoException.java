package com.biblioteca.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
  public UsuarioNaoEncontradoException(String message){
    super(message);
  }
}
