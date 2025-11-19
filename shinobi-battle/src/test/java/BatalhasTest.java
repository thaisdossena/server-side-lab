import org.junit.Assert;
import org.junit.Test;


public class BatalhasTest {
    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakra() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja ninjaAtacante = new Ninja("Naruto", jutsuNinjaAtacante);

        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja ninjaOponente = new Ninja("Gaara", jutsuNinjaOponente);

        int nivelChakraEsperado = 90;

        ninjaAtacante.atacar(ninjaOponente);

        Assert.assertEquals(nivelChakraEsperado, ninjaOponente.getChakra());
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi () {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Itachi", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Pain", jutsuNinjaDois);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaVencedor, ninjaUm);
    }

    @Test
    public void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi () {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naturo", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Itachi", jutsuNinjaDois);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaVencedor, ninjaDois);
    };

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar () {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Pain", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Madara", jutsuNinjaDois);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaVencedor, ninjaUm);
    };

    @Test
    public void deveRetornarSegundoNinjaComoVencedor () {
        Jutsu jutsuNinjaUm = new Jutsu(2, 6);
        Ninja ninjaUm = new Ninja("Lee", jutsuNinjaUm);

        Jutsu jutsuSegundoNinja = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Naruto", jutsuSegundoNinja);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertSame(ninjaVencedor, ninjaDois);
    };

    @Test
    public void danoNaoPodeSerMaiorQueDez () {
        Jutsu jutsu = new Jutsu(3, 20);

        Assert.assertEquals(10, jutsu.getDano());
    };
    @Test
    public void quantidadeDeChakraNaoPodeSerMaiorQueCinco () {
        Jutsu jutsu = new Jutsu(8, 5);

        Assert.assertEquals(5, jutsu.getQuantidadeChakra());
    };

    @Test
    public void quantidadeDeChakraNaoPodeSerMenorQueZero () {
        Jutsu jutsu = new Jutsu(-3, 5);

        Assert.assertEquals(0, jutsu.getQuantidadeChakra());
    };
}
