package com.biblioteca.entities;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String Nome;
    private List<LivroFisico> LivrosEmprestados = new ArrayList<>();
    private List<LivroDigital> LivrosBaixados = new ArrayList<>();
    private List<LivroFisico> LivrosEmPosse = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void pegarLivro(LivroFisico livro) { }

    public void devolverLivro(LivroFisico livro) { }

    public void baixarLivro(LivroDigital livro) {
       LivrosBaixados.add(livro);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("Nome='").append(Nome).append('\'');
        sb.append(", LivrosEmprestados=").append(LivrosEmprestados);
        sb.append(", LivrosBaixados=").append(LivrosBaixados);
        sb.append(", LivrosEmPosse=").append(LivrosEmPosse);
        sb.append('}');
        return sb.toString();
    }
}
