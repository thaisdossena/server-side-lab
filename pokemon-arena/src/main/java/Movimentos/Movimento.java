package Movimentos;

import Tipos.TipoMovimento;

public abstract class Movimento {
    protected int poder;
    protected TipoMovimento movimento;

    public Movimento(TipoMovimento movimento, int poder) {
        this.movimento = movimento;
        this.poder = poder;
    }

    public int getPoder() {
        return poder;
    }

    public TipoMovimento getTipoMovimento() {
        return this.movimento;
    }
}