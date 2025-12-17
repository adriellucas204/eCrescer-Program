package org;

import java.util.ArrayList;
import java.util.List;

public class Planeta {
    private int posicao;
    private List<Recurso> recursos;

    public Planeta(int posicao, List<Recurso> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public boolean isEmpty() {
        return recursos.isEmpty();
    }

    public int getValorTotal() {
        int valorTotal = 0;

        for (Recurso recurso : this.recursos){
            valorTotal += recurso.getValor();
        }
        return valorTotal;
    }

    public int getValorPorPesoTotal() {
        int valorPorPesoTotal = 0;

        for (Recurso recurso : this.recursos){
            valorPorPesoTotal += (recurso.getValor() / recurso.getPeso()) ;
        }
        return valorPorPesoTotal;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
}
