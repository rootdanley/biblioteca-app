package com.biblioteca.entities;

public class LivroDigital extends Livro{
    private String formato;
    private Integer tamanho;
    private String url;


    public LivroDigital() {
        super();
    }

    public LivroDigital(String titulo, String anoPublicacao, String autor, String formato, Integer tamanho, String url) {
        super(titulo, anoPublicacao, autor);
        this.formato = formato;
        this.tamanho = tamanho;
        this.url = url;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String baixarLivro(){
        return this.getTitulo();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LivroDigital[");
        sb.append("titulo='").append(getTitulo()).append('\'');;
        sb.append(", Ano de Publicacao='").append(getAnoPublicacao()).append('\'');;
        sb.append(", Autor: ").append(getAutor()).append('\'');;
        sb.append(", formato='").append(formato).append('\'');
        sb.append(", tamanho=").append(tamanho);
        sb.append(", url='").append(url).append('\'');
        sb.append(']');
        return sb.toString();
    }
}
