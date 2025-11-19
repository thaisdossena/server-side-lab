package Main;

import java.math.BigDecimal;

public class Negociacao {
    //RN20: na negociação deve ser verificado se o jogador possui interesse em jogar pelo clube ofertante.
    //RN21: na negociação deve ser verificado se o clube tem como pagar o valor de compra do jogador.
    //RN22: a transferencia de clube do jogador deve ocorrer na Negociacao, desde que as RN20 e RN21 sejam positivas.
    //RN23: se efetuada a transferência, o saldo disponível em caixa do clube deve ser atualizado.
    //RN24: o unico método público da classe negociação deve ser possuir seguinte assinatura public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse).
    //RN25: de acordo com as regras descritas ao longo do enunciado, o método negociar deve retornar true quando foi possível realizar a transferência e false quando não.
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse) {
        boolean temInteresse = jogadorDeInteresse.temInteresseEmClube(clubeInteressado);
        boolean temComoPagar = clubeInteressado.getSaldoEmCaixa().compareTo(jogadorDeInteresse.getValorDeCompra()) >= 0;

        if (temInteresse && temComoPagar) {
            jogadorDeInteresse.atualizaClube(clubeInteressado);
            clubeInteressado.reduzirSaldoEmCaixa(jogadorDeInteresse.getValorDeCompra());
            return true;
        }

        return false;
    }
}