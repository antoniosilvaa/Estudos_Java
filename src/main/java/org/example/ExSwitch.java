package org.example;

import java.util.Scanner;

public class ExSwitch {
    public static void main(String[] args) {
        String dia = "";

        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o dia: ");
        dia = ler.nextLine();

        switch (dia) {
            case "Domingo":
                System.out.println(dia+" É um Fim de semana");
                break;
            case "Segunda":
                System.out.println(dia+" É um Dia util");
                break;
            case "Terca feira":
                System.out.println(dia+" É um Dia util");
                break;
            case "Quarta feira":
                System.out.println(dia+" É um Dia util");
                break;
            case "Quinta feira":
                System.out.println(dia+" É um Dia util");
                break;
            case "Sexta feira":
                System.out.println(dia+" É um Dia util");
                break;
            case "Sabado":
                System.out.println(dia + " É um fim de semana");
                break;
            default:
                System.out.println("Esse dia não existe");
        }
    }
}
