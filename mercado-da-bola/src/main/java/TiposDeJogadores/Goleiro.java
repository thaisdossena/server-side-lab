package TiposDeJogadores;

import ApetiteFinancerio.ApetiteFinanceiro;
import ApetiteFinancerio.TipoDeApetite;
import Main.Clube;
import Main.Jogador;

import java.math.BigDecimal;

public class Goleiro extends Jogador {
    private int penaltisDefendidosNoAno;//RN08

    //RN08
    public Goleiro(String nome, int idade, int reputacaoHistorica, Clube clube, BigDecimal preco, TipoDeApetite apetiteFinanceiro, int penaltisDefendidosNoAno) {
        super(nome, idade, reputacaoHistorica, clube, preco, apetiteFinanceiro);
        this.penaltisDefendidosNoAno = penaltisDefendidosNoAno;
    }

    //RN09
    @Override
    public BigDecimal getValorDeCompra() {
        BigDecimal acrescimo = BigDecimal.valueOf(penaltisDefendidosNoAno).multiply(BigDecimal.valueOf(0.04)).add(BigDecimal.valueOf(1));
        return super.getValorDeCompra().multiply(acrescimo);
    }
}