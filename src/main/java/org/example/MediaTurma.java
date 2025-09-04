package org.example;

import Aluno.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MediaTurma {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Quantos alunos tem na turma? ");
        int qtdAlunos = input.nextInt();

        System.out.println("Quantas notas os alunos teram?");
        int qtdNotas = input.nextInt();
        int somaNotasAluno = 0;


        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("Digite o nome do aluno: ");
            String nomeAluno = input.next();

            for (int j = 0; j < qtdNotas; j++) {
                System.out.println("Digite a nota " + (j + 1) + ":");
                int nota = input.nextInt();
                somaNotasAluno += nota;
                alunos.add(new Aluno(nomeAluno, nota));
            }
        }

        int maiorNota = alunos.get(0).getNota();
        int menorNota = alunos.get(0).getNota();
        int soma = 0;
        List<String> aprovados = new ArrayList<>();
        List<String> reprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {

            soma += aluno.getNota();

            if (aluno.getNota() < menorNota) {
                menorNota = aluno.getNota();
            }
            if (aluno.getNota() > maiorNota) {
                maiorNota = aluno.getNota();
            }
            if (aluno.getNota() >= 7) {
                aprovados.add(aluno.getNome());
            } else {
                reprovados.add(aluno.getNome());
            }
        }
        double media = (double) soma / qtdAlunos;

        alunos.sort((a, b) -> b.getNota() - a.getNota());

        System.out.println("\nTop 3 Alunos: ");
        for (int i = 0; i < 3 && i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i).getNome() + " - Nota: " + alunos.get(i).getNota());

        }
        System.out.println("\nMaior nota: " + maiorNota);
        System.out.println("Menor nota: " + menorNota);
        System.out.println("Média da Turma: " + media);
        System.out.println("Aprovados da turma: " + aprovados);
        System.out.println("Reprovados da turma: " + reprovados);
    }
}


