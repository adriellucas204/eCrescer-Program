public class XAtaque extends Item {
    public XAtaque() {
        super(1);
    }

    @Override
    public void usarItem(Pokemon pokemon) {
        int novoAtaque = pokemon.getAtributos().getAtaque() + 200;
        pokemon.getAtributos().setAtaque(novoAtaque);
    }
}
