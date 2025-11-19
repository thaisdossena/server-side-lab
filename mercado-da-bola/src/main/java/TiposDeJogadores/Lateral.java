package TiposDeJogadores;

import ApetiteFinancerio.ApetiteFinanceiro;
import ApetiteFinancerio.TipoDeApetite;
import Main.Clube;
import Main.Jogador;

import java.math.BigDecimal;

public class Lateral extends Jogador {
    private double descontoPorIdade = 0.3;
    private int idadeDoDesconto = 28;
    private double acrescimoPorCruzamentoCerteiro = 0.02;
    private int quantidadeDeCruzamentosCerteiros;//RN13

    //RN13
    public Lateral(String nome, int idade, int reputacaoHistorica, Clube clube, BigDecimal preco, TipoDeApetite apetiteFinanceiro, int quantidadeDeCruzamentosCerteiros) {
        super(nome, idade, reputacaoHistorica, clube, preco, apetiteFinanceiro);
        this.quantidadeDeCruzamentosCerteiros = quantidadeDeCruzamentosCerteiros;
    }

    //RN14,RN15
    @Override
    public BigDecimal getValorDeCompra() {
        BigDecimal acrescimo = BigDecimal.valueOf(quantidadeDeCruzamentosCerteiros).multiply(BigDecimal.valueOf(acrescimoPorCruzamentoCerteiro)).add(BigDecimal.valueOf(1));
        BigDecimal valorDeCompra = super.getValorDeCompra().multiply(acrescimo);

        //RN15
        if (idade > idadeDoDesconto) {
            BigDecimal desconto = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(descontoPorIdade));
            return valorDeCompra.multiply(desconto);
        }

        return valorDeCompra;
    }
}