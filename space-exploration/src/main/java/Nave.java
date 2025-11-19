import java.util.ArrayList;
import java.util.List;

public class Nave {
    int posicaoDaNave = 0;
    int quantidadeDeCombustivel = 0;
    private final int consumoDeCombustivel = 3;

    public Nave(int combustivelInicial) {
        if (combustivelInicial < 0) {
            combustivelInicial = 0;
        }
        this.quantidadeDeCombustivel = combustivelInicial;
        this.posicaoDaNave = 0;
    }

    public int getQuantidadeDeCombustivel() {
        return quantidadeDeCombustivel;
    }

    public int getPosicao() {
        return posicaoDaNave;
    }

    public List<Recurso> explorar(Planeta planeta) {
        int distancia = Math.abs(planeta.getPosicao() - posicaoDaNave);
        int consumoIda = distancia * consumoDeCombustivel;
        int consumoRetorno = planeta.getPosicao() * consumoDeCombustivel;
        int custoTotal = consumoIda + consumoRetorno;

        if (quantidadeDeCombustivel >= custoTotal) {
            quantidadeDeCombustivel -= custoTotal;
            posicaoDaNave = 0;
            return planeta.getRecursos();

        } else {
            int passosPossiveis = quantidadeDeCombustivel / consumoDeCombustivel;
            if (passosPossiveis > 0) {
                posicaoDaNave += passosPossiveis;
                quantidadeDeCombustivel -= passosPossiveis * consumoDeCombustivel;
            }

            return new ArrayList<Recurso>();
        }
    }
}
