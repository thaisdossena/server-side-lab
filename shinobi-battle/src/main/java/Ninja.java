public class Ninja {
    private String nome;
    private int chakra;
    private Jutsu justu;

    //Construtores
    public Ninja(String nome, Jutsu jutsu) {
        this.nome = nome;
        this.justu = jutsu;
        this.chakra = 100;
    }

    //Métodos
    public void atacar(Ninja oponente) {
        oponente.receberGolpe(justu.getDano());
        chakra -= justu.getQuantidadeChakra();
    }

    private void receberGolpe(int dano) {
        chakra -= dano;
    }

    public int getChakra() {
        return chakra;
    }

    public String getNome() {
        return nome;
    }
}




