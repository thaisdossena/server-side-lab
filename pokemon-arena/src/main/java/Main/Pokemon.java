package Main;

import Movimentos.Movimento;
import Tipos.TipoMovimento;
import Tipos.TipoPokemon;

public abstract class Pokemon {
    protected int pontosDeSaude;
    protected int ataque;
    protected int defesa;
    protected int ataqueEspecial;
    protected int defesaEspecial;
    protected int velocidade;
    protected TipoPokemon tiposPokemon;
    protected Movimento movimento;

    public Pokemon(
            int pontosDeSaude,
            int ataque,
            int defesa,
            int ataqueEspecial,
            int defesaEspecial,
            int velocidade,
            TipoPokemon tiposPokemon,
            Movimento movimento) {
        this.pontosDeSaude = pontosDeSaude;
        this.ataque = ataque;
        this.defesa = defesa;
        this.ataqueEspecial = ataqueEspecial;
        this.defesaEspecial = defesaEspecial;
        this.velocidade = velocidade;
        this.tiposPokemon = tiposPokemon;
        this.movimento = movimento;
    }

    public void receberDano(int dano) {
        this.pontosDeSaude -= dano;
    }

    public String falar(){
        return this.getClass().getName();
    }

    public int calcularDano(Pokemon pokemonAdversario) {
        // retorna o dano que aquele pokemon ira causar ao adversário
        return 0;
    };
}
