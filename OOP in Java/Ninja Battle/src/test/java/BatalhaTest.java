import org.Batalha;
import org.Jutsu;
import org.Ninja;
import org.junit.Test;
import org.junit.Assert;

public class BatalhaTest {
    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakra(){
        //arrange
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        //act
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        //assert
        Assert.assertSame(ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        //arrange
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja ninjaAtacante = new Ninja("Naruto", jutsuNinjaAtacante);

        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja ninjaOponente = new Ninja("Gaara", jutsuNinjaOponente);

        int nivelChakraEsperado = 90;

        //act
        ninjaAtacante.atacar(ninjaOponente);

        //assert
        Assert.assertEquals(nivelChakraEsperado, ninjaOponente.getChakra());
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi(){
        //arrange
        Jutsu jutsuNinjaUm = new Jutsu(5, 2);
        Ninja ninjaUm = new Ninja("Itachi", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Naruto", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        //act
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        //assert
        Assert.assertSame(ninjaVencedor, ninjaUm);
    }

    @Test
    public void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi(){
        //arrange
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 2);
        Ninja ninjaDois = new Ninja("Itachi", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        //act
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        //assert
        Assert.assertSame(ninjaVencedor, ninjaDois);
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar() {
        //arrange
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 10);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        //act
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        //assert
        Assert.assertSame(ninjaVencedor, ninjaUm);
    }

}

