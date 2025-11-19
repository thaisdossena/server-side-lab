package Pokebola;

import Movimentos.Movimento;
import Tipos.TipoMovimento;
import Tipos.TipoPokemon;

public abstract class Pokemon {
    protected int pontosDeSaudeMax;
    protected int vidaAtual;
    protected int ataque;
    protected int defesa;
    protected int ataqueEspecial;
    protected int defesaEspecial;
    protected int velocidade;

    protected TipoPokemon tiposPokemon;
    protected Movimento movimento;

    public Pokemon(
            int pontosDeSaudeMax,
            int vidaAtual,
            int ataque,
            int defesa,
            int ataqueEspecial,
            int defesaEspecial,
            int velocidade,
            TipoPokemon tipoPokemon,
            Movimento movimento) {
        this.pontosDeSaudeMax = pontosDeSaudeMax;
        this.vidaAtual = vidaAtual;
        this.ataque = ataque;
        this.defesa = defesa;
        this.ataqueEspecial = ataqueEspecial;
        this.defesaEspecial = defesaEspecial;
        this.velocidade = velocidade;
        this.tiposPokemon = tipoPokemon;
        this.movimento = movimento;
    }

    public TipoPokemon getTiposPokemon() {
        return tiposPokemon;
    }

    public int getPontosDeSaudeMax() {
        return this.pontosDeSaudeMax;
    }

    public int getVidaAtual() {
        return this.vidaAtual;
    }

    public int getAtaque() {
        return this.ataque;
    }
    
    public void setAtaque(int pokemonAtacante) {
        this.ataque = pokemonAtacante;
    }

    public int getAtaqueEspecial() {
        return this.ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public int getDefesa() {
        return this.defesa;
    }

    public int getDefesaEspecial() {
        return this.defesaEspecial;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
    }

    public String falar(){
        return this.getClass().getName();
    }

    public int multiplicadorVantagem(TipoPokemon pokemonDefensor) {
        TipoPokemon pokemonAtacante = this.tiposPokemon;

        int multiplicadorVantagem = 1;

        if (pokemonAtacante == TipoPokemon.FOGO && pokemonDefensor == TipoPokemon.GRAMA) {
            multiplicadorVantagem = 2;
        }
        else if (pokemonAtacante == TipoPokemon.GRAMA && pokemonDefensor == TipoPokemon.AGUA) {
            multiplicadorVantagem = 2;
        }
        else if (pokemonAtacante == TipoPokemon.AGUA && pokemonDefensor == TipoPokemon.FOGO) {
            multiplicadorVantagem = 2;
        }
        else if (pokemonAtacante == TipoPokemon.ELETRICO && pokemonDefensor == TipoPokemon.AGUA) {
            multiplicadorVantagem = 2;
        }

        return multiplicadorVantagem;
    };

    public int calcularDano(Pokemon pokemonAdversario) {
        int poder = this.movimento.getPoder();
        
        TipoMovimento tipoMovimento = this.movimento.getTipoMovimento();
        
        TipoPokemon pokemonDefensor = pokemonAdversario.getTiposPokemon();
        
        int multiplicadorVantagem = this.multiplicadorVantagem(pokemonDefensor);
        
        double danoBruto;
        
        if (tipoMovimento == TipoMovimento.FISICO) {            
            danoBruto = 0.5 * poder * multiplicadorVantagem * ((double) this.ataque / pokemonAdversario.getDefesa());

        } else {
            danoBruto = 0.5 * poder * multiplicadorVantagem * ((double) this.ataqueEspecial / pokemonAdversario.getDefesaEspecial());
        }

        //Arredondar para cima e converter para int
        int danoFinal = (int) Math.ceil(danoBruto);

        return danoFinal;
    }
}
