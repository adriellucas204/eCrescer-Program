package org;

import java.math.BigDecimal;

public class Lateral extends Jogador{
    private int cruzamentosCerteiros;

    public Lateral(String n, int i, Clube c, int rep, ApetiteFinanceiro a, BigDecimal p, int cr) {
        super(n, i, c, rep, a, p);
        cruzamentosCerteiros = cr;
    }

    public BigDecimal valorDeCompra() {
        if (this.idade > 28){
            return super.valorDeCompra().multiply(BigDecimal.valueOf(1 + 0.02 * cruzamentosCerteiros)).multiply(new BigDecimal("0.7"));
        }
        return super.valorDeCompra().multiply(BigDecimal.valueOf(1 + 0.02 * cruzamentosCerteiros));
    }
}
