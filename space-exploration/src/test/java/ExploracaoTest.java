import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExploracaoTest {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        int combustivelEsperado = 1;
        Nave milleniumFalcon = new Nave(10);
        Planeta tatooine = new Planeta(4, new ArrayList<>());

        List<Recurso> recursos = milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        Assert.assertTrue(recursos.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        Planeta vazio = new Planeta(5, new ArrayList<Recurso>());
        Assert.assertEquals(0, vazio.getValorTotal());
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        ArrayList<Recurso> lista = new ArrayList<>();
        lista.add(new Recurso("Água", 180, 10));
        lista.add(new Recurso("Oxigênio", 300, 2));
        lista.add(new Recurso("Ouro", 120, 25));
        Planeta p = new Planeta(2, lista);

        int esperado = 180 + 300 + 120;
        Assert.assertEquals(esperado, p.getValorTotal());
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        Planeta vazio = new Planeta(3, new ArrayList<Recurso>());
        Assert.assertEquals(0, vazio.getValorPorPeso());
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        ArrayList<Recurso> lista = new ArrayList<>();

        lista.add(new Recurso("Água", 180, 10));
        lista.add(new Recurso("Oxigênio", 300, 2));
        lista.add(new Recurso("Ouro", 120, 25));
        Planeta p = new Planeta(7, lista);

        Assert.assertEquals(172, p.getValorPorPeso());
    }

    @Test
    public void deveColetarRecursosEVoltarParaBaseQuandoHaCombustivelSuficiente() {
        ArrayList<Recurso> recursos = new ArrayList<>();
        recursos.add(new Recurso("Água", 180, 10));
        recursos.add(new Recurso("Oxigênio", 300, 2));
        Planeta planeta = new Planeta(4, recursos);

        Nave nave = new Nave(30);

        ArrayList<Recurso> coletados = (ArrayList<Recurso>) nave.explorar(planeta);

        Assert.assertEquals("Deveria voltar para a base (posição 0)", 0, nave.getPosicao());
        Assert.assertEquals("Combustível deveria sobrar 6", 6, nave.getQuantidadeDeCombustivel());
        Assert.assertEquals("Deveria retornar 2 recursos", 2, coletados.size());
        Assert.assertEquals("Primeiro recurso deve ser Água", "Água", coletados.get(0).getNome());
        Assert.assertEquals("Segundo recurso deve ser Oxigênio", "Oxigênio", coletados.get(1).getNome());
    }
}
