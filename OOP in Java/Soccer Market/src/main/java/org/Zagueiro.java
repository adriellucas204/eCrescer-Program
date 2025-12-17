package org;

import java.math.BigDecimal;

public class Zagueiro extends Jogador{
    public Zagueiro(String n, int i, Clube c, int rep, ApetiteFinanceiro a, BigDecimal p) {
        super(n, i, c, rep, a, p);
    }

    public BigDecimal valorDeCompra() {
        if (this.idade > 30){
            return super.valorDeCompra().multiply(new BigDecimal("0.8"));
        }
        return super.valorDeCompra();
    }



}
