package Itens;

import Pokebola.Pokemon;

public class Pocao implements Item {
    @Override
    public void usarItem(Pokemon pokemon) {
        int vidaAtual = pokemon.getVidaAtual();
        int vidaMaxima = pokemon.getPontosDeSaudeMax();

        int novaVida = vidaAtual + 50;

        if (novaVida > vidaAtual) {
            pokemon.setVidaAtual(vidaMaxima);
        } else {
            pokemon.setVidaAtual(vidaAtual);
        }
    }

    @Override
    public int getTurnoDeAcionamento() {
        // Regra: Poção ativa no turno 2
        return 2;
    }
}
