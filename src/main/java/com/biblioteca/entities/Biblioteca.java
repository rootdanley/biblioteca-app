package com.biblioteca.entities;
import com.biblioteca.exceptions.*;
import com.biblioteca.services.AutenticacaoService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Biblioteca{
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private AutenticacaoService autenticacaoService;



    public Biblioteca() {
        this.autenticacaoService = new AutenticacaoService(usuarios);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }



  public void cadastrarUsuario(Usuario u) {
    for (Usuario user : usuarios) {
        if (user instanceof Aluno && u instanceof Aluno && ((Aluno) user).getMatricula() == ((Aluno) u).getMatricula()) {
            throw new UsuarioJaExistenteException("Aluno já existe no sistema");
        } else if (user instanceof Professor && u instanceof Professor && ((Professor) user).getCodigo() == ((Professor) u).getCodigo()) {
            throw new UsuarioJaExistenteException("Professor já existe no sistema");
        }
    }

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

        if(resultadoDaBusca.isEmpty()){
            System.out.println("Veja se escreveu certo");
        }

        return resultadoDaBusca;
    }


public LivroFisico verificaLivroFisico(String titulo) {
    for (Livro livs : livros) {
        if (livs instanceof LivroFisico && ((LivroFisico) livs).getTitulo().equalsIgnoreCase(titulo)) {
            return (LivroFisico) livs;
        }
    }

    throw new LivroInexistenteException("Livro físico não encontrado com o título: " + titulo);
}


public LivroDigital verificaLivroDigital(String titulo) {
        for(Livro livs : livros) {
            if(livs instanceof LivroDigital && ((LivroDigital) livs).getTitulo().equalsIgnoreCase(titulo)){
                return (LivroDigital) livs;
            }
        }

        throw new LivroInexistenteException("Livro digital não encontrado com o título: " + titulo);
}


    public Usuario buscarUsuario (Integer id){
        for(Usuario usuario : usuarios){

            if(usuario instanceof Aluno && ((Aluno) usuario).getMatricula() == id){
                return usuario;
            }else if(usuario instanceof Professor && ((Professor) usuario).getCodigo() == id) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException("Usuario com ID: " + id + "não encontrado");
    }

    public void adicionarLivro(Livro l) {

        for (Livro livs : livros) {
            if ((livs instanceof LivroDigital || livs instanceof LivroFisico) &&
                    livs.getTitulo().equals(((Livro) l).getTitulo())) {

                throw new LivroJaExisteException("Livro ja existe no sistema");
            }
        }

      livros.add(l);
    }


    public List<Livro> removerLivro(String titulo) {
        List<Livro> removerLivro = new ArrayList<>();
        boolean achou = false;
        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                removerLivro.add(livro);
                System.out.println("Livro " + titulo + " removido com sucesso!");
                achou = true;
            }
        }

        if(!achou) {
            throw new LivroInexistenteException("Livro não existe: " + titulo);
        }


        livros.removeAll(removerLivro);
        return removerLivro;
    }



    public void realizarEmprestimo(Usuario user, LivroFisico livro){
        user.pegarLivro(livro);
    }

    public void devolverEmprestimo(Usuario user, LivroFisico livro){
        user.devolverLivro(livro);
    }


    public Usuario autenticarUsuario(Integer id) {
        return autenticacaoService.autenticarUsuario(id);
    }

    public void livrosDisponiveis() {
        for(Livro livro : livros){
            System.out.println(livro);
        }

    }
    
    
}
