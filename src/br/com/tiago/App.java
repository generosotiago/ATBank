package br.com.tiago;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("------------------");
        System.out.println("SISTEMA BANCO AXION");
        System.out.println("------------------");
        System.out.println();
        Scanner ler = new Scanner(System.in);

        System.out.println("Tecle ENTER para prosseguir");
        String seguir = ler.nextLine();

        System.out.println("------------------");
        System.out.println("Já é cliente Axion, ou ainda está por fora desse benefício?");
        System.out.println("------------------");
        System.out.println(" 1 - Para fazer LOGIN");
        System.out.println(" 2 - Para se CADASTRAR");
        System.out.println();
        System.out.println(" Ou digite qualquer coisa para encerrar o sistema");
        Scanner tec = new Scanner(System.in);
        int login = tec.nextInt();
        int contador = 0;
        String[][] usuarios = new String[100][4];

        do {
            switch (login) {
                case 1:
                    System.out.println("LOGIN");
                    System.out.println("------------------");
                    break;
                case 2:
                    System.out.println("CADASTRO");
                    System.out.println("------------------");
                    tec.nextLine(); // Limpa o buffer
                    System.out.println("Qual o seu nome?");
                    String nome = tec.nextLine();
                    System.out.println("Qual o seu email?");
                    String email = tec.nextLine();
                    System.out.println("Qual a sua senha?");
                    String senha = tec.nextLine();
                    System.out.println("Qual o seu CPF?");
                    String cpf = tec.nextLine();
                    usuarios[contador][0] = nome;
                    usuarios[contador][1] = email;
                    usuarios[contador][2] = senha;
                    usuarios[contador][3] = cpf;
                    contador++;
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                default:
                    break;
            }
        }while (login < 2);
    }
}