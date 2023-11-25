package com.biblioteca;

import com.biblioteca.entities.*;


public class App 
{
    public static void main( String[] args ) {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario();

        Livro livro1 = new LivroFisico("Head First Java", "2023","Katie Sierra", "Fisico",2);

        biblioteca.adicionarLivro(livro1);

        System.out.println(biblioteca.getLivros());

        usuario.pegarLivro(livro1, usuario);

        System.out.println(usuario.getLivrosEmPosse());
    }

}
