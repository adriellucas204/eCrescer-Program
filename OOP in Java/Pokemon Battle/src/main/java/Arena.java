import java.util.List;

public class Arena {
    private Treinador treinadorA;
    private Treinador treinadorB;

    public Arena(Treinador treinadorA, Treinador treinadorB) {
        this.treinadorA = treinadorA;
        this.treinadorB = treinadorB;
    }

    public Treinador batalhar() {
        List<Pokemon> timeTreinadorA = this.treinadorA.getPokemons();
        List<Pokemon> timeTreinadorB = this.treinadorB.getPokemons();
        Item itemA = this.treinadorA.getItem();
        Item itemB = this.treinadorB.getItem();
        int contadorTurno = 1;
        Pokemon pokemonA = null;
        Pokemon pokemonB = null;
        Treinador vencedor = null;

        while (true) {
            
            //selecionar pokemons
            if (pokemonA == null) {
                if (timeTreinadorA.isEmpty()){
                    vencedor = treinadorB;
                    break;
                }
                pokemonA = timeTreinadorA.get(0);
                timeTreinadorA.remove(pokemonA);

            }

            if (pokemonB == null) {
                if (timeTreinadorB.isEmpty()){
                    vencedor = treinadorA;
                    break;
                }
                pokemonB = timeTreinadorB.get(0);
                timeTreinadorB.remove(pokemonB);
            }
            
            //usar itens
            if (itemA != null && itemA.getTurnoDeUso() == contadorTurno) {
                itemA.usarItem(pokemonA);
            }

            if (itemB != null && itemB.getTurnoDeUso() == contadorTurno) {
                itemB.usarItem(pokemonB);
            }
            
            //verificar velocidade
            if (pokemonA.getAtributos().getVelocidade() >= pokemonB.getAtributos().getVelocidade()) {
                atacar(pokemonA, pokemonB);
            } else {
                atacar(pokemonB, pokemonA);
            }

            //verificar derrotados
            if (pokemonA.foiDerrotado()){
                pokemonA = null;
            }
            if (pokemonB.foiDerrotado()){
                pokemonB = null;
            }
            contadorTurno++;

        }

        return vencedor;
    }

    private static void atacar(Pokemon pokemonB, Pokemon pokemonA) {
        int dano;
        dano = Pokemon.calcularDano(pokemonB, pokemonA);
        pokemonA.sofrerDano(dano);

        if (pokemonA.foiDerrotado()){
            return;
        }
        dano = Pokemon.calcularDano(pokemonA, pokemonB);
        pokemonB.sofrerDano(dano);
    }
}
