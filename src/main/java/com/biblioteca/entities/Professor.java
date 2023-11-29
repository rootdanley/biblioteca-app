package com.biblioteca.entities;


public class Professor extends Usuario{
    private Integer codigo;

    public Professor() {
        super();
    }

    public Professor(String nome, Integer codigo) {
        super(nome);
        this.codigo = codigo;
    }

    public Integer getCodigo() {
      return codigo;
    }

    public void setCodigo(Integer codigo) {
      this.codigo = codigo;
    }
    

    @Override
    public String toString() {
      return new StringBuilder(super.toString())
          .append(", Codigo=").append(codigo)
          .append(" }")
          .toString();
    }

}
