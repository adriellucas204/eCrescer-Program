public class Charmander extends Pokemon {
    Movimento Brasas;

    public Charmander() {
        super(new PokemonAttributes("Charmander", 39, 52, 43, 60, 50, 65, new Movimento(70, TipoMovimento.ESPECIAL), TipoPokemon.FOGO));
    }

}
