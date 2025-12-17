package org;

public class Jutsu {
    private int chakra;
    private int dano;

    public Jutsu(int chakra, int dano){
        if (chakra > 5){
            this.chakra = 5;
        } else {
            this.chakra = chakra;
        }

        if (dano > 10){
            this.dano = 10;
        } else {
            this.dano = dano;
        }
    }

    public int getChakra() {
        return this.chakra;
    }

    public int getDano() {
        return this.dano;
    }
}
