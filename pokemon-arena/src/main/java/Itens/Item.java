package Itens;

import Pokebola.Pokemon;

public interface Item {
    void usarItem(Pokemon pokemon);
    int getTurnoDeAcionamento();
}
