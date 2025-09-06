package Despesas.Srvice;

public class Despesas {
    private String nomeDespesa;
    private int valorDespesa;

    public Despesas(String nomeDespesa, int valorDespesa) {
        this.nomeDespesa = nomeDespesa;
        this.valorDespesa = valorDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public int getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(int valorDespesa) {
        this.valorDespesa = valorDespesa;
    }
}
