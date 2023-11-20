package com.biblioteca.entities;

public class Aluno extends Usuario{
    private Integer matricula;

    public Aluno() {
        super();
    }

    public Aluno(String nome, Integer matricula) {
        super(nome);
        this.matricula = matricula;
    }


    public Integer getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
       return new StringBuilder(super.toString())
       .append(", Matricula=").append(matricula)
       .toString();
    }
}


