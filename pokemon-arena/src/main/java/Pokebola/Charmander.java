package Pokebola;

import Movimentos.Brasas;
import Tipos.TipoPokemon;

public class Charmander extends Pokemon {
    public Charmander() {
        super(39, 39,52, 43, 60, 50, 65, TipoPokemon.FOGO, new Brasas());
    }
}