import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatalhaPokemonTest {
    @Test
    public void deveEncerrarBatalhaComVitoriaDeAsh() {
        Treinador red = new Treinador("Red");
        red.adicionarAoTime(new Charmander());

        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());

        Arena arena = new Arena(red, ash);
        Treinador vencedor = arena.batalhar();
        assertEquals(ash, vencedor);
    }

    @Test
    public void deveEncerrarBatalhaComVitoriaDeAshMesmoAposInverterAOrdem() {
        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());

        Treinador red = new Treinador("Red");
        red.adicionarAoTime(new Charmander());

        Arena arena = new Arena(ash, red);
        Treinador vencedor = arena.batalhar();
        assertEquals(ash, vencedor);
    }

    @Test
    public void deveEncerrarBatalhaComVitoriaDeRedDevidoAPocao() {
        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());

        Treinador red = new Treinador("Red", new Pocao());
        red.adicionarAoTime(new Squirtle());

        Arena arena = new Arena(ash, red);
        Treinador vencedor = arena.batalhar();
        Assert.assertEquals(red, vencedor);
    }

    @Test
    public void deveEncerrarComVitoriaDeRedDevidoAItemApelao() {
        Treinador red = new Treinador("Red", new XAtaqueEspecial());
        red.adicionarAoTime(new Charmander());

        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());
        ash.adicionarAoTime(new Bulbasaur());
        ash.adicionarAoTime(new Charmander());

        Arena arena = new Arena(red, ash);
        Treinador vencedor = arena.batalhar();
        Assert.assertEquals(red, vencedor);
    }

    @Test
    public void deveEncerrarComVitoriaDeAshDevidoAVelocidadeDePikachu() {
        Treinador red = new Treinador("Red", new XAtaqueEspecial());
        red.adicionarAoTime(new Charmander());

        Treinador ash = new Treinador("Ash");
        ash.adicionarAoTime(new Squirtle());
        ash.adicionarAoTime(new Pikachu());

        Arena arena = new Arena(red, ash);
        Treinador vencedor = arena.batalhar();
        Assert.assertEquals(ash, vencedor);
    }


}
