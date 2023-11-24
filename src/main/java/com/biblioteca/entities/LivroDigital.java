package com.biblioteca.entities;

public class LivroDigital extends Livro{
    private String formato;
    private Double tamanho;
    private String url;


    public LivroDigital() {
        super();
    }

    public LivroDigital(String titulo, String anoPublicacao, String autor, String tipo, String formato, Double tamanho,
                        String url) {
        super(titulo, anoPublicacao, autor, tipo);
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

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
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
        return new StringBuilder(super.toString())
            .append("', Formato='").append(formato)
            .append("', Tamanho='").append(tamanho)
            .append("', url='").append(url)
            .append("'")
            .toString();
    }
}
