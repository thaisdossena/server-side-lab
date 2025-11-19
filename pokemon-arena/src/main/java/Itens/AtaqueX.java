package Itens;

import Pokebola.Pokemon;

public class AtaqueX implements Item {
    @Override
    public void usarItem(Pokemon pokemon) {
        int ataque = pokemon.getAtaque();
        pokemon.setAtaque(ataque + 200);
        System.out.println("O Ataque de " + pokemon.falar() + " aumentou!");
    }

    @Override
    public int getTurnoDeAcionamento() {
        return 1;
    }
}
