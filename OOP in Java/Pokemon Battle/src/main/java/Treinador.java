import java.util.ArrayList;
import java.util.List;

public class Treinador {
    private String nome; // nome proprio
    private List<Pokemon> pokemons; // lista de pokemons (tambem poderia ser um array)
    private Item item; // item para usar, por vezes recebe null

    public Treinador(String nome, Item item) {
        this.nome = nome;
        this.item = item;
        this.pokemons = new ArrayList<>();
    }

    public Treinador(String nome) {
        this(nome, null);
    }

    public void adicionarAoTime(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Treinador){
            Treinador treinador = (Treinador) o;
            return this.nome.equals(treinador.nome);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
