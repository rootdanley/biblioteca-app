package com.biblioteca.entities;
import java.util.ArrayList;
import java.util.List;


public class Biblioteca{
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(){ };


    public void cadastrarUsuario(Usuario user) {
        usuarios.add(user);
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
        return null;
    }


    public void realizarEmprestimo(Usuario user, Livro livro){ }

    public void devolverEmprestimo(Usuario user, Livro livro){ }
    
    
}
