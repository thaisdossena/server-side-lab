import java.util.ArrayList;

public class Planeta {
    private int posicao;
    private ArrayList<Recurso> recursos;

    public Planeta(int posicao, ArrayList<Recurso> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int getPosicao() {
        return posicao;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public int getValorTotal() {
        int total = 0;
        for (Recurso recurso : recursos) {
            total += recurso.getValor();
        }
        return total;
    }

    public int getValorPorPeso() {
        int total = 0;
        for (Recurso recurso : recursos) {
            total += recurso.getValor() / recurso.getPeso();
        }
        return total;
    }
}
