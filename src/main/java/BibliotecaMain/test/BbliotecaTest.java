package BibliotecaMain.test;

import BibliotecaMain.domain.Livro;
import BibliotecaMain.domain.Usuario;
import BibliotecaMain.domain.service.BibliotecaService;

import javax.swing.*;

public class BbliotecaTest {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();
        Livro livro;
        int opcao = -1;

        while (opcao != 0) {
            String menu = """
                    ==== Biblioteca ====
                    1 - Adicionar Livro
                    2 - Listar Livros
                    3 - Adicionar Usuário
                    4 - Listar Usuários
                    5 - Emprestar Livro
                    6 - Devolver Livro
                    0 - Sair
                    """;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {
                    case 1 -> {

                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        String autor = JOptionPane.showInputDialog("Digite o autor:");
                        String editora = JOptionPane.showInputDialog("Digite a editora:");


                        Livro novoLivro = new Livro(titulo, autor, editora, true);

                        biblioteca.adicionarLivro(novoLivro);
                        JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                    }
                    case 2 -> {
                        if (biblioteca.getLivros().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado!");
                        } else {
                            StringBuilder livros = new StringBuilder("Livros : \n");
                            for (Livro livroAux : biblioteca.getLivros()) {
                                livros.append("\nTitulo: ").append(livroAux.getTitulo())
                                        .append("\nEditora: ").append(livroAux.getEditora())
                                        .append("\nAutor: ").append(livroAux.getAutor())
                                        .append("\n-------------------------\n");
                            }
                            JOptionPane.showMessageDialog(null, livros.toString());
                        }
                    }
                    case 3 -> {
                        String nomeUser = JOptionPane.showInputDialog("Digite seu nome:");
                        String idUsuario = JOptionPane.showInputDialog("Digite seu id:");

                        int iduser = Integer.parseInt(idUsuario);

                        Usuario newUser = new Usuario(nomeUser, iduser);
                        biblioteca.adicionarUsuario(newUser);
                        JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
                    }

                    case 4 -> {
                        if (biblioteca.getUsuarios().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado");
                        } else {
                            StringBuilder users = new StringBuilder("Usuarios : \n");
                            for (Usuario usuarioAux : biblioteca.getUsuarios()) {
                                users.append("\nUsuario: ").append(usuarioAux.getNome())
                                        .append("\nIdUser: ").append(usuarioAux.getIdUsuario())
                                        .append("\n-------------------------\n");
                            }
                            JOptionPane.showMessageDialog(null, users.toString());
                        }
                    }
                    case 5 -> {
                        String nomeUsuario = JOptionPane.showInputDialog("Digite Seu nome de usuario: ");
                        String tituloLivro = JOptionPane.showInputDialog("Digite o livro escolhido: ");

                        Usuario usuarioEscolhido = null;
                        Livro livroEscolhido = null;

                        for (Usuario usuarioAux : biblioteca.getUsuarios()) {
                            if (usuarioAux.getNome().equalsIgnoreCase(nomeUsuario)) {
                                usuarioEscolhido = usuarioAux;
                                break;
                            }
                        }
                        for (Livro livroAux : biblioteca.getLivros()) {
                            if (livroAux.getTitulo().equalsIgnoreCase(tituloLivro)) {
                                livroEscolhido = livroAux;
                                break;
                            }
                        }

                        if (livroEscolhido == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado");
                        } else if (usuarioEscolhido == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado");
                        } else {
                            biblioteca.emprestarLivro(usuarioEscolhido, livroEscolhido);
                        }
                    }
                    case 6 -> {
                        String nomeDevolvido = JOptionPane.showInputDialog("Digite o nome de quem vai devolver o livro: ");
                        String livroDevolvido = JOptionPane.showInputDialog("Digite o titulo do livro que será ser devolvivo: ");

                        Usuario usuarioDevolvido = null;
                        Livro livroDevolvidoDevolvido = null;

                        for (Usuario usuarioAux : biblioteca.getUsuarios()) {
                            if (usuarioAux.getNome().equalsIgnoreCase(nomeDevolvido)) {
                                usuarioDevolvido = usuarioAux;
                                break;
                            }
                        }

                        for (Livro livroAux : biblioteca.getLivros()) {
                            if (livroAux.getTitulo().equalsIgnoreCase(livroDevolvido)) {
                                livroDevolvidoDevolvido = livroAux;
                                break;
                            }
                        }

                        if (livroDevolvidoDevolvido == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado");
                        } else if (usuarioDevolvido == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado");
                        } else {
                            biblioteca.devolverLivro(usuarioDevolvido, livroDevolvidoDevolvido);
                        }
                    }
                    case 0 -> {
                        JOptionPane.showMessageDialog(null, "Encerrando programa....");
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Numero invalido!! Tente novamente");
                    }
                }
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite apenas números.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
