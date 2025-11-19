package Main;

import Itens.Item;
import Pokebola.Pokemon;

public class Arena {

    private Treinador treinadorA;
    private Treinador treinadorB;
    private int turnoAtual;

    public Arena(Treinador treinadorA, Treinador treinadorB) {
        this.treinadorA = treinadorA;
        this.treinadorB = treinadorB;
        this.turnoAtual = 1;
    }

    public Treinador batalhar() {
        Pokemon pokemonA = treinadorA.getPokemonAtivo();
        Pokemon pokemonB = treinadorB.getPokemonAtivo();

        System.out.println(treinadorA + " envia " + pokemonA.falar() + "!");
        System.out.println(treinadorB + " envia " + pokemonB.falar() + "!");


        while (true) {
            pokemonA = treinadorA.getPokemonAtivo();
            pokemonB = treinadorB.getPokemonAtivo();

            tentarUsarItem(treinadorA, pokemonA);
            tentarUsarItem(treinadorB, pokemonB);

            boolean aAtacaPrimeiro;
            if (pokemonA.getVelocidade() > pokemonB.getVelocidade()) {
                aAtacaPrimeiro = true;
            } else if (pokemonA.getVelocidade() < pokemonB.getVelocidade()) {
                aAtacaPrimeiro = false;
            } else {
                aAtacaPrimeiro = true;
            }

            Treinador vencedor;

            if (aAtacaPrimeiro) {
                vencedor = executarAtaque(treinadorA, treinadorB, pokemonA, pokemonB);
                if (vencedor != null) return vencedor;
                vencedor = executarAtaque(treinadorB, treinadorA, pokemonB, pokemonA);
                if (vencedor != null) return vencedor;

            } else {
                vencedor = executarAtaque(treinadorB, treinadorA, pokemonB, pokemonA);
                if (vencedor != null) return vencedor;
                vencedor = executarAtaque(treinadorA, treinadorB, pokemonA, pokemonB);
                if (vencedor != null) return vencedor;
            }
            this.turnoAtual++;
        }
    }

    private Treinador executarAtaque(Treinador atacante, Treinador defensor, Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        if (pokemonAtacante.getVidaAtual() <= 0) {
            return null;
        }

        int dano = pokemonAtacante.calcularDano(pokemonDefensor);
        pokemonDefensor.receberDano(dano);

        if (pokemonDefensor.getVidaAtual() <= 0) {
            boolean temProximoPokemon = defensor.proximoPokemon();

            if (temProximoPokemon) {
                return null;
            } else {
                return atacante;
            }
        }
        return null;
    }

    private void tentarUsarItem(Treinador treinador, Pokemon pokemonAtivo) {
        Item item = treinador.getItem();

        if (item != null && item.getTurnoDeAcionamento() == this.turnoAtual) {
            item.usarItem(pokemonAtivo);
            treinador.consumirItem();
        }
    }
}