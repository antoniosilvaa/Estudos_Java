package TestContato;

import Contato.Contato;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestContato {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();
        boolean continuar = true;
        int opcao = 0;

        while (continuar) {
            String menu = """
                    ===Agenda de Contatos===
                    1 - Adicionar Contato
                    2 - Listar Contatos
                    3 - Buscar Contato por nome
                    4 - Remover Contato
                    5 - Sair
                    """;
            String inputOpcao = JOptionPane.showInputDialog(menu);

            if (inputOpcao == null) {
                continuar = false;
            }

            try {
                opcao = Integer.parseInt(inputOpcao);

                if (opcao < 1 || opcao > 4) {
                    continuar = false;
                }
                switch (opcao) {
                    case 1: {
                        String nome = JOptionPane.showInputDialog("Digite o nome do contato:");
                        String email = JOptionPane.showInputDialog("Digite o email do contato:");
                        String telefoneStr = JOptionPane.showInputDialog("Digite o telefone do contato:");


                        Contato novoContato = new Contato(nome, email, telefoneStr);


                        contatos.add(novoContato);

                        JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
                        break;
                    }
                    case 2: {
                        //isEmpty verifica se existe algum contato caso seja verdadeiro nao exista ele atua se nao vai para o else//
                        if (contatos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!");
                        }
                        //forEach foi criado apenas para listar todo a agenda de contatos//
                        else {
                            StringBuilder lista = new StringBuilder("📒 Contatos:\n");
                            for (Contato c : contatos) {
                                lista.append("Nome: ").append(c.getNome())
                                        .append("\nEmail: ").append(c.getEmail())
                                        .append("\nTelefone: ").append(c.getTelefone())
                                        .append("\n-------------------\n");
                            }
                            JOptionPane.showMessageDialog(null, lista.toString());
                        }
                        break;
                    }
                    case 3: {
                        String nomeBusca = JOptionPane.showInputDialog("Digite o nome do contato que deseja buscar:");
                        Contato encontrado = null;

                        for (Contato c : contatos) {
                            if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                                encontrado = c;
                                break;
                            }
                        }
                        if (encontrado != null) {
                            JOptionPane.showMessageDialog(null, "Nome: " + encontrado.getNome() +
                                    "\nEmail: " + encontrado.getEmail() +
                                    "\nTelefone: " + encontrado.getTelefone());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!");
                        }
                        break;
                    }
                    case 4: {
                        String remove = JOptionPane.showInputDialog("Remover contato", "Digite o nome do contato:");
                        Contato removeContato = null;

                        for (Contato c : contatos) {
                            if (c.getNome().equalsIgnoreCase(remove)) {
                                removeContato = c;
                                break;
                            }
                        }
                        if (removeContato != null) {
                            contatos.remove(removeContato);
                            JOptionPane.showMessageDialog(null, "Nome: " + removeContato.getNome() +
                                    "\nEmail: " + removeContato.getEmail() + "\nTelefone: " + removeContato.getTelefone());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!");
                        }
                        break;
                    }
                    case 5: {
                        if (opcao == 5) {
                            JOptionPane.showMessageDialog(null, "Encerrando Programa...");
                            continuar = false;
                        }
                    }

                }

                if (opcao < 1 || opcao > 5){
                    JOptionPane.showMessageDialog(null, "Opção invalida tente novamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continuar = true;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite apenas números.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                opcao = -1;
            }
        }

    }
}


