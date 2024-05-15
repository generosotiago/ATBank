package br.com.tiago;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner ler = new Scanner(System.in);


    public static void adicionar() {
        Produto produtoNew = new Produto();
        int id;

        System.out.println("Digite o id do produto que deseja adicionar: ");
        id = ler.nextInt();

        while (verificarID(id)) {
            System.out.println("ID já existe. Por favor, insira um ID único: ");
            id = ler.nextInt();
        }

        produtoNew.id = id;
        ler.nextLine();
        System.out.println("\nNome do produto: ");
        produtoNew.nome = ler.nextLine();
        System.out.println("---> Confirma" + " -> " + produtoNew.nome + " <- " + " como nome do produto? (Tecle ENTER para confirmar)");
        ler.nextLine();

        System.out.println("Digite a quantidade: ");
        produtoNew.quantidade = ler.nextInt();

        System.out.println("Digite o valor do produto: ");
        produtoNew.valor = ler.nextDouble();

        produtos.add(produtoNew);
        System.out.println("""
                \nProduto cadastrado com sucesso,  voltar ao menu ou cadastrar outro produto?

                1 - Voltar ao Menu
                2 - Cadastrar outro produto\n
                """);
        int addOption = ler.nextInt();
        if (addOption == 2) {
            adicionar();
        }

    }

    public static void buscarProduto() {
        while (true) {
            System.out.println("Digite o ID do produto: ");
            int id = ler.nextInt();
            for (Produto produto : produtos) {
                if (produto.id == id) {
                    System.out.println("Produto encontrado: " + produto.nome + "\nQuantidade em estoque -> " + produto.quantidade);
                    return;
                } else {
                    System.out.println("Produto não encontrado");
                    return;
                }
            }
            System.out.println("Não existem produtos cadastrados");
            return;
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
                return;
            }
        }
        System.out.println("Não existem produtos cadastrados");
        return;
    }

    public static void removerProduto() {

        System.out.println("Digite o ID do produto que deseja remover: ");
        int id = ler.nextInt();

        for (Produto produto : produtos) {
            if (produto.id == id) produtos.remove(produto);
            return;
        }

        System.out.println("Não existem produtos cadastrados");

        while (!verificarID(id)) {
            System.out.println("ID não existe. Por favor, insira um ID único: ");
            id = ler.nextInt();
        }

        System.out.println("Confirmar a remoção do produto de ID: " + id);
        String tec = ler.nextLine();


    }


    public static void mostrarProdutos() {
        int quantidadeTotal = 0;
        double valorTotalEstoque = 0;
        for (Produto produto : produtos) {
            System.out.println("\nID:" + produto.id);
            System.out.println("Nome:" + produto.nome);
            System.out.println("Valor Unitario:" + produto.valor);
            System.out.println("Quantidade:" + produto.quantidade);
            System.out.println("O valor total do produto: \n" + (produto.valor * produto.quantidade));
            quantidadeTotal += produto.quantidade;
            valorTotalEstoque += produto.quantidade * produto.valor;
        }
        System.out.println("A quantidade total de itens no estoque: " + quantidadeTotal);
        System.out.println("O valor total do estoque eh: " + valorTotalEstoque);
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
