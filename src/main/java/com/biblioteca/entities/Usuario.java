package com.biblioteca.entities;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<LivroFisico> livrosEmprestados = new ArrayList<>();
    private List<LivroDigital> livrosBaixados = new ArrayList<>();
    private List<LivroFisico> livrosEmPosse = new ArrayList<>();

    static Integer escolha;

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

    public void pegarLivro(LivroFisico livro) {
        Biblioteca b = new Biblioteca();
         System.out.println("---------------------------------------------------------");
         System.out.println("> Aqui estao todos os livros registrados na biblioteca: ");
         System.out.println("---------------------------------------------------------");
        b.livrosDisponiveis();

    }

    public void devolverLivro(LivroFisico livro) { }

    public void baixarLivro(LivroDigital livro) {
       livrosBaixados.add(livro);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("Nome='").append(nome).append('\'');
        sb.append(", LivrosEmprestados=").append(livrosEmprestados);
        sb.append(", LivrosBaixados=").append(livrosBaixados);
        sb.append(", LivrosEmPosse=").append(livrosEmPosse);
        sb.append('}');
        return sb.toString();
    }
}
