package MainAluno;

import Aluno.Service.AlunoService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoTest {
    public static void main(String[] args) {
        List< AlunoService> lista = new ArrayList<>();
        int opcao;
        boolean continuar = true;

        while (continuar) {
            String menu = """
                    1 - Cadastrar Aluno
                    2 - Listar Alunos
                    3 - Media da Turma
                    4 - Maior e Menor Nota da Turma
                    5 - Sair
                    """;

            String inputOpcao = JOptionPane.showInputDialog(menu);
            if (inputOpcao == null) {
                continuar = false;
            }


            try {
                assert inputOpcao != null;
                opcao = Integer.parseInt(inputOpcao);

                if (opcao < 1 || opcao > 5) {
                    continuar = false;
                }


                switch (opcao) {
                    case 1: {
                        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno: ");
                        String notaAluno = JOptionPane.showInputDialog("Digite a nota do aluno: ");
                        int nota = Integer.parseInt(notaAluno);

                        AlunoService alunoService = new AlunoService(nomeAluno, nota);
                        lista.add(alunoService);

                        JOptionPane.showMessageDialog(null, "Aluno e Nota cadastrados com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    case 2: {
                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum Aluno ou Nota encontrada!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }else{
                            StringBuilder listaAlunos = new StringBuilder("Listagem de alunos e notas:\n");
                            for (AlunoService aluno : lista) {
                                listaAlunos.append("\nAluna(o): ").append(aluno.getNome())
                                        .append("\nNota: ").append(aluno.getNota()).
                                        append("\n-------------------------------");
                            }
                            JOptionPane.showMessageDialog(null, listaAlunos.toString());
                        }
                        break;
                    }
                    case 3: {
                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhuma Nota ou Aluno cadastrados!", "ERROR", JOptionPane.WARNING_MESSAGE);
                        }else {
                            int soma = 0;

                            for (AlunoService aluno : lista) {
                                soma += aluno.getNota();
                            }
                            double media = (double) soma / lista.size();

                            JOptionPane.showMessageDialog(null,"Media da Turma: " + String.format("%.2f", media), "Media Geral", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }
                    case 4: {
                        int maiorNota;
                        int menorNota;

                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhuma Nota encontrada!", "ERROR", JOptionPane.ERROR_MESSAGE);

                        }else {
                            menorNota = lista.get(0).getNota();
                            maiorNota = lista.get(0).getNota();
                            for (AlunoService alunoService : lista) {

                                if (alunoService.getNota() < menorNota) {
                                    menorNota = alunoService.getNota();
                                }
                                if (alunoService.getNota() > maiorNota) {
                                    maiorNota = alunoService.getNota();
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Maior Nota: " + maiorNota +
                                    "\nMenor Nota: " + menorNota, "Maior e Menor nota!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }
                    case 5: {
                        continuar = false;
                        JOptionPane.showMessageDialog(null, "Encerrando Programa...." , "Desligando",  JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Entrada invalida, Tente Novamente!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        continuar = true;
                    }
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite apenas números.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
