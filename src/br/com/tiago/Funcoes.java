package br.com.tiago;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner ler = new Scanner(System.in);

    public static void adicionar() {
        Produto produtoNew = new Produto();
        System.out.println("Nome do produto: ");
        produtoNew.nome = ler.nextLine();

        System.out.println("Digite o id");
        produtoNew.id = ler.nextInt();

        System.out.println("Digite a quantidade");
        produtoNew.quantidade = ler.nextInt();

        System.out.println("Digite o valor do produto: ");
        produtoNew.valor = ler.nextDouble();

        produtos.add(produtoNew);
    }

    public static void buscarProduto() {
        System.out.println("Digite o ID do produto: ");
        int id = ler.nextInt();
        for (Produto produto : produtos) {
            if (produto.id == id) {
                System.out.println("Produto encontrado: " + produto.nome);
            } else {
                System.out.println("Não encontrado");
            }
        }

    }


    public static void editarProduto() {
        System.out.println("Digite o ID do produto: ");
        int id = ler.nextInt();
        for (Produto produto : produtos) {
            if(produto.id == id){
                System.out.println("Informe o novo nome: ");
                ler.nextLine();
                produto.nome = ler.nextLine();
                System.out.println("Informe a nova quantidade: ");
                produto.quantidade = ler.nextInt();
                System.out.println("Informe o novo valor: ");
                produto.valor = ler.nextDouble();
                break;
            }
        }
    }
    public static void removerProduto(){
        System.out.println("Digite o ID do produto que deseja remover: ");
        int id = ler.nextInt();
        for(Produto produto : produtos){
            if(produto.id == id) produtos.remove(produto); break;
        }
    }
}
