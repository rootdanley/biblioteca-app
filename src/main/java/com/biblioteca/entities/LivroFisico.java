package com.biblioteca.entities;

public class LivroFisico extends Livro {

    private Integer copiasDisponiveis;


    public LivroFisico() {
        super();
    }

    public LivroFisico(String titulo, String anoPublicacao, String autor, Integer copiasDisponiveis) {
        super(titulo, anoPublicacao, autor);
        this.copiasDisponiveis = copiasDisponiveis;
    }


    public Integer getCopiasDisponiveis() {
        return copiasDisponiveis;
    }

    public void setCopiasDisponiveis(Integer copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }

    public void emprestarLivro() {
        this.copiasDisponiveis += - 1;
    }

    public void devolverLivro() {
        this.copiasDisponiveis += + 1;
    }


}
