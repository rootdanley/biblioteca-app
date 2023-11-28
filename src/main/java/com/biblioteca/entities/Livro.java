package com.biblioteca.entities;

import com.biblioteca.entities.enums.tipoDeLivro;

public class Livro{
    private String titulo;
    private String anoPublicacao;
    private String autor;
    private tipoDeLivro tipo;

    public Livro() {
    }

    public Livro(String titulo, String anoPublicacao, String autor, tipoDeLivro tipo) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livro: ");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", anoPublicacao='").append(anoPublicacao).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", tipo='").append(tipo);
        return sb.toString();
    }



}
