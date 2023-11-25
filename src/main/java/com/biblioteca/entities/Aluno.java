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
    public String toString() {
       return new StringBuilder(super.toString())
       .append(", Matricula=").append(matricula)
       .toString();
    }
    public boolean podePegar(){
        return getLivrosEmPosse().size() < 5;
    }
    public void pegarLivro(LivroFisico livro){
        if(podePegar()) {
        }else{
            throw new LimiteExcedidoException("Error: Limite de Livros Excedido");
        }
        if (livro instanceof LivroFisico) {
            LivroFisico livroPego = (LivroFisico) livro;
            livrosEmPosse.add(livroPego);
            livrosEmprestados.add(livroPego);
        }
        else{
            throw new LivroInexistenteException("Error: Livro Não Encontrado");
        }

    }

}


