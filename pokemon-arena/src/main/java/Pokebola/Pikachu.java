package Pokebola;


import Movimentos.AtaqueRapido;
import Tipos.TipoPokemon;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super(35,35, 55, 40, 50, 50, 90, TipoPokemon.ELETRICO, new AtaqueRapido());
    }
}
