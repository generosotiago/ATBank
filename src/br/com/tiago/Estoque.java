package br.com.tiago;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("""
                    --- Esse é seu controle de estoque, selecione uma opção: --- 
                                    
                    1 - Adicionar produto
                    2 - Buscar produto
                    3 - Editar produto
                    4 - Remover produto
                    5 - Relatório estoque
                    6 - Sair do sistema\n""");
            int opcao = ler.nextInt();


            switch (opcao){
                case 1:
                    Funcoes.adicionar();
                    break;
                case 2:
                    Funcoes.buscarProduto();
                    break;
                case 3:
                    Funcoes.editarProduto();
                    break;
                case 4:
                    Funcoes.removerProduto();
                    break;
                case 5:
                    Funcoes.mostrarProdutos();
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("### OPÇÃO INVÁLIDA DIGITE UM NÚMERO CORRETO ###\n");

            }
        } while (true);
    }
}
