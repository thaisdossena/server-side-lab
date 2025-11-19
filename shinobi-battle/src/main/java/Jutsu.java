public class Jutsu {
    private int quantidadeChakra;
    private int dano;

    public Jutsu(int quantidadeChakra, int dano) {
        this.quantidadeChakra = quantidadeChakra;
        this. dano = dano;
    }

    public int getDano() {
        if ( dano > 10) {
            dano = 10;
        }

        return dano;
    }

    public int getQuantidadeChakra() {
        if ( quantidadeChakra > 5  ) {
            quantidadeChakra = 5;
        }

        if (quantidadeChakra < 0) {
            quantidadeChakra = 0;
        }

        return quantidadeChakra;
    }
}
