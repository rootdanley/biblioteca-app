package com.biblioteca;

import com.biblioteca.entities.*;
import com.biblioteca.exceptions.*;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario();
        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);

        Livro livro1 = new LivroFisico("Head First Java", "2023","Katie Sierra", "Fisico",2);
        Livro livro2 = new LivroFisico("Java", "2023","Katie Sierra", "Fisico",2);
        Livro livro3 = new LivroFisico("EXtreme Go Horse", "2016", "Mario Marolo", "Fisico", 3);
        Livro livro4 = new LivroDigital("Codigo Limpo","2009","Robert C Martin","Digital","PDF",65100.0,"https://github.com/free-educa/books/blob/main/books/Codigo%20Limpo%20-%20Completo%20PT.pdf");
        Livro livro5 = new LivroDigital("Calculo", "2006","James Stewart", "Digital","PDF",24000.0,"https://tsxvpsbr.dyndns.org/arquivos/UFFS/James%20Stewart%20-%205%C2%AA%20Edi%C3%A7%C3%A3o%20-%20Vol.1.pdf");
        Livro livro6 = new LivroDigital("Algoritmos e Programação 1","2017","Ivo Mario Martins","Digital","PDF",3645.4,"https://educapes.capes.gov.br/bitstream/capes/176223/2/Algoritmos%20e%20Programa%C3%A7%C3%A3o%20I%20EBOOK.pdf");

        Usuario user1 = new Aluno("Danley Alves",100);
        Usuario user2 = new Professor("Carlos",12);


        biblioteca.cadastrarUsuario(user1);
        biblioteca.cadastrarUsuario(user2);

        Scanner sc = new Scanner(System.in);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);
        biblioteca.adicionarLivro(livro6);


        try {

            System.out.println("Qual nivel de acesso (1) Aluno | (2) Professor | (3) Bibliotecario: ");
            int nivelAcesso = sc.nextInt();

            int opcao = 0;
            Integer id = null;

             if (nivelAcesso == 1){
                        System.out.println(("Aluno, Digite sua matricula: "));
                        id = scanner.nextInt();

                    } else if (nivelAcesso == 2) {
                        System.out.println(("Professor, Digite seu código: "));
                        id = scanner.nextInt();
                    }

                    Usuario user = biblioteca.Autenticar(id);

            do {

                if(nivelAcesso == 1 || nivelAcesso == 2){
                    System.out.print("O que deseja realizar? (1) Pegar Livro | (2) Devolver Livro | (3) Baixar Livro | (0) Sair do programa ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao){
                        case 1:
                                System.out.println("LIVROS DISPONIVEIS:");
                                biblioteca.livrosDisponiveis();

                                System.out.println("Deseja pegar qual livro? Digite o titulo:");
                                String titulo = sc.nextLine();

                                LivroFisico tes = biblioteca.teste(titulo);
                                user.pegarLivro(tes);

                                System.out.println("LIVROS EM POSSE:");
                                System.out.println(user.getLivrosEmPosse());
                        case 2:


                        }



                } else if(nivelAcesso == 3){
                    System.out.print("O que deseja realizar? (1) Buscaro Usuario | (2) ?? | (3) ??| (0) Sair do programa ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao){
                        case 1:
                                System.out.println("Digite o id:");

                                id = sc.nextInt();


                                System.out.println(biblioteca.buscarUsuario(id));
                        case 2:


                        }

                }

            }while (opcao != 0);

        } catch (AcessoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (LimiteExcedidoException e) {
            System.out.println(e.getMessage());
        } catch (LivroInexistenteException e){
            System.out.println(e.getMessage());
        } catch (LivroJaExisteException e){
            System.out.println(e.getMessage());
        } catch (NaoPossuiLivroException e){
            System.out.println(e.getMessage());
        } catch (NaoSuportaLivroDigitalException e){
            System.out.println(e.getMessage());
        } catch (UsuarioJaExistenteException e) {
            System.out.println(e.getMessage());
        } catch (UsuarioNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("fim do programa");
        }
    }

}
