package com.biblioteca.entities;

import com.biblioteca.entities.enums.tipoDeLivro;

public class LivroFisico extends Livro {

    private Integer copiasDisponiveis;


    public LivroFisico() {
        super();
    }

    public LivroFisico(String titulo, String anoPublicacao, String autor, tipoDeLivro tipo, Integer copiasDisponiveis) {
        super(titulo, anoPublicacao, autor, tipo);
        this.copiasDisponiveis = copiasDisponiveis;
    }

    public Integer getCopiasDisponiveis() {
        return copiasDisponiveis;
    }

    public void setCopiasDisponiveis(Integer copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }

    public void emprestarLivroBiblioteca() {
        this.copiasDisponiveis += - 1;
    }

    public void devolverLivroBiblioteca() {
        this.copiasDisponiveis += + 1;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
            .append("', copias disponiveis='").append(copiasDisponiveis)
            .append("'")
            .toString();
    }
}
