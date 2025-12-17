public class XAtaqueEspecial extends Item{

    public XAtaqueEspecial() {
        super(1);
    }

    @Override
    public void usarItem(Pokemon pokemon) {
        int novoAtaqueEspecial = pokemon.getAtributos().getAtaqueEspecial() + 200;
        pokemon.getAtributos().setAtaqueEspecial(novoAtaqueEspecial);
    }
}
