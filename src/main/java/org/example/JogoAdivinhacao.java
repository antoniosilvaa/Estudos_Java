package org.example;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner ler = new Scanner(System.in);

        int numeroSecreto = gerador.nextInt(100) + 1;
        int tentativas = 0;
        int chute = 0;

        System.out.println("Seja bem vindo ao Jogo de adivinhação!!");
        System.out.println("Digite um numero de 1 a 100");


        while (numeroSecreto != chute) {
            System.out.println("Digite seu Palpite");
            chute = ler.nextInt();
            tentativas++;

            if (chute == numeroSecreto) {
                System.out.println("Parabens voce acertou em: " + tentativas + " tentativas");
            } else if (chute < numeroSecreto) {
                System.out.println("O numero é MAIOR!!");
            } else {
                System.out.println("O numero é MENOR!!");
            }
        }
    }
}

