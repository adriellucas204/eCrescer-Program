package org;

public class Ninja {
    private String nome;
    private Jutsu jutsu;
    private int chakraQuant;

    public Ninja(String nome, Jutsu jutsu){
        this.nome = nome;
        this.jutsu = jutsu;
        this.chakraQuant = 100;
    }

    public void atacar(Ninja oponente){
        oponente.receberGolpe(this.jutsu.getDano()); // oponente recebe golpe
        this.chakraQuant -= this.jutsu.getChakra(); // o ninja que atacou perde chakra
    }

    public void receberGolpe(int danoRecebido){
        this.chakraQuant -= danoRecebido; // perde chakra ao receber golpe
    }

    public int getChakra(){
        return this.chakraQuant;
    }

    public String getNome(){
        return this.nome;
    }

}
