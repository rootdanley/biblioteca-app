package com.biblioteca.entities;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<LivroFisico> LivrosEmprestados = new ArrayList<>();
    private List<LivroDigital> LivrosBaixados = new ArrayList<>();
    private List<LivroFisico> LivrosEmPosse = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void pegarLivro(LivroFisico livro) { }

    public void devolverLivro(LivroFisico livro) { }

    public void baixarLivro(LivroDigital livro) {
       LivrosBaixados.add(livro);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("Nome='").append(nome).append('\'');
        sb.append(", LivrosEmprestados=").append(LivrosEmprestados);
        sb.append(", LivrosBaixados=").append(LivrosBaixados);
        sb.append(", LivrosEmPosse=").append(LivrosEmPosse);
        sb.append('}');
        return sb.toString();
    }
}
