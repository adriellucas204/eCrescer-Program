public class Pocao extends Item{

    public Pocao() {
        super(2);
    }

    @Override
    public void usarItem(Pokemon pokemon) {
        int psMax = pokemon.getAtributos().getPontosDeSaudeMax();
        int novaSaude = pokemon.getAtributos().getPontosDeSaude() + 50;

        if (novaSaude > psMax){
            pokemon.getAtributos().setPontosDeSaude(psMax);
            return;
        }
        pokemon.getAtributos().setPontosDeSaude(novaSaude);
    }
}
