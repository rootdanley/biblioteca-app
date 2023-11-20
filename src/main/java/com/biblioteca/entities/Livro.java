package com.biblioteca.entities;

public abstract class Livro {
    private String titulo;
    private String anoPublicacao;
    private String autor;

    public Livro() {
    }

    public Livro(String titulo, String anoPublicacao, String autor) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
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
        final StringBuilder sb = new StringBuilder("Livro{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", anoPublicacao='").append(anoPublicacao).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
