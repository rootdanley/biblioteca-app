package com.biblioteca.entities;

public class Aluno extends Usuario{
    private Integer Matricula;

    public Aluno() {
        super();
    }

    public Aluno(String nome, Integer matricula) {
        super(nome);
        this.Matricula = matricula;
    }


    public Integer getMatricula() {
        return this.Matricula;
    }

    public void setMatricula(Integer matricula) {
        this.Matricula = matricula;
    }

    @Override
    public String toString() {
       return new StringBuilder(super.toString())
       .append(", Matricula=").append(Matricula)
       .toString();
    }
}


