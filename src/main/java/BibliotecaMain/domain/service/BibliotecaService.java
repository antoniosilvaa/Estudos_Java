package BibliotecaMain.domain.service;

import BibliotecaMain.domain.Livro;
import BibliotecaMain.domain.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaService {
    private List <Livro> livros;
    private List <Usuario> usuarios;
    private Map<Usuario, List<Livro>> emprestimos;

   public  BibliotecaService(){
       this.livros = new ArrayList<>();
       this.usuarios = new ArrayList<>();
       this.emprestimos = new HashMap<>();
   }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Map<Usuario, List<Livro>> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(Map<Usuario, List<Livro>> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void adicionarLivro(Livro livro){
       livros.add(livro);
   }

   public void listarLivros(){
      for (Livro livroAux : livros){
          JOptionPane.showMessageDialog(null, livros);
      }

   }
   public void adicionarUsuario(Usuario usuario){
       usuarios.add(usuario);
   }
   public void listarUsuarios(){
       for (Usuario u : usuarios){
           JOptionPane.showMessageDialog(null, u);
       }
   }
   public void emprestarLivro(Usuario usuario,Livro livro){
       if (livro.isDisponivel()){
           usuario.emprestar(livro);
           emprestimos.computeIfAbsent(usuario, k -> new ArrayList<>()).add(livro);
       }else {
           JOptionPane.showMessageDialog(null, "Livro indisponivel!");
       }
   }
    public void devolverLivro(Usuario usuario, Livro livro) {
        if (emprestimos.containsKey(usuario) && emprestimos.get(usuario).contains(livro)) {
            usuario.devolver(livro);
            emprestimos.get(usuario).remove(livro);
        } else {
            JOptionPane.showMessageDialog(null, "Este usuário não pegou este livro.");
        }
    }
}
