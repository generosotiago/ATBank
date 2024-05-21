package br.com.tiago;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    public static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("|   C O N T R O L E    D E    E S T O Q U E   |\n\n" +
                "" +
                "Pressione ENTER para prosseguir...");
        String a = ler.nextLine();
        do {
            System.out.println(""" 
                     Selecione a operação desejada:
                    ================================
                    | 1 - CADASTRAR PRODUTO        |
                    | 2 - BUSCAR PRODUTO           |
                    | 3 - EDITAR PRODUTO           |
                    | 4 - REMOVER PRODUTO          |
                    | 5 - RELATÓRIO DE ESTOQUE     |
                    | 6 - SAIR DO SISTEMA          |
                    ================================""");
            int opcao = ler.nextInt();


            switch (opcao) {
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
