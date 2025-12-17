public class Movimento {
    private int poder;
    private final TipoMovimento tipoDeMovimento;

    public Movimento(int poder, TipoMovimento tipo){
        this.poder = poder;
        this.tipoDeMovimento = tipo;
    }

    public int getPoder() {
        return poder;
    }

    public TipoMovimento getTipoDeMovimento() {
        return tipoDeMovimento;
    }
}
