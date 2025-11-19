package Main;

import java.math.BigDecimal;

public class Clube {
    private String nome;
    private int reputacaoHistorica;
    private BigDecimal saldoEmCaixa;

    public Clube(String nome, int reputacaoHistorica, BigDecimal saldoEmCaixa) {
        this.nome = nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldoEmCaixa = saldoEmCaixa;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public BigDecimal getSaldoEmCaixa() {
        return saldoEmCaixa;
    }

    public void reduzirSaldoEmCaixa(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            return;
        }
        saldoEmCaixa = saldoEmCaixa.subtract(valor);
    }

    public String getNome() {
        return nome;
    }
}