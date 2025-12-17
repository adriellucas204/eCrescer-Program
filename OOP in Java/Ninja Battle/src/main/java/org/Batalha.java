package org;

import java.util.Objects;

public class Batalha {
    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja){
        //verificar se eh o Itachi
        if (Objects.equals("Itachi", primeiroNinja.getNome())){
            return primeiroNinja;
        } else if (Objects.equals("Itachi", segundoNinja.getNome())){
            return segundoNinja;
        }

        //cada ninja ataca o seu oponente tres vezes
        //round 1
        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        //round 2
        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        //round 3
        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        //verificar qual tem o maior chakra
        if (primeiroNinja.getChakra() > segundoNinja.getChakra()){
            return primeiroNinja; // primeiro ninja venceu
        } else if(primeiroNinja.getChakra() < segundoNinja.getChakra()){
            return segundoNinja; //segundo ninja venceu
        }
        return primeiroNinja; //empate(primeiro ninja tem que ser retornado)
    }
}
