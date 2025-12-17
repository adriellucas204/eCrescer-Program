public class Pikachu extends Pokemon {
    public Pikachu() {
        super(new PokemonAttributes("Pikachu", 35, 55, 40, 50, 50, 90, new Movimento(60, TipoMovimento.FISICO), TipoPokemon.ELETRICO));
    }
}
