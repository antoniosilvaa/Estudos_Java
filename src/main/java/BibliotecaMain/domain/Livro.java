package BibliotecaMain.domain;

import javax.swing.*;

public class Livro {
    String titulo;
    String autor;
    String editora;
    boolean disponivel;

    public Livro(String titulo, String autor, String editora, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public  boolean emprestar(){
        if (disponivel){
            disponivel = false;
            JOptionPane.showMessageDialog(null, "Livro \"" + titulo + "\" emprestado com sucesso!");
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Livro \"" + titulo + "\" já está emprestado.");
            return false;
        }
    }

    public boolean devolver(){
        if (!disponivel){
            disponivel = true;
            JOptionPane.showMessageDialog(null,"Livro \"" + titulo + "\" devolvido com sucesso!");
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Livro \"" + titulo + "\" já está disponível.");
            return false;
        }
    }

    public String toString(){
        return "Título: " + titulo + ", Autor: " + autor + ", Editora: " + editora +
                ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
