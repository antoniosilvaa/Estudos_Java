package BibliotecaMain.domain;

import javax.swing.*;

public class Usuario {
    String nome;
    int idUsuario;


    public Usuario(String nome, int id_usuario) {
        this.nome = nome;
        this.idUsuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean emprestar(Livro livro){
        if (livro.disponivel){
            livro.emprestar();
            JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso! para " + nome);
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Livro indisponível para empréstimo.");
            return false;
        }
    }
    public boolean devolver(Livro livro){
        if (!livro.disponivel){
            livro.devolver();
            JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso por " + nome);
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Este livro ja está disponivel!");
            return false;
        }
    }
    public String toString() {
        return "Usuário: " + nome + " (ID: " + idUsuario + ")";
    }
}
