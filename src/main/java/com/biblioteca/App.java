package com.biblioteca;

import com.biblioteca.entities.*;
import com.biblioteca.exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.biblioteca.entities.enums.tipoDeLivro.DIGITAL;
import static com.biblioteca.entities.enums.tipoDeLivro.FISICO;


public class App 
{
    public static void main( String[] args ) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new LivroFisico("Head First Java", "2023","Katie Sierra", FISICO,2);
        Livro livro7 = new LivroFisico("Clean Code", "2008", "Robert C. Martin", FISICO, 3);
        Livro livro8 = new LivroFisico("Code Complete", "1993", "Steve McConnell", FISICO, 1);
        Livro livro9 = new LivroFisico("The Art of Computer Programming", "1968", "Donald E. Knuth", FISICO, 5);
        Livro livro10 = new LivroFisico("Effective Java", "2017", "Joshua Bloch", FISICO, 4);

        Livro livro2 = new LivroFisico("Java", "2023","Katie Sierra", FISICO,2);
        Livro livro3 = new LivroFisico("EXtreme Go Horse", "2016", "Mario Marolo", FISICO, 3);
        Livro livro4 = new LivroDigital("Codigo Limpo","2009","Robert C Martin",DIGITAL,"PDF",65100.0,"https://github" +
            ".com/free-educa/books/blob/main/books/Codigo%20Limpo%20-%20Completo%20PT.pdf");
        Livro livro5 = new LivroDigital("Calculo", "2006","James Stewart", DIGITAL,"PDF",24000.0,"https://tsxvpsbr" +
            ".dyndns.org/arquivos/UFFS/James%20Stewart%20-%205%C2%AA%20Edi%C3%A7%C3%A3o%20-%20Vol.1.pdf");
        Livro livro6 = new LivroDigital("Algoritmos e Programação 1","2017","Ivo Mario Martins",DIGITAL,"PDF",3645.4,
            "https://educapes.capes.gov.br/bitstream/capes/176223/2/Algoritmos%20e%20Programa%C3%A7%C3%A3o%20I%20EBOOK.pdf");

        Usuario user1 = new Aluno("Danley Alves",100);
        Usuario user2 = new Professor("Carlos",12);




        biblioteca.cadastrarUsuario(user1);
        biblioteca.cadastrarUsuario(user2);

        user2.pegarLivro((LivroFisico) livro2);

