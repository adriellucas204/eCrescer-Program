package org;

import java.math.BigDecimal;

public class MeioCampo extends Jogador{
    public MeioCampo(String n, int i, Clube c, int rep, ApetiteFinanceiro a, BigDecimal p) {
        super(n, i, c, rep, a, p);
    }

    public BigDecimal valorDeCompra() {
        if (this.idade > 30){
            return super.valorDeCompra().multiply(new BigDecimal("0.7"));
        }
        return super.valorDeCompra();
    }

    public boolean temInteresse(Clube clube){
        if (clube.getReputacaoHistorica() <= (this.reputacaoHistorica - 2) && clube.getReputacaoHistorica() > 0) {
            return true;
        }
        return false;
    }

}
