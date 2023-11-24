package com.biblioteca.entities;
import java.util.ArrayList;
import java.util.List;


public class Biblioteca{
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(){ };


    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }



    public List<Livro> buscarLivro(String titulo) {
        List<Livro> resultadoDaBusca = new ArrayList<>();

        if(!livros.isEmpty()) {
            for (Livro l : livros) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    resultadoDaBusca.add(l);
                }
            }
        }
        return resultadoDaBusca;
    }

    public Usuario buscarUsuario (int id){
        for(Usuario usuario : usuarios){
            if(usuario instanceof Aluno && ((Aluno) usuario).getMatricula() == id){
                return usuario;
            }else if(usuario instanceof Professor && ((Professor) usuario).getCodigo() == id) {
                return usuario;
            }
        }
        return null; // falta criar a excecao caso nao ache o usuario
    }

    public void adicionarLivro(Livro l) {
        this.livros.add(l);
    }


    public void removerLivro(String titulo) {
        List<Livro> removerLivro = new ArrayList<>();

        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                removerLivro.add(livro);
            }
        }
        livros.removeAll(removerLivro);
    }

    public void realizarEmprestimo(Usuario user, Livro livro){
        List<Livro> realizarEmprestimo = new ArrayList<>();

    }

    public void devolverEmprestimo(Usuario user, Livro livro){ }


    public void livrosDisponiveis() {
        for(Livro livro : livros){
            System.out.println(livro);
        }

    }
    
    
}
