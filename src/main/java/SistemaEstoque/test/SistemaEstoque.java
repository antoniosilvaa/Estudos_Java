package SistemaEstoque.test;

import SistemaEstoque.domain.Produto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaEstoque {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        int opcao;
        boolean continuar = true;
        while (continuar) {
            String menu = """
                    1 - Cadastrar Produto
                    2 - Listar Produtos
                    3 - Atualizar quantidade
                    4 - Vender Produto
                    5 - relatorio de estoque
                    6 - SAIR
                    """;
            String inputOpcao = JOptionPane.showInputDialog(menu);
            if (inputOpcao == null) {
                continuar = false;
            }
            try {
                assert inputOpcao != null;
                opcao = Integer.parseInt(inputOpcao);
                switch (opcao) {
                    case 1: {
                        String nomeProduto = JOptionPane.showInputDialog("Digite o nome do Produto: ");
                        String qtdProduto = JOptionPane.showInputDialog("Digite a quantidade do Produto: ");
                        String precoProduto = JOptionPane.showInputDialog("Digite o valor do Produto: ");

                        int qtd = Integer.parseInt(qtdProduto);
                        double preco = Double.parseDouble(precoProduto);
                        Produto Produto = new Produto(nomeProduto, qtd, preco);
                        lista.add(Produto);

                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!");
                        break;
                    }

                    case 2: {
                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum Produto encontrado!!");
                        } else {
                            StringBuilder listaProduto = new StringBuilder("Listagem dos produtos\n");
                            for (Produto produto : lista) {
                                listaProduto.append("\nNome: ").append(produto.getNomeProduto())
                                        .append("\nQuantidade: ").append(produto.getQuantidade())
                                        .append("\nValor:  ").append(produto.getPreco())
                                        .append("\n------------------------");
                            }
                            JOptionPane.showMessageDialog(null, listaProduto.toString());
                        }
                        break;
                    }
                    case 3: {
                        int opcoes;
                        String produtoBusca = JOptionPane.showInputDialog("Digite o nome do produto que deseja atualizar: ");
                        Produto encontrado = null;

                        for (Produto produto : lista) {
                            if (produto.getNomeProduto().equalsIgnoreCase(produtoBusca)) {
                                encontrado = produto;
                                break;
                            }
                        }

                        if (encontrado == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!!");
                            break;
                        }

                        String menuAtt = """
                                1 - Atualizar somente a quantidade
                                2 - Atualizar somente o preço
                                3 - Atualizar quantidade e preço
                                """;
                        String input = JOptionPane.showInputDialog(menuAtt);
                        if (input == null) {
                            break;
                        }

                        opcoes = Integer.parseInt(input);

                        switch (opcoes) {
                            case 1: {
                                String qtdAtt = JOptionPane.showInputDialog("Digite a nova quantidade: ");
                                int qtd = Integer.parseInt(qtdAtt);
                                encontrado.setQuantidade(qtd);
                                JOptionPane.showMessageDialog(null, "Quantidade atualizada com sucesso!!");
                                break;
                            }
                            case 2: {
                                String novoPreco = JOptionPane.showInputDialog("Digite o novo preço: ");
                                double preco = Double.parseDouble(novoPreco);

                                    encontrado.setPreco(preco);
                                    JOptionPane.showMessageDialog(null, "Preço atualizado com sucesso!!");
                                    break;
                            }

                            case 3: {

                                    String qtdAtualizada = JOptionPane.showInputDialog("Digite a nova quantidade: ");
                                    String novoPreco = JOptionPane.showInputDialog("Digite o novo preco: ");

                                    int novoQuantidade = Integer.parseInt(qtdAtualizada);
                                    double novoPrecoAtualizado = Double.parseDouble(novoPreco);

                                    encontrado.setQuantidade(novoQuantidade);
                                    encontrado.setPreco(novoPrecoAtualizado);

                                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!!");

                                break;
                            }
                            default:{
                                JOptionPane.showMessageDialog(null, "Opção inválida!");
                                break;
                            }
                        }
                        break;
                    }
                    case 4: {

                        String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto: ");
                        Produto encontrado = null;

                        for (Produto produto : lista) {
                            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                                encontrado = produto;
                                break;
                            }
                        }
                        if (encontrado != null) {
                            String qtdVendida = JOptionPane.showInputDialog("Digite o quantidade do produto: ");
                            int qtdVendido = Integer.parseInt(qtdVendida);

                            if (qtdVendido > encontrado.getQuantidade()) {
                                JOptionPane.showMessageDialog(null, "Estoque insuficiente! Apenas "
                                        + encontrado.getQuantidade() + " unidades disponíveis.");
                            } else {

                                int novoEstoque = encontrado.getQuantidade() - qtdVendido;
                                encontrado.setQuantidade(novoEstoque);


                                double valorTotal = qtdVendido * encontrado.getPreco();


                                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso! Total: R$ " + valorTotal);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!!");
                        }
                        break;
                    }
                    case 5: {

                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!!");
                        } else {
                            Produto maisCaro = lista.get(0);
                            Produto maisBarato = lista.get(0);
                            for (Produto produto : lista) {
                                if (produto.getPreco() > maisCaro.getPreco()) {
                                    maisCaro = produto;
                                }
                                if (produto.getPreco() < maisBarato.getPreco()) {
                                    maisBarato = produto;
                                }
                            }
                            String mensagem = "Produto mais caro: " + maisCaro.getNomeProduto() + " - R$ " + maisCaro.getPreco() +
                                    "\nProduto mais barato: " + maisBarato.getNomeProduto() + " - R$ " + maisBarato.getPreco();
                            JOptionPane.showMessageDialog(null, mensagem);
                        }
                        break;
                    }
                    case 6: {
                        continuar = false;
                        JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                        break;
                    }

                    default: {
                        continuar = true;
                        JOptionPane.showMessageDialog(null, "Entrada invalida, Tente Novamente!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite apenas números.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
