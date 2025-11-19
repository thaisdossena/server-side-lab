import Itens.AtaqueEspecialX;
import Itens.AtaqueX;
import Itens.Item;
import Itens.Pocao;
import Main.Arena;
import Main.Treinador;
import Movimentos.Movimento;
import Movimentos.Bolhas;
import Tipos.TipoMovimento;
import Pokebola.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BatalhasTest {
    @Test
    public void deveEncerrarBatalhaComVitoriaDeAsh() {
        Treinador red = new Treinador("Red");
        red.adicionarAoTime(new Charmander());

        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());

        Arena arena = new Arena(red, ash);
        Treinador vencedor = arena.batalhar();

        assertEquals(ash, vencedor);
    }

    @Test
    public void deveEncerrarBatalhaComVitoriaDeAshMesmoAposInverterAOrdem() {
        // Cenário: Ash (Squirtle) vs Red (Charmander)
        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());

        Treinador red = new Treinador("Red");
        red.adicionarAoTime(new Charmander());

        Arena arena = new Arena(ash, red);
        Treinador vencedor = arena.batalhar();

        assertEquals(ash, vencedor);
    }

    @Test
    public void deveEncerrarBatalhaComVitoriaDeRedDevidoAPocao() {
        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());

        Treinador red = new Treinador("Red", new Pocao());
        red.adicionarAoTime(new Squirtle());

        Arena arena = new Arena(ash, red);
        Treinador vencedor = arena.batalhar();

        assertEquals(red, vencedor);
    }

    @Test
    public void deveEncerrarComVitoriaDeRedDevidoAItemApelao() {
        Treinador red = new Treinador("Red", new AtaqueEspecialX());
        red.adicionarAoTime(new Charmander());

        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());
        ash.adicionarAoTime(new Bulbasaur());
        ash.adicionarAoTime(new Charmander());

        Arena arena = new Arena(red, ash);
        Treinador vencedor = arena.batalhar();

        assertEquals(red, vencedor);
    }

    @Test
    public void deveEncerrarComVitoriaDeAshDevidoAVelocidadeDePikachu() {
        Treinador red = new Treinador("Red", new AtaqueEspecialX());
        red.adicionarAoTime(new Charmander());

        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());
        ash.adicionarAoTime(new Pikachu());

        Arena arena = new Arena(red, ash);

        Treinador vencedor = arena.batalhar();
        assertEquals(ash, vencedor);
    }

    //Testes extras
    @Test
    public void deveAumentarOStatusDeAtaqueComAtaqueX() {
        Item ataqueX = new AtaqueX();
        Pokemon pokemon = new Charmander();
        int ataqueEsperado = pokemon.getAtaque() + 200;

        ataqueX.usarItem(pokemon);
        int ataqueAtual = pokemon.getAtaque();

        assertEquals(ataqueEsperado, ataqueAtual);
    }

    @Test
    public void deveCurarPokemonAteOVidaMaxima() {
        Item pocao = new Pocao();
        Pokemon pokemon = new Charmander();
        pokemon.receberDano(20);
        int vidaMaxima = pokemon.getPontosDeSaudeMax();

        pocao.usarItem(pokemon);
        int vidaAtual = pokemon.getVidaAtual();

        assertEquals(vidaMaxima, vidaAtual);
    }

    @Test
    public void deveRetornarNuloSeTimeVazio() {
        Treinador treinador = new Treinador("Ash");

        Pokemon pokemonAtivo = treinador.getPokemonAtivo();

        assertNull(pokemonAtivo);
    }

    @Test
    public void deveCriarMovimentoBolhasCorretamente() {
        Movimento bolhas = new Bolhas();

        assertEquals(75, bolhas.getPoder());
        assertEquals(TipoMovimento.ESPECIAL, bolhas.getTipoMovimento());
    }

    @Test
    public void deveRetornarVantagemDoisParaGramaContraAgua() {
        Pokemon atacante = new Bulbasaur();
        Pokemon defensor = new Squirtle();

        int multiplicador = atacante.multiplicadorVantagem(defensor.getTiposPokemon());

        assertEquals(2, multiplicador);
    }

    @Test
    public void deveRetornarVantagemDoisParaEletricoContraAgua() {
        Pokemon atacante = new Pikachu();
        Pokemon defensor = new Squirtle();


        int multiplicador = atacante.multiplicadorVantagem(defensor.getTiposPokemon());


        assertEquals(2, multiplicador);
    }

    @Test
    public void deveRetornarVantagemUmParaDanoNeutro() {
        Pokemon atacante = new Charmander();
        Pokemon defensor = new Squirtle();

        int multiplicador = atacante.multiplicadorVantagem(defensor.getTiposPokemon());

        assertEquals(1, multiplicador);
    }

    @Test
    public void deveRetornarTurnoDeAcionamentoUm() {
        Item item = new AtaqueX();

        int turno = item.getTurnoDeAcionamento();

        assertEquals(1, turno);
    }

    @Test
    public void deveRetornarMesmoHashCodeParaTreinadoresIguais() {
        Treinador treinadorA = new Treinador("Red");
        Treinador treinadorB = new Treinador("Red");

        int hashA = treinadorA.hashCode();
        int hashB = treinadorB.hashCode();

        assertEquals(treinadorA, treinadorB);
        assertEquals(hashA, hashB);
    }

    @Test
    public void deveRetornarHashCodesDiferentesParaTreinadoresDiferentes() {
        Treinador treinadorA = new Treinador("Red");
        Treinador treinadorB = new Treinador("Blue");

        int hashA = treinadorA.hashCode();
        int hashB = treinadorB.hashCode();

        assertNotEquals(treinadorA, treinadorB);
        assertNotEquals(hashA, hashB);
    }
}

