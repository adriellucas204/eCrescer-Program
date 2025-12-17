import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon {
    private PokemonAttributes atributos;
    private final TipoPokemon vantagem;

    public Pokemon(PokemonAttributes atributos) {
        this.atributos = atributos;
        Map<TipoPokemon, TipoPokemon> vantagens = new HashMap<>();
        vantagens.put(TipoPokemon.AGUA, TipoPokemon.FOGO);
        vantagens.put(TipoPokemon.ELETRICO, TipoPokemon.AGUA);
        vantagens.put(TipoPokemon.GRAMA, TipoPokemon.AGUA);
        vantagens.put(TipoPokemon.FOGO, TipoPokemon.GRAMA);
        this.vantagem = vantagens.get(this.atributos.getTipoDoPokemon());
    }

    public PokemonAttributes getAtributos() {
        return atributos;
    }

    public void setAtributos(PokemonAttributes atributos) {
        this.atributos = atributos;
    }

    public static int calcularDano(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        double ataqueAtacante;
        double defesaDefensor;

        if (pokemonAtacante.getAtributos().getMovimento().getTipoDeMovimento() == TipoMovimento.FISICO){
            ataqueAtacante = pokemonAtacante.getAtributos().getAtaque();
            defesaDefensor = pokemonDefensor.getAtributos().getDefesa();
        } else {
            ataqueAtacante = pokemonAtacante.getAtributos().getAtaqueEspecial();
            defesaDefensor = pokemonDefensor.getAtributos().getDefesaEspecial();
        }
        return (int) Math.ceil(0.5 * pokemonAtacante.atributos.getMovimento().getPoder() * pokemonAtacante.calcularVantagem(pokemonDefensor.getAtributos().getTipoDoPokemon())
                * ( ataqueAtacante / defesaDefensor));
    }

    private int calcularVantagem(TipoPokemon tipoPokemonAdversario) {
        if (this.vantagem == tipoPokemonAdversario) {
            return 2;
        }
        return 1;
    }

    public void sofrerDano(int dano) {
        int novaSaude = this.atributos.getPontosDeSaude() - dano;
        if (novaSaude < 0) {
            novaSaude = 0;
        }
        this.atributos.setPontosDeSaude(novaSaude);
    }

    public boolean foiDerrotado() {
        return this.atributos.getPontosDeSaude() <= 0;
    }
}
