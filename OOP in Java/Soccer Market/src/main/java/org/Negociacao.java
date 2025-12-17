package org;

public class Negociacao {
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse){
        if (jogadorDeInteresse.temInteresse(clubeInteressado)){
            if (clubeInteressado.getSaldo().compareTo(jogadorDeInteresse.valorDeCompra()) >= 0){
                jogadorDeInteresse.transferirDeClube(clubeInteressado);
                clubeInteressado.setSaldo(clubeInteressado.getSaldo().subtract(jogadorDeInteresse.valorDeCompra()));
                return true;
            }
        }
        return false;
    }
}
