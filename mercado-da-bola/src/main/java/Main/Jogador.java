package Main;

import ApetiteFinancerio.TipoDeApetite;

import java.math.BigDecimal;

public abstract class Jogador {
    private final String nome;
    protected int idade;
    protected int reputacaoHistorica;
    protected Clube clubeAtual;
    protected BigDecimal preco;
    private TipoDeApetite apetiteFinanceiro;//RN03

    public Jogador(String nome, int idade, int reputacaoHistorica, Clube clube, BigDecimal preco, TipoDeApetite apetiteFinanceiro) {
        this.nome = nome;
        this.idade = idade;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.clubeAtual = clube;
        this.reputacaoHistorica = reputacaoHistorica;
        this.preco = preco;
    }

    //RN01
    public String getNomeClube() {
        if (clubeAtual == null) {
            return "Sem clube!";
        }
        return clubeAtual.getNome();
    }

    //RN02
    public int getReputacaoHistorica() {
        if(reputacaoHistorica < 0 ) {
            reputacaoHistorica = 0;
        }
        if(reputacaoHistorica > 10 ) {
            reputacaoHistorica = 10;
        }
        return reputacaoHistorica;
    }

    //RN07
    public void atualizaClube(Clube clube) {
        this.clubeAtual = clube;
    }

    //RN04
    public Boolean temInteresseEmClube(Clube clube) {
        if (clube.getReputacaoHistorica() >= 1) {
            return true;
        }
        return false;
    }

    //RN06
    public BigDecimal getValorDeCompra() {
      return this.preco.multiply(this.apetiteFinanceiro.getPercentual());
    }
}
