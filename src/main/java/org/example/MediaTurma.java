package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aluno {
    String nome;
    int nota;

    public Aluno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }
}

public class MediaTurma {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Quantos alunos tem na turma? ");
        int qtdAlunos = input.nextInt();

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("Digite o nome do aluno: ");
            String nomeAluno = input.next();


            System.out.println("Digite a nota do aluno" + (i+1) + ":");
            int nota = input.nextInt();

            alunos.add(new Aluno(nomeAluno, nota));
        }

        int maiorNota = alunos.get(0).nota;
        int menorNota = alunos.get(0).nota;
        int soma = 0;
        List<String> aprovados = new ArrayList<>();
        List<String> reprovados = new ArrayList<>();
        for(Aluno aluno : alunos ) {

            soma += aluno.nota;

            if(aluno.nota < menorNota){
                menorNota = aluno.nota;
            }
            if(aluno.nota > maiorNota){
                maiorNota = aluno.nota;
            }
            if (aluno.nota >= 7){
                aprovados.add(aluno.nome);
            }else {
                reprovados.add(aluno.nome);
            }
        }
    double media = (double) soma/qtdAlunos;

        alunos.sort((a,b) -> b.nota - a.nota);

        System.out.println("\nTop 3 Alunos: ");
        for (int i = 0; i < 3 && i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i).nome + " - Nota: " + alunos.get(i).nota);

        }
        System.out.println("\nMaior nota: " + maiorNota);
        System.out.println("Menor nota: " + menorNota);
        System.out.println("Média da turma: " + media);
        System.out.println("Aprovados da turma: " + aprovados);
        System.out.println("Reprovados da turma: " + reprovados);
    }
}


