package mainDespesas;

import Despesas.Srvice.Despesas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DespesasOn {
    public static void main(String[] args) {
        List<Despesas> listaDespesas = new ArrayList<>();
        boolean continuar = true;
        int opcao;

        while (continuar) {
            String menu = """
                            ===Despesas===
                            1 - Cadastrar Despesas
                            2 - Listar Despesas
                            3 - Calcular total gasto
                            4 - Sair
                    """;

            String inputOpcao = JOptionPane.showInputDialog(menu);
            if (inputOpcao == null) {
                continuar = false;
            }

                try {
                    assert inputOpcao != null;
                    opcao = Integer.parseInt(inputOpcao);

                    if (opcao < 1 || opcao > 4) {
                        continuar = false;
                    }

                    switch (opcao) {
                        case 1: {

                            String nomeDespesa = JOptionPane.showInputDialog("Nome despesa: ");
                            String valorDespesa = JOptionPane.showInputDialog(null, "Valor Despesa: ");
                            int ValorDespesa = Integer.parseInt(valorDespesa);

                            Despesas despesas = new Despesas(nomeDespesa, ValorDespesa);
                            listaDespesas.add(despesas);

                            JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!");
                            break;
                        }

                        case 2: {
                            if (listaDespesas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum despesa encontrada!");
                            }else {
                                StringBuilder lista =  new StringBuilder("Extrato:\n");
                                for (Despesas despesa : listaDespesas) {
                                    lista.append("\nNome: ").append(despesa.getNomeDespesa())
                                            .append("\nValor: ").append(despesa.getValorDespesa())
                                            .append("\n-------------------\n");
                                }
                                JOptionPane.showMessageDialog(null, lista.toString());
                                break;
                            }
                        }
                        case 3: {
                            if (listaDespesas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum despesa encontrada!");
                            }else {
                                    int total = 0;
                                for (Despesas listaDespesa : listaDespesas) {
                                    total += listaDespesa.getValorDespesa();
                                }
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Você cadastrou " + listaDespesas.size() + " despesas.\n" +
                                                "Total gasto: R$ " + total
                                );
                            }
                            break;
                        }
                        case 4: {
                            JOptionPane.showMessageDialog(null, "Encerrando programa...");
                            continuar = false;
                            break;
                        }
                        default:{
                            JOptionPane.showMessageDialog(null, "Valor invalido, Tente novamente!!");
                            continuar = true;
                            break;
                        }
                    }
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Digite apenas números.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