        Scanner sc = new Scanner(System.in);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);
        biblioteca.adicionarLivro(livro6);
        biblioteca.adicionarLivro(livro7);
        biblioteca.adicionarLivro(livro8);
        biblioteca.adicionarLivro(livro9);
        biblioteca.adicionarLivro(livro10);


        String titulo;
        Integer id = null;

        try {

            System.out.println("Qual nivel de acesso (1) Aluno | (2) Professor | (3) Bibliotecario: ");
            int nivelAcesso = sc.nextInt();

            int opcao = 0;


            if (nivelAcesso == 1){
                System.out.println(("Aluno, Digite sua matricula: "));
                id = sc.nextInt();

            } else if(nivelAcesso == 2) {
                System.out.println(("Professor, Digite seu código: "));
                id = sc.nextInt();
            } else {
              System.out.println("Bem vindo, bibliotecario!");
            }



            do {

                if(nivelAcesso == 1 || nivelAcesso == 2){


                    Usuario user = biblioteca.autenticarUsuario(id);



                    System.out.print("O que deseja realizar? (1) Pegar Livro Emprestado | (2) Ver Livros " +
                        "| (3) " +
                        "Baixar Livro | (4) Devolver Livro | (5) Ver Livros em posse | (6) Ver Livros Baixados | (0) " +
                        "Sair do programa : " +
                        " ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao){
                      case 1:
                              System.out.println();
                              System.out.println("LIVROS DISPONIVEIS:");
                              biblioteca.livrosDisponiveis();
                              System.out.println();

                              System.out.print("Deseja pegar qual livro? Digite o titulo:");
                              titulo = sc.nextLine();

                              LivroFisico tes = biblioteca.verificaLivroFisico(titulo);
                              user.pegarLivro(tes);
                              System.out.println();
                              System.out.println("LIVROS EM POSSE:");
                              System.out.println(user.getLivrosEmPosse());
                              break;
                      case 2:
                              System.out.println();
                              System.out.println("LIVROS DISPONIVEIS:");
                              biblioteca.livrosDisponiveis();
                              System.out.println();
                              break;
                      case 3:
                              System.out.println();
                              System.out.print("Deseja baixar qual livro? Digite o titulo:");
                              titulo = sc.nextLine();
                              LivroDigital dig  = biblioteca.verificaLivroDigital(titulo);
                              user.baixarLivro(dig);
                              System.out.println();
                              break;
                      case 4:
                              System.out.println();
                              System.out.print("Qual livro deseja devolver? Digite o titulo: ");
                              titulo = sc.nextLine();
                              tes = biblioteca.verificaLivroFisico(titulo);
                              user.devolverLivro(tes);
                              System.out.println("Livro devolvido");
                              System.out.println();
                              biblioteca.livrosDisponiveis();
                              break;
                      case 5:
                        System.out.println();
                        System.out.println(user.getLivrosEmPosse());


                        break;
                      case 6:
                        System.out.println();
                        System.out.println(user.getLivrosBaixados());
                        break;

                    }



                } else if(nivelAcesso == 3){
                    System.out.print("O que deseja realizar? (1) Buscaro Usuario | (2) Cadastrar Livro | (3) Buscar " +
                        "Livro | (4) Ver Livros | (5) Remover Livro | (6) Associar Autor a livro | " +
                        "(7) Emprestar Livro | (8) Devolver Livro | (9) Exibir Usuarios | " +
                        "(0) " +
                        "Sair do " +
                        "programa: ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao){
                      case 1:
                              System.out.println("Digite o id:");
                              id = sc.nextInt();

                              System.out.println(biblioteca.buscarUsuario(id));
                              System.out.println();
                              break;
                      case 2:
                            System.out.print("Qual tipo de livro quer cadastrar: (1) Fisico | (2) Digital ? ");
                            int tipoLivro = sc.nextInt();


                            sc.nextLine();
                            if (tipoLivro == 1){
                              System.out.print("Titulo: ");
                              titulo = sc.nextLine();
                              System.out.print("Ano de Publicação:");
                              String ano = sc.nextLine();
                              System.out.print("Autor: ");
                              String autor = sc.nextLine();
                              System.out.print("Copias disponiveis: ");
                              int copias = sc.nextInt();


                              biblioteca.adicionarLivro(new LivroFisico(titulo,ano,autor,FISICO, copias));
                              System.out.println("Livro cadastrado com sucesso!");
                              break;

                            }else if (tipoLivro == 2){
                              System.out.print("Titulo: ");
                              titulo = sc.nextLine();
                              System.out.print("Ano de Publicação: ");
                              String ano = sc.nextLine();
                              System.out.print("Autor: ");
                              String autor = sc.nextLine();
                              System.out.print("Formato (extensao do livro): ");
                              String formato = sc.nextLine();
                              System.out.print("Tamanho do livro digital: ");
                              double tamanho = sc.nextDouble();
                              sc.nextLine();
                              System.out.print("URL do livro: ");
                              String url = sc.nextLine();


                              biblioteca.adicionarLivro(new LivroDigital(titulo,ano,autor,DIGITAL,formato,tamanho,
                                  url));
                              System.out.println("Livro cadastrado com sucesso!");
                              break;
                            }
                      case 3:
                              System.out.println();
                              System.out.println("Digite o titulo do livro:");
                              titulo = sc.nextLine();

                              System.out.println(biblioteca.buscarLivro(titulo));
                              System.out.println();

                              break;
                      case 4:
                              System.out.println();
                              System.out.println("LIVROS DISPONIVEIS:");
                              biblioteca.livrosDisponiveis();
                              System.out.println();
                              break;
                      case 5: // corrigir logica do metodo remover livro
                                System.out.println();
                                System.out.print("Digite o titulo do livro para remover: ");
                                titulo = sc.nextLine();
                                System.out.println(biblioteca.removerLivro(titulo));

                                System.out.println();
                                break;
                      case 6:

                        System.out.println("Digite o titulo do livro: ");
                        titulo = sc.nextLine();

                        System.out.print("Digite o novo autor: ");
                        String autor = sc.nextLine();

                        LivroFisico livs = biblioteca.verificaLivroFisico(titulo);
                        livs.setAutor(autor);

                        System.out.println("ALTERAÇÃO FEITA");
                        System.out.println(biblioteca.buscarLivro(titulo));

                        break;
                      case 7:
                        // logica de emprestrar livro
                        System.out.print("Digite o id do usuario: ");
                        int idUsuario = sc.nextInt();

                        sc.nextLine();
                        System.out.print("Digite o titulo do livro: ");
                        titulo = sc.nextLine();


                        LivroFisico liv = biblioteca.verificaLivroFisico(titulo);
                        Usuario user = biblioteca.buscarUsuario(idUsuario);

                        biblioteca.realizarEmprestimo(user,liv);
                        System.out.println("Livro emprestado!");

                        break;
                      case 8:
                        System.out.print("Digite o id do usuario: ");
                        idUsuario = sc.nextInt();

                        sc.nextLine();
                        System.out.println("Digite o titulo do livro: ");
                        titulo = sc.nextLine();

                        liv = biblioteca.verificaLivroFisico(titulo);
                        user = biblioteca.buscarUsuario(idUsuario);

                        biblioteca.devolverEmprestimo(user,liv);
                        System.out.println("Livro devolvido!");


                        break;
                      case 9:
                        System.out.println();
                        System.out.println(biblioteca.getUsuarios());

                        break;

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
        } catch (InputMismatchException e) {
          System.out.println("Tipo de dado invalido!");
        } finally {
            System.out.println("Programa Encerrado");
        }
    }

}
