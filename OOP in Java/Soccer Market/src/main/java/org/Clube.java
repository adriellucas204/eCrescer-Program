package org;

import java.math.BigDecimal;

public class Clube {
    private String nome;
    private int reputacaoHistorica;
    private BigDecimal saldo;

    public Clube(String n, int rep, BigDecimal s) {
        this.nome = n;
        this.reputacaoHistorica = rep;
        this.saldo = s;
    }

    public String getNome() {
        return nome;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public void setReputacaoHistorica(int reputacaoHistorica) {
        this.reputacaoHistorica = reputacaoHistorica;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
