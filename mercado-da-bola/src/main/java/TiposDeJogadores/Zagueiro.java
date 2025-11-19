package TiposDeJogadores;

import ApetiteFinancerio.TipoDeApetite;
import Main.Clube;
import Main.Jogador;

import java.math.BigDecimal;

public class Zagueiro extends Jogador {
    private double descontoPorIdade = 0.2;
    private int idadeDoDesconto = 30;

    public Zagueiro(String nome, int idade, int reputacaoHistorica, Clube clube, BigDecimal preco, TipoDeApetite apetiteFinanceiro) {
        super(nome, idade, reputacaoHistorica, clube, preco, apetiteFinanceiro);
    }

    //RN10
    @Override
    public BigDecimal getValorDeCompra() {
        if (idade > idadeDoDesconto) {
            BigDecimal desconto = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(descontoPorIdade));
            return super.getValorDeCompra().multiply(desconto);
        }

        return super.getValorDeCompra();
    }
}