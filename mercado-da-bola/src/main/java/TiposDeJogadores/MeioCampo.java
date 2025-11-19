package TiposDeJogadores;

import ApetiteFinancerio.ApetiteFinanceiro;
import ApetiteFinancerio.TipoDeApetite;
import Main.Clube;
import Main.Jogador;

import java.math.BigDecimal;

public class MeioCampo extends Jogador {
    private double descontoPorIdade = 0.3;
    private int idadeDoDesconto = 30;

    public MeioCampo(String nome, int idade, int reputacaoHistorica, Clube clube, BigDecimal preco, TipoDeApetite apetiteFinanceiro) {
        super(nome, idade, reputacaoHistorica, clube, preco, apetiteFinanceiro);
    }

    //RN11
    @Override
    public BigDecimal getValorDeCompra() {
        if (idade > idadeDoDesconto) {
            BigDecimal desconto = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(descontoPorIdade));
            return super.getValorDeCompra().multiply(desconto);
        }

        return super.getValorDeCompra();
    }

    //RN12
    @Override
    public Boolean temInteresseEmClube(Clube clube) {
        if ((this.reputacaoHistorica - clube.getReputacaoHistorica()) >= 2) {
            return true;
        }
        return false;
    }
}