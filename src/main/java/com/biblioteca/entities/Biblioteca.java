package com.biblioteca.entities;
import com.biblioteca.exceptions.*;

import java.util.ArrayList;
import java.util.List;


public class Biblioteca{
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(){ };

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }



    public void cadastrarUsuario(Usuario u) {
        boolean usuarioJaExiste = false;

        for (Usuario user : usuarios) {
            if (user instanceof Aluno && ((Aluno) user).getMatricula() == ((Aluno) u).getMatricula()) {
                usuarioJaExiste = true;
                throw new UsuarioJaExistenteException("Usuario já existe no sistema");
            }
        }

        usuarios.add(u);
        System.out.println("Usuário adicionado com sucesso.");
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


    public LivroFisico teste(String titulo) throws IllegalAccessException {

        for (Livro livs : livros){
            if (livs instanceof LivroFisico && ((LivroFisico) livs).getTitulo().equals(titulo)){
                return (LivroFisico) livs;
            } else {
                throw new IllegalAccessException("nao e fisico");
            }
        }

        return null;
    }


    public Usuario buscarUsuario (int id){
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
        boolean livroJaExiste = false;
        for (Livro livs : livros) {
            if ((livs instanceof LivroDigital || livs instanceof LivroFisico) &&
                    livs.getTitulo().equals(((Livro) l).getTitulo())) {
                livroJaExiste = true;
                throw new LivroJaExisteException("Livro ja existe no sistema");
            }
        }
        if(!livroJaExiste){
            livros.add(l);
            System.out.println("Livro adicionado com sucesso");
        }
    }


    public void removerLivro(String titulo) {
        List<Livro> removerLivro = new ArrayList<>();

        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                removerLivro.add(livro);
            }else{
                throw new LivroInexistenteException("Livro : " + titulo + " não encontrado");
            }
        }

        livros.removeAll(removerLivro);
    }

    public void realizarEmprestimo(Usuario user, Livro livro){

    }

    public void devolverEmprestimo(Usuario user, Livro livro){
      if(livro instanceof LivroFisico){
          LivroFisico livroDevolver = (LivroFisico) livro;

          Usuario usuarioEncontrado = null;
          for(Usuario usuario : usuarios){
              if(usuario.equals(user)){
                  usuarioEncontrado = usuario;
                  break;
              }
          }

          if(usuarioEncontrado == null){
              throw new UsuarioNaoEncontradoException("Usuario com não encontrado");
          }

          if(usuarioEncontrado.getLivrosEmPosse().contains(livroDevolver)){
              usuarioEncontrado.devolverLivro(livroDevolver);
          } else {
              throw new NaoPossuiLivroException("Usuario não possui o livro");
          }

      }
      else {
          throw new NaoSuportaLivroDigitalException("Devolução de Livro Digital não suportada.");
      }

    }


    


    public Usuario Autenticar(Integer id){

        Usuario usuarioAutenticado = null;
        for (Usuario users : usuarios){
            if (users instanceof Aluno && ((Aluno) users).getMatricula() == id){
                usuarioAutenticado = users;
                return usuarioAutenticado;
            }
            else if (users instanceof Professor && ((Professor) users).getCodigo() == id){
                usuarioAutenticado = users;
                return usuarioAutenticado;
            }
        }


        if(usuarioAutenticado == null){
            throw new UsuarioNaoEncontradoException("Nao existe");

        }

        return null;
    }

    public void livrosDisponiveis() {
        for(Livro livro : livros){
            System.out.println(livro);
        }

    }
    
    
}
