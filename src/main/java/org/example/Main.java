package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int idade = 0;
        int soma = 0;
        int MaisVelho = 0;
        int MaisNovo = 0;
        int contador = 1;
        int menores18 = 0;
        Scanner ler = new Scanner(System.in);
        while (contador <= 5) {
            System.out.println("Digite sua idade: (Caso queira Sair escreva = (sair))");
            idade = ler.nextInt();
            soma += idade;

            if (contador == 1) {
                MaisVelho = idade;
                MaisNovo = idade;
            }

            if (idade > MaisVelho) {
                MaisVelho = idade;
            }
            if (idade < MaisNovo) {
                MaisNovo = idade;
            }

            if (idade < 18) {
                menores18++;
            }
            contador++;
        }
        float media = (float) soma / 5;

        System.out.println("A media de idade é: " + media);
        System.out.println("O mais velho tem: " + MaisVelho + " Anos");
        System.out.println("O mais novo tem::" + MaisNovo + " Anos");
        System.out.println("Quantidade de pessoas menores de 18: " + menores18);
    }
}