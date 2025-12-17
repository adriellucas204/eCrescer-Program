package org;

import java.math.BigDecimal;

public class Atacante extends Jogador {
    int golsFeitos;

    public Atacante(String n, int i, Clube c, int rep, ApetiteFinanceiro a, BigDecimal p, int gol) {
        super(n, i, c, rep, a, p);
        golsFeitos = gol;
    }

    public BigDecimal valorDeCompra() {
        if (this.idade > 30){
            //return super.valorDeCompra() * (1 + 0.01 * golsFeitos) * 0.75;
            return super.valorDeCompra().multiply(BigDecimal.valueOf(1 + 0.01 * golsFeitos)).multiply(new BigDecimal("0.75"));
        }
        return super.valorDeCompra().multiply(BigDecimal.valueOf(1 + 0.01 * golsFeitos));
    }

    public boolean temInteresse(Clube clube){
        if (clube.getReputacaoHistorica() > this.reputacaoHistorica && clube.getReputacaoHistorica() > 0) {
            return true;
        }
        return false;
    }
}
