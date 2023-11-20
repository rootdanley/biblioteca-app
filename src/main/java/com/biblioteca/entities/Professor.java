package com.biblioteca.entities;


public class Professor extends Usuario{
    private Integer Codigo;

    public Professor() {
        super();
    }

    public Professor(String nome, Integer codigo) {
        super(nome);
        Codigo = codigo;
    }

    public Integer getCodigo() {
      return Codigo;
    }

    public void setCodigo(Integer codigo) {
      Codigo = codigo;
    }
    

    @Override
    public String toString() {
      return new StringBuilder(super.toString())
        .append(", Codigo=").append(Codigo)
        .toString();
    }

   
    
}
