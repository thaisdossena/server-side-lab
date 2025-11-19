package Itens;

import Pokebola.Pokemon;

public class AtaqueEspecialX implements Item {
    @Override
    public void usarItem(Pokemon pokemon) {
        int ataqueEspecialAtual = pokemon.getAtaqueEspecial();
        pokemon.setAtaqueEspecial(ataqueEspecialAtual + 200); //
        System.out.println("O Ataque Especial de " + pokemon.falar() + " aumentou!");
    }

    @Override
    public int getTurnoDeAcionamento() {
        return 1; //
    }
}
