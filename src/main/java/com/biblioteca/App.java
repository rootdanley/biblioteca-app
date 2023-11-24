package com.biblioteca;

import com.biblioteca.entities.*;


public class App 
{
    public static void main( String[] args ) {


    Biblioteca b = new Biblioteca();

    b.adicionarLivro(new LivroFisico("Java", "2223","maria","Fisico",2));
    b.adicionarLivro(new LivroFisico("Head First Java", "2023","Katie Sierra","Fisico",4));

    b.adicionarLivro(new LivroDigital("Javascript", "2023", "carlos", "Digital", "pdf", 23.0, "www.google.com"));


        b.livrosDisponiveis();



        System.out.println();

        b.removerLivro("Head First Java");
        b.livrosDisponiveis();
      /*
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual seu nivel de acesso? [prf - Professor] | [aln - Aluno] | [blt - Bibliotecario] | [Sair - Fechar Sistema]: ");
        String nivelDeAcesso = sc.nextLine().toLowerCase();

        int opcao = 0;
       
       do {
             try {
              if ("prf".equals(nivelDeAcesso) || "aln".equals(nivelDeAcesso)) {
                  System.out.print("O que deseja realizar? (1) Pegar Livro | (2) Devolver Livro | (3) Baixar Livro: ");
                  opcao = sc.nextInt();

              } else if ("blt".equals(nivelDeAcesso)) {
                  System.out.print("O que deseja realizar? (1) Cadastrar Usuário | (2) Buscar Livro | (3) Realizar Emprestimo | (4) Devolver Emprestimo | (5) Buscar Usuário: ");
                  opcao = sc.nextInt();

              } else if ("sair".equals(nivelDeAcesso)){
                System.out.println("Saindo...");
              } else {
                  throw new AcessoInvalidoException("Acesso Invalido!");
              }
      
             } catch (AcessoInvalidoException e) {
              System.out.println(e.getMessage());
             }
      
       } while(opcao != 0);

       */
    }
}
