package com.biblioteca.entities;

public class LivroFisico extends Livro {

    private Integer CopiasDisponiveis;


    public LivroFisico() {
        super();
    }

    public LivroFisico(String titulo, String anoPublicacao, String autor, Integer copiasDisponiveis) {
        super(titulo, anoPublicacao, autor);
        CopiasDisponiveis = copiasDisponiveis;
    }


    public Integer getCopiasDisponiveis() {
        return CopiasDisponiveis;
    }

    public void setCopiasDisponiveis(Integer copiasDisponiveis) {
        CopiasDisponiveis = copiasDisponiveis;
    }

    public void emprestarLivro() {
        this.CopiasDisponiveis = this.CopiasDisponiveis - 1;
    }

    public void devolverLivro() {
        this.CopiasDisponiveis = this.CopiasDisponiveis + 1;
    }


}
