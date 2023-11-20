package com.biblioteca;

import com.biblioteca.exceptions.AcessoInvalidoException;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
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
    }
}
