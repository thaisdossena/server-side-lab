public class Recurso {
    private String nome;
    private int valor;
    private int peso;

    public Recurso(String nome, int valor, int peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }
}
