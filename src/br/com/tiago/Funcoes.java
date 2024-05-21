package br.com.tiago;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner ler = new Scanner(System.in);


    public static void adicionar() {
        Produto produtoNew = new Produto();
        int id;

        System.out.println("| Digite o ID do produto que deseja Cadastrar: |\n");
        id = ler.nextInt();

        while (verificarID(id)) {
            System.out.println("| ID já existe. Por favor, insira um ID único: |");
            id = ler.nextInt();
        }

        produtoNew.id = id;
        ler.nextLine();
        System.out.println("\n| Digite o nome do produto: |\n");
        produtoNew.nome = ler.nextLine();

        System.out.println("| Digite a quantidade: |\n");
        produtoNew.quantidade = ler.nextInt();

        System.out.println("| Digite o valor do produto: |\n");
        produtoNew.valor = ler.nextDouble();

        produtos.add(produtoNew);
        System.out.println("""
                \n Produto cadastrado com sucesso!
                                
                  - Escolha a próxima operação: -
                ==================================
                | 1 - Voltar ao Menu             |
                | 2 - Cadastrar outro produto    |
                ==================================
                """);
        while (true) {
            int addOption = ler.nextInt();
            switch (addOption) {
                case 1:
                    return;
                case 2:
                    adicionar();
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }
    }


    public static void buscarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("| Não existem produtos cadastrados |");
            return;
        }

        while (true) {
            System.out.println("| Digite o ID do produto: |\n");
            int id = ler.nextInt();
            boolean produtoEncontrado = false;
            for (Produto produto : produtos) {
                if (produto.id == id) {
                    produtoEncontrado = true;
                    System.out.println("| PRODUTO ENCONTRADO: " + produto.nome + "|\n" +
                            "| QUANTIDADE EM ESTOQUE:  " + produto.quantidade + "|");
                    System.out.println("""
                              - Escolha a próxima operação: -
                            ==================================
                            | 1 - Voltar ao Menu             |
                            | 2 - Buscar outro produto       |
                            ==================================
                            """);
                    while (true) {
                        int addOption = ler.nextInt();
                        switch (addOption) {
                            case 1:
                                return;
                            case 2:
                                buscarProduto();
                                return;
                            default:
                                System.out.println("Digite uma opcao valida");
                                break;
                        }
                    }

                }
            }
            if (!produtoEncontrado){
                    System.out.println("| Produto não encontrado |");
                    return;
            }
        }

    }


    public static void editarProduto() {
        System.out.println("Digite o ID do produto: ");
        int id = ler.nextInt();
        for (Produto produto : produtos) {
            if (produto.id == id) {
                System.out.println("Informe o novo nome: ");
                ler.nextLine();
                produto.nome = ler.nextLine();
                System.out.println("Informe a nova quantidade: ");
                produto.quantidade = ler.nextInt();
                System.out.println("Informe o novo valor: ");
                produto.valor = ler.nextDouble();
                System.out.println("""
                        \n Produto EDITADO com sucesso!
                                        
                          - Escolha a próxima operação: -
                        ==================================
                        | 1 - Voltar ao Menu             |
                        | 2 - Editar outro produto       |
                        ==================================
                        """);
                while (true) {
                    int addOption = ler.nextInt();
                    switch (addOption) {
                        case 1:
                            return;
                        case 2:
                            editarProduto();
                            break;
                        default:
                            System.out.println("Digite uma opcao valida");
                            break;
                    }
                }
            }
        }
        System.out.println("Não existem produtos cadastrados");
    }

    public static void removerProduto() {

        System.out.println("| Digite o ID do produto que deseja remover: |");
        int id = ler.nextInt();

        while (!verificarID(id)) {
            System.out.println("| ID não identificado. Por favor, insira um ID valido: |");
            id = ler.nextInt();
        }

        for (int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).id == id) {
                produtos.remove(i);
            }
        }

        System.out.println("Produto REMOVIDO com sucesso!!!");
        System.out.println("""
                  - Escolha a próxima operação: -
                ==================================
                | 1 - Voltar ao Menu             |
                | 2 - Remover outro produto      |
                ==================================
                """);
        while (true) {
            int addOption = ler.nextInt();
            switch (addOption) {
                case 1:
                    return;
                case 2:
                    removerProduto();
                    break;
                default:
                    System.out.println("Digite uma opcao valida");
                    break;
            }
        }
    }


    public static void mostrarProdutos() {
        int quantidadeTotal = 0;
        double valorTotalEstoque = 0;
        for (Produto produto : produtos) {
            System.out.println("\n| ID:" + produto.id + " |");
            System.out.println("| Nome:" + produto.nome+ " |");
            System.out.println("| Valor Unitario:" + produto.valor+ " |");
            System.out.println("| Quantidade:" + produto.quantidade+ " |");
            System.out.println("| O valor total do produto: " + (produto.valor * produto.quantidade)+ " |");
            quantidadeTotal += produto.quantidade;
            valorTotalEstoque += produto.quantidade * produto.valor;
        }
        System.out.println("| A quantidade total de itens no estoque: " + quantidadeTotal + " |");
        System.out.println("| O valor total do estoque eh: " + valorTotalEstoque + " |");
    }

    public static boolean verificarID(int id) {

        for (Produto p : produtos) {
            if (p.id == id) {
                return true;
            }
        }
        return false;
    }


}
