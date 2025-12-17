package org;

import java.util.ArrayList;
import java.util.List;

public class Nave {
    private int posicao;
    private int quantCombustivel;

    public Nave(int combustivel) {
        this.quantCombustivel = combustivel;
        this.posicao = 0;
    }

    public int getQuantidadeDeCombustivel() {
        return quantCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    //retornar uma lista vazia se n conseguiu recursos
    public List<Recurso> explorar(Planeta planeta) {
        int distanciaIdaVolta = planeta.getPosicao() * 2;
        int distanciaMaxPossivel = this.quantCombustivel / 3; // que a nave consegue viajar
        this.quantCombustivel = distanciaMaxPossivel > distanciaIdaVolta ? this.quantCombustivel - distanciaIdaVolta * 3 : this.quantCombustivel % 3;
        List<Recurso> recursosNave = new ArrayList<Recurso>();

        if (distanciaMaxPossivel >= planeta.getPosicao()) {
            for (Recurso recurso : planeta.getRecursos()) {
                recursosNave.add(recurso);
            }
            this.posicao = distanciaMaxPossivel >= distanciaIdaVolta ? 0 : distanciaIdaVolta - distanciaMaxPossivel;

            return recursosNave;
        }

        this.posicao = distanciaMaxPossivel;

        return recursosNave;
    }

    //varios planetas
    public List<Recurso> explorar(List<Planeta> planetas) {
        int distanciaIdaVolta = planetas.get(planetas.size() - 1).getPosicao() * 2;
        int distanciaUltimoPlaneta = planetas.get(planetas.size() - 1).getPosicao();
        int distanciaMaxPossivel = this.quantCombustivel / 3; // que a nave consegue viajar
        this.quantCombustivel = distanciaMaxPossivel > distanciaIdaVolta ? this.quantCombustivel - distanciaIdaVolta * 3 : this.quantCombustivel % 3;
        List<Recurso> recursosNave = new ArrayList<Recurso>();

        //pegar recursos de cada planeta se a distancia maxima possivel de viajar eh maior que a posicao do planeta
        for (Planeta planeta : planetas){
            if (distanciaMaxPossivel >= planeta.getPosicao()) {
                for (Recurso recurso : planeta.getRecursos()) {
                    recursosNave.add(recurso);
                }
            }
        }

        //atualizar posicao
        if (distanciaMaxPossivel > distanciaUltimoPlaneta){
            this.posicao = distanciaMaxPossivel >= distanciaIdaVolta ? 0 : distanciaIdaVolta - distanciaMaxPossivel;
        } else {
            this.posicao = distanciaMaxPossivel;
        }

        return recursosNave;

    }
}
