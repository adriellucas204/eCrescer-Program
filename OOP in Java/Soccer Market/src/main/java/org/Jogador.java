package org;

import java.math.BigDecimal;

public class Jogador {
    private String nome;
    protected int idade;
    private Clube clubeAtual;
    protected int reputacaoHistorica;
    private ApetiteFinanceiro apetite;
    private BigDecimal preco;

    public Jogador(String n, int i, Clube c, int rep, ApetiteFinanceiro a, BigDecimal p){
        nome = n;
        idade = i;
        clubeAtual = c;
        reputacaoHistorica = rep;
        apetite = a;
        preco = p;
    }

    public String getClubeAtual() {
        if (clubeAtual == null) {
            return "Sem Clube";
        }
        return this.clubeAtual.getNome();
    }

    public boolean temInteresse(Clube clube){
        if (clube.getReputacaoHistorica() >= this.reputacaoHistorica && clube.getReputacaoHistorica() > 0) {
            return true;
        }
        return false;
    }

    public BigDecimal valorDeCompra() {
        if (apetite.getClass() == Indiferente.class){
            return this.preco;
        } else if (apetite.getClass() == Conservador.class){
            return this.preco.multiply(new BigDecimal("1.4"));
        }
        return this.preco.multiply(new BigDecimal("1.8"));
    }

    public void transferirDeClube(Clube clube){
        this.clubeAtual = clube;
    }

}
