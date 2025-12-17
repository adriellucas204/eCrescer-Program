public class PokemonAttributes {
    private String nome;
    private final int pontosDeSaudeMax;
    private int pontosDeSaude;
    private int ataque;
    private int defesa;
    private int ataqueEspecial;
    private int defesaEspecial;
    private Movimento movimento;
    private int velocidade;
    private TipoPokemon tipoDoPokemon;

    public PokemonAttributes(String nome, int pontosDeSaude, int ataque, int defesa, int ataqueEspecial, int defesaEspecial, int velocidade, Movimento movimento, TipoPokemon tipoDoPokemon) {
        this.nome = nome;
        this.pontosDeSaude = pontosDeSaude;
        this.ataque = ataque;
        this.defesa = defesa;
        this.ataqueEspecial = ataqueEspecial;
        this.defesaEspecial = defesaEspecial;
        this.movimento = movimento;
        this.velocidade = velocidade;
        this.tipoDoPokemon = tipoDoPokemon;
        this.pontosDeSaudeMax = pontosDeSaude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosDeSaude() {
        return pontosDeSaude;
    }

    public void setPontosDeSaude(int pontosDeSaude) {
        this.pontosDeSaude = pontosDeSaude;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefesaEspecial() {
        return defesaEspecial;
    }

    public int getPontosDeSaudeMax() {
        return pontosDeSaudeMax;
    }

    public void setDefesaEspecial(int defesaEspecial) {
        this.defesaEspecial = defesaEspecial;
    }

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public TipoPokemon getTipoDoPokemon() {
        return tipoDoPokemon;
    }

    public void setTipoDoPokemon(TipoPokemon tipoDoPokemon) {
        this.tipoDoPokemon = tipoDoPokemon;
    }
}
