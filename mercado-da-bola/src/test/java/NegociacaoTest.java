import ApetiteFinancerio.TipoDeApetite;
import Main.Clube;
import Main.Jogador;
import Main.Negociacao;
import TiposDeJogadores.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NegociacaoTest {
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, 8, null, BigDecimal.valueOf(800500), TipoDeApetite.INDIFERENTE, 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        Negociacao negociacao = new Negociacao();

        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, 10, null, BigDecimal.valueOf(800500), TipoDeApetite.CONSERVADOR, 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Al-Wasl", 8, BigDecimal.valueOf(250000000));
        Clube clubeInteressado = new Clube("Fortaleza", 7, BigDecimal.valueOf(8000000));
        Zagueiro zagueiro = new Zagueiro("Adryelson", 26, 7, clubeAtual, BigDecimal.valueOf(10000000), TipoDeApetite.MERCENARIO);

        boolean foiPossivelNegociar = negociacao.negociar(clubeInteressado, zagueiro);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void jogadorNaoTemInteresseNoClube() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Napoli", 8, BigDecimal.valueOf(400000000));
        Clube clubeInteressado = new Clube("Everton", 9, BigDecimal.valueOf(350000000));
        MeioCampo meioCampo = new MeioCampo("Kevin De Bruyne", 33, 10, clubeAtual, BigDecimal.valueOf(20000000), TipoDeApetite.CONSERVADOR);

        boolean temInteresse = negociacao.negociar(clubeInteressado, meioCampo);

        Assert.assertFalse(temInteresse);
    }

    @Test
    public void jogadorTemInteresseNoClube() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Real Madrid", 9, BigDecimal.valueOf(950000000));
        Clube clubeInteressado = new Clube("Manchester City", 10, BigDecimal.valueOf(1200000000));
        Lateral lateral = new Lateral("Dani Carvajal", 32, 9, clubeAtual, BigDecimal.valueOf(5200000), TipoDeApetite.INDIFERENTE, 2);

        boolean temInteresse = negociacao.negociar(clubeInteressado, lateral);

        Assert.assertTrue(temInteresse);
    }

    @Test
    public void calculaDescontoPorIdadeDeUmZagueiro() {
        Clube clubeAtual = new Clube("Internazionale", 8, BigDecimal.valueOf(750000000));
        Zagueiro zagueiroVeterano = new Zagueiro("Stefan de Vrij", 33, 8, clubeAtual, BigDecimal.valueOf(6000000), TipoDeApetite.CONSERVADOR);

        BigDecimal valorDeCompra = zagueiroVeterano.getValorDeCompra();
        BigDecimal valorEsperado = BigDecimal.valueOf(6720000);

        Assert.assertEquals(valorEsperado.compareTo(valorDeCompra), 0);
    }

    @Test
    public void testaInteresseDeTrocaDeTimeDeUmMeioCampo() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Real Madrid", 9, BigDecimal.valueOf(950000000));
        Clube clubeInteressado = new Clube("Internazionale", 8, BigDecimal.valueOf(750000000));
        MeioCampo meioCampo = new MeioCampo("Luka Modrić", 39, 10, clubeAtual, BigDecimal.valueOf(7000000), TipoDeApetite.CONSERVADOR);

        boolean temInteresse = negociacao.negociar(clubeInteressado, meioCampo);

        Assert.assertTrue(temInteresse);
    }

    @Test
    public void testaInteresseDeTrocaDeTimeDeUmAtacante() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Manchester City", 10, BigDecimal.valueOf(1200000000));
        Clube clubeInteressado = new Clube("Flamengo", 8, BigDecimal.valueOf(500000000));
        Atacante atacante = new Atacante("Gabriel Barbosa", 28, 7, clubeAtual, BigDecimal.valueOf(15000000), TipoDeApetite.MERCENARIO, 9);

        boolean temInteresse = negociacao.negociar(clubeInteressado, atacante);

        Assert.assertTrue(temInteresse);
    }

    @Test
    public void testaInteresseDeTrocaDeTimeDeUmGoleiro() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Liverpool", 9, BigDecimal.valueOf(950000000));
        Clube clubeInteressado = new Clube("Ibis Sport Club", 0, BigDecimal.valueOf(500000));
        Goleiro goleiro = new Goleiro("Alisson Becker", 33, 9, clubeAtual, BigDecimal.valueOf(12000000), TipoDeApetite.CONSERVADOR, 1);

        boolean temInteresse = negociacao.negociar(clubeInteressado, goleiro);

        Assert.assertFalse(temInteresse);
    }

    @Test
    public void calculaValorDeCompraDeUmAtacante() {
        Clube clubeAtual = new Clube("Barcelona", 9, BigDecimal.valueOf(980000000));
        Atacante atacante = new Atacante("Robert Lewandowski", 36, 9, clubeAtual, BigDecimal.valueOf(18000000), TipoDeApetite.CONSERVADOR, 9);

        BigDecimal valorDeCompra = atacante.getValorDeCompra();
        BigDecimal valorEsperado = BigDecimal.valueOf(20601000);

        Assert.assertEquals(valorEsperado.compareTo(valorDeCompra), 0);
    }


    @Test
    public void calculaValorDeCompraDeUmLateral() {
        Clube clubeAtual = new Clube("Chelsea", 8, BigDecimal.valueOf(750000000));
        Lateral lateral = new Lateral("Reece James", 25, 8, clubeAtual, BigDecimal.valueOf(6500000), TipoDeApetite.INDIFERENTE, 24);

        BigDecimal valorDeCompra = lateral.getValorDeCompra();
        BigDecimal valorEsperado = BigDecimal.valueOf(9620000);

        Assert.assertEquals(valorEsperado.compareTo(valorDeCompra), 0);

    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        Clube clubeAtual = new Clube("Bayer Leverkusen", 8, BigDecimal.valueOf(600000000));
        MeioCampo meioCampo = new MeioCampo("Granit Xhaka", 33, 8, clubeAtual, BigDecimal.valueOf(5500000), TipoDeApetite.CONSERVADOR);

        BigDecimal valorDeCompra = meioCampo.getValorDeCompra();
        BigDecimal valorEsperado = BigDecimal.valueOf(5390000);

        Assert.assertEquals(valorEsperado.compareTo(valorDeCompra), 0);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        Clube clubeAtual = new Clube("Bayer Leverkusen", 8, BigDecimal.valueOf(600000000));
        MeioCampo meioCampo = new MeioCampo("Granit Xhaka", 28, 8, clubeAtual, BigDecimal.valueOf(5500000), TipoDeApetite.CONSERVADOR);

        BigDecimal valorDeCompra = meioCampo.getValorDeCompra();
        BigDecimal valorEsperado = BigDecimal.valueOf(7700000);

        Assert.assertEquals(valorEsperado.compareTo(valorDeCompra), 0);
    }



    @Test
    public void deveRetornarSemClubeSeTimeNulo() {
        Jogador jogador = new Atacante("Rafael Souza", 19, 3, null, BigDecimal.valueOf(250000), TipoDeApetite.INDIFERENTE, 11);
        String mensagemEsperada = "Sem clube!";
        String clubeAtual = jogador.getNomeClube();

        Assert.assertEquals(mensagemEsperada,clubeAtual);
    }

    @Test
    public void deveRetornarNomeDoTime() {
        Clube clube = new Clube("São Paulo FC", 8, BigDecimal.valueOf(450000000));
        Jogador jogador = new MeioCampo("Lucas Pereira", 24, 6, clube, BigDecimal.valueOf(800000), TipoDeApetite.CONSERVADOR);
        String clubeAtual = jogador.getNomeClube();

        Assert.assertEquals(clube.getNome(),clubeAtual);
    }

    @Test
    public void testarReputacaoNegativa() {
        Clube clube = new Clube("Íbis Sport Club", -1, BigDecimal.valueOf(500000));
        Jogador jogador = new MeioCampo("João Henrique", 21, -1, clube, BigDecimal.valueOf(200000), TipoDeApetite.INDIFERENTE);

        int reputacao = jogador.getReputacaoHistorica();
        int reputacaoEsperada = 0;

        Assert.assertEquals(reputacaoEsperada,reputacao);
    }

    @Test
    public void testarReputacaoPositiva() {
        Clube clube = new Clube("Manchester City", 15, BigDecimal.valueOf(1200000000));
        Jogador jogador = new Atacante("Erling Haaland", 25, 15, clube, BigDecimal.valueOf(25000000), TipoDeApetite.CONSERVADOR, 9);

        int reputacao = jogador.getReputacaoHistorica();
        int reputacaoEsperada = 10;

        Assert.assertEquals(reputacaoEsperada,reputacao);
    }

    @Test
    public void reduzDinheiroEmCaixaAposCompraDeJogador() {
        Negociacao negociacao = new Negociacao();

        Clube clubeAtual = new Clube("Manchester City", 10, BigDecimal.valueOf(1200000000));
        Clube clubeInteressado = new Clube("Flamengo", 8, BigDecimal.valueOf(500000000));
        Atacante atacante = new Atacante("Gabriel Barbosa", 28, 7, clubeAtual, BigDecimal.valueOf(15000000), TipoDeApetite.MERCENARIO, 9);

        BigDecimal saldoInicial = clubeInteressado.getSaldoEmCaixa();
        BigDecimal valorCompra = atacante.getValorDeCompra();
        BigDecimal abateValorNoSaldo = saldoInicial.subtract(valorCompra);

        BigDecimal saldoAtualizadoEsperado = BigDecimal.valueOf(470570000);

        Assert.assertEquals(saldoAtualizadoEsperado.compareTo(abateValorNoSaldo), 0);
    }
}