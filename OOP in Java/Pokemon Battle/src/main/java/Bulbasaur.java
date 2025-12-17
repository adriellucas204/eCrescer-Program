public class Bulbasaur extends Pokemon {
    Movimento FolhaNavalha;

    public Bulbasaur() {
        super(new PokemonAttributes("Bulbasaur", 45, 49, 49, 65, 65, 45, new Movimento(60, TipoMovimento.FISICO), TipoPokemon.GRAMA));
    }
}
