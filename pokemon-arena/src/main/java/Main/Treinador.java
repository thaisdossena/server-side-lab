package Main;

import Itens.Item;
import Pokebola.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Treinador {
    //Ter os atributos nome, pokemons (Lista) e item.
    private String nome;
    private List<Pokemon> pokemons;
    private Item item;

    //Ter os dois construtores (sobrecarga).
    public Treinador(String nome) {
        this.nome = nome.toString();
        this.pokemons = new ArrayList<>();
    }

    public Treinador(String nome, Item item) {
        this.nome = nome;
        this.item = item;
        this.pokemons = new ArrayList<>();
    }

    //Ter o metodo adicionarAoTime (Pokemon pokemon)

    public void adicionarAoTime(Pokemon pokemon) {
        // Regra um time pode ter no máximo 6
        if (this.pokemons.size() < 6) {
            this.pokemons.add(pokemon);
        }
    }

    void usarItem(Pokemon pokemon){
        this.pokemons.add(pokemon);
    };

    //Sobrescrever equals() e toString().
    // Define como dois objetos Treinador são comparados.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treinador treinador = (Treinador) o;
        return nome.equals(treinador.nome);
    }

    @Override
    public int hashCode() {
        // Usa o mesmo atributo (nome) que o método equals() usa.
        return Objects.hash(this.nome);
    }

    //Define o que será exibido quando um objeto Treinador
    @Override
    public String toString() {
        return this.nome;
    }

    public Item getItem() {
        return item;
    }

    public void consumirItem() {
        this.item = null;
    }

    public Pokemon getPokemonAtivo() {
        if (this.pokemons.isEmpty()) {
            return null;
        }
        return this.pokemons.get(0);
    }

    public boolean proximoPokemon() {
        if (!this.pokemons.isEmpty()) {
            this.pokemons.remove(0);
        }

        return !this.pokemons.isEmpty();
    }
}
