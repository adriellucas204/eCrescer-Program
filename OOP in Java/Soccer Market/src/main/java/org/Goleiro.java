package org;

import java.math.BigDecimal;

public class Goleiro extends Jogador {
    private int penaltisDefendidos;

    public Goleiro(String n, int i, Clube c, int rep, ApetiteFinanceiro a, BigDecimal p, int def) {
        super(n, i, c, rep, a, p);
        penaltisDefendidos = def;
    }

    public BigDecimal valorDeCompra() {
        return super.valorDeCompra().multiply(BigDecimal.valueOf( 1 + 0.04 * penaltisDefendidos));
    }

}
