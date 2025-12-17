import org.*;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class NegociacaoTest {
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, new Indiferente(), BigDecimal.valueOf(800500), 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, BigDecimal.valueOf(10000));
        Atacante atacante = new Atacante("Neymar", 25, null, 9, new Mercenario(), BigDecimal.valueOf(1000000), 10);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        //arrange
        MeioCampo meioCampo = new MeioCampo("Oscar", 25, null, 9, new Conservador(), BigDecimal.valueOf(1000));
        BigDecimal valorEsperado = BigDecimal.valueOf(1400);

        //act
        BigDecimal valorReal = meioCampo.valorDeCompra();

        //assert
        Assert.assertEquals(0, valorEsperado.compareTo(valorReal));
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        MeioCampo meioCampo = new MeioCampo("Oscar", 31, null, 9, new Conservador(), BigDecimal.valueOf(1000));
        BigDecimal valorEsperado = BigDecimal.valueOf(980);

        //act
        BigDecimal valorReal = meioCampo.valorDeCompra();

        //assert
        Assert.assertEquals(0, valorEsperado.compareTo(valorReal));
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoLateralComMaisDeVinteEOitoAnos() {
        Lateral lateral = new Lateral("Oscar", 31, null, 9, new Conservador(), BigDecimal.valueOf(1000), 10);
        BigDecimal valorEsperado = BigDecimal.valueOf(1176);

        //act
        BigDecimal valorReal = lateral.valorDeCompra();

        //assert
        Assert.assertEquals(0, valorEsperado.compareTo(valorReal));
    }

    @Test
    public void meioCampoNaoTemInteresseSeOClubeTemReputacaoHistoricaMaior() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, BigDecimal.valueOf(10000));
        MeioCampo meioCampo = new MeioCampo("Oscar", 31, null, 9, new Conservador(), BigDecimal.valueOf(1000));

        //act
        boolean foiPossivelRealizarNegociacao = negociacao.negociar(clube, meioCampo);

        //assert
        Assert.assertFalse(foiPossivelRealizarNegociacao);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoZagueiroComMaisDeTrintaAnos() {
        Zagueiro zagueiro = new Zagueiro("Oscar", 31, null, 9, new Indiferente(), BigDecimal.valueOf(1000));
        BigDecimal valorEsperado = BigDecimal.valueOf(800);

        //act
        BigDecimal valorReal = zagueiro.valorDeCompra();

        //assert
        Assert.assertEquals(0, valorEsperado.compareTo(valorReal));
    }

    @Test
    public void deveRetornarSemClubeCasoOZagueiroEstejaSem() {
        Zagueiro zagueiro = new Zagueiro("Oscar", 31, null, 9, new Indiferente(), BigDecimal.valueOf(1000));
        String clubeEsperado = "Sem Clube";

        //act
        String clubeReal = zagueiro.getClubeAtual();

        //assert
        Assert.assertEquals(clubeEsperado, clubeReal);
    }
}
