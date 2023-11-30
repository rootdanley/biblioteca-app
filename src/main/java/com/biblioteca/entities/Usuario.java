package com.biblioteca.entities;
import com.biblioteca.exceptions.LimiteExcedidoException;
import com.biblioteca.exceptions.LivroInexistenteException;
import com.biblioteca.exceptions.NaoSuportaLivroDigitalException;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    protected List<LivroFisico> livrosEmprestados = new ArrayList<>();//historico do usario
    private List<LivroDigital> livrosBaixados = new ArrayList<>();
    protected List<LivroFisico> livrosEmPosse = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public List<LivroDigital> getLivrosBaixados() {
        return livrosBaixados;
    }

    public List<LivroFisico> getLivrosEmPosse() {
        if(livrosEmPosse.isEmpty()){
            throw new LivroInexistenteException("Não tem livros");
        }

        return livrosEmPosse;
    }
    public List<LivroFisico> getLivrosEmprestados() {
        if(livrosEmPosse.isEmpty()){
            throw new LivroInexistenteException("Não tem livros");
        }
        return livrosEmprestados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void pegarLivro(LivroFisico l){
        if(livrosEmPosse.contains(l)){
            throw new LimiteExcedidoException("Não é possivel pegar o mesmo livro duas vezes!");
        }
        else {
            livrosEmPosse.add(l);
            livrosEmprestados.add(l);
            l.emprestarLivroBiblioteca();
        }
    }


    public void devolverLivro(LivroFisico livro) {
        if(livro != null) {

          livrosEmPosse.remove(livro);
          (livro).devolverLivroBiblioteca();

        }
        else {
            throw new NaoSuportaLivroDigitalException("Error: Não suporta a devolução de Livro Digital");
        }
    }

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
        return sb.toString();
    }

}
