package com.biblioteca.entities;

import com.biblioteca.exceptions.LimiteExcedidoException;
import com.biblioteca.exceptions.LivroInexistenteException;

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
    public void pegarLivro(LivroFisico l) {

        super.pegarLivro(l);

        if (livrosEmPosse.size() > 5) {
            throw new LimiteExcedidoException("Limite de 5 livros atingidos para alunos.");
        }
    }

    @Override
    public String toString() {
       return new StringBuilder(super.toString())
           .append(", Matricula=").append(matricula)
           .append(" }")
           .toString();
    }





}


