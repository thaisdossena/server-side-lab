package TiposDeJogadores;

import ApetiteFinancerio.ApetiteFinanceiro;
import ApetiteFinancerio.TipoDeApetite;
import Main.Clube;
import Main.Jogador;

import java.math.BigDecimal;

public class Atacante extends Jogador{
    private double descontoPorIdade = 0.25;
    private int idadeDoDesconto = 30;
    private double acrescimoPorGol = 0.01;
    private int quantidadeDeGolsNoAno;//RN16

    //RN16
    public Atacante(String nome, int idade, int reputacaoHistorica, Clube clube, BigDecimal preco, TipoDeApetite apetiteFinanceiro, int quantidadeDeGolsNoAno) {
        super(nome, idade, reputacaoHistorica, clube, preco, apetiteFinanceiro);
        this.quantidadeDeGolsNoAno = quantidadeDeGolsNoAno;
    }

    //RN17,RN18
    @Override
    public BigDecimal getValorDeCompra() {
        //RN17
        BigDecimal acrescimo = BigDecimal.valueOf(quantidadeDeGolsNoAno).multiply(BigDecimal.valueOf(acrescimoPorGol)).add(BigDecimal.valueOf(1));
        BigDecimal valorDeCompra = super.getValorDeCompra().multiply(acrescimo);

        //RN18
        if (idade > idadeDoDesconto) {
            BigDecimal desconto = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(descontoPorIdade));
            return valorDeCompra.multiply(desconto);
        }

        return valorDeCompra;
    }

    //RN19
    @Override
    public Boolean temInteresseEmClube(Clube clube) {
        if (clube.getReputacaoHistorica() > this.reputacaoHistorica) {
            return true;
        }
        return false;
    }
}
