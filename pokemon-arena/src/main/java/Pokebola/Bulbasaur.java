package Pokebola;

import Movimentos.FolhaNavalha;
import Tipos.TipoPokemon;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super(45, 45,49, 49, 65, 65, 45, TipoPokemon.GRAMA, new FolhaNavalha());
    }
}