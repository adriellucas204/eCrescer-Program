import org.Nave;
import org.Planeta;
import org.Recurso;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExploracaoTest {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        int combustivelEsperado = 1;
        Nave milleniumFalcon = new Nave(10);
        Planeta tatooine = new Planeta(4, new ArrayList<>());

        List<Recurso> recursos = milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        Assert.assertTrue(recursos.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        //arrange
        Planeta saturno = new Planeta(3, new ArrayList<>());
        int valorTotalEsperado = 0;

        //act
        int valorTotalReal = saturno.getValorTotal();

        //assert
        Assert.assertEquals(valorTotalEsperado, valorTotalReal);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        //arrange
        Planeta saturno = new Planeta(3, new ArrayList<>());
        List<Recurso> recursos = new ArrayList<Recurso>();
        recursos.add(new Recurso(180, 10)); //agua
        recursos.add(new Recurso(300, 2));  //oxigenio
        recursos.add(new Recurso(60, 16));  //silicio
        saturno.setRecursos(recursos);
        int valorTotalEsperado = 540;

        //act
        int valorTotalReal = saturno.getValorTotal();

        //assert
        Assert.assertEquals(valorTotalEsperado, valorTotalReal);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        //arrange
        Planeta saturno = new Planeta(3, new ArrayList<>());
        int ValorPorPesoEsperado = 0;

        //act
        int valorPorPesoReal = saturno.getValorPorPesoTotal();

        //assert
        Assert.assertEquals(ValorPorPesoEsperado, valorPorPesoReal);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        //arrange
        Planeta saturno = new Planeta(3, new ArrayList<>());
        List<Recurso> recursos = new ArrayList<Recurso>();
        recursos.add(new Recurso(180, 10)); //agua
        recursos.add(new Recurso(300, 2));  //oxigenio
        recursos.add(new Recurso(60, 16));  //silicio
        saturno.setRecursos(recursos);
        int valorPorPesoTotal = 171;

        //act
        int valorPorPesoReal = saturno.getValorPorPesoTotal();

        //assert
        Assert.assertEquals(valorPorPesoTotal, valorPorPesoReal);
    }

    @Test
    public void naveDeveEstarComRecursosEFicarADerivaCasoExploreUmPlanetaEOutroNao() {
        //arrange
        int posicaoEsperada = 5;
        int combustivelEsperado = 2;

        //planetas e nave
        Nave milleniumFalcon = new Nave(17);
        Planeta tatooine = new Planeta(3, new ArrayList<>());
        Planeta saturno = new Planeta(7, new ArrayList<>());
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);
        planetas.add(saturno);

        //recursos
        List<Recurso> recursosSaturno = new ArrayList<Recurso>();
        recursosSaturno.add(new Recurso(180, 10)); //agua
        recursosSaturno.add(new Recurso(300, 2));  //oxigenio
        recursosSaturno.add(new Recurso(60, 16));  //silicio

        List<Recurso> recursosTatooine = new ArrayList<Recurso>();
        recursosTatooine.add(new Recurso(120, 25)); //ouro
        recursosTatooine.add(new Recurso(300, 2));  //oxigenio

        saturno.setRecursos(recursosSaturno);
        tatooine.setRecursos(recursosTatooine);

        //act
        List<Recurso> recursosDaNave = milleniumFalcon.explorar(planetas);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        //assert
        Assert.assertFalse(recursosDaNave.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void naveDeveVoltarAPosicaoInicialEExplorarTodosOsPlanetas() {
        //arrange
        int posicaoEsperada = 0;
        int combustivelEsperado = 3;

        //planetas e nave
        Nave milleniumFalcon = new Nave(57);
        Planeta tatooine = new Planeta(1, new ArrayList<>());
        Planeta saturno = new Planeta(9, new ArrayList<>());
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);
        planetas.add(saturno);

        //recursos
        List<Recurso> recursosSaturno = new ArrayList<Recurso>();
        recursosSaturno.add(new Recurso(180, 10)); //agua
        recursosSaturno.add(new Recurso(300, 2));  //oxigenio
        recursosSaturno.add(new Recurso(60, 16));  //silicio

        List<Recurso> recursosTatooine = new ArrayList<Recurso>();
        recursosTatooine.add(new Recurso(120, 25)); //ouro
        recursosTatooine.add(new Recurso(300, 2));  //oxigenio

        saturno.setRecursos(recursosSaturno);
        tatooine.setRecursos(recursosTatooine);

        //act
        List<Recurso> recursosDaNave = milleniumFalcon.explorar(planetas);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        //assert
        Assert.assertFalse(recursosDaNave.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void naveDeveExplorarTodosOsPlanetasMasFicaADerivaNaVolta() {
        //arrange
        int posicaoEsperada = 8;
        int combustivelEsperado = 2;

        //planetas e nave
        Nave milleniumFalcon = new Nave(32);
        Planeta tatooine = new Planeta(1, new ArrayList<>());
        Planeta saturno = new Planeta(9, new ArrayList<>());
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);
        planetas.add(saturno);

        //recursos
        List<Recurso> recursosSaturno = new ArrayList<Recurso>();
        recursosSaturno.add(new Recurso(180, 10)); //agua
        recursosSaturno.add(new Recurso(300, 2));  //oxigenio
        recursosSaturno.add(new Recurso(60, 16));  //silicio

        List<Recurso> recursosTatooine = new ArrayList<Recurso>();
        recursosTatooine.add(new Recurso(120, 25)); //ouro
        recursosTatooine.add(new Recurso(300, 2));  //oxigenio

        saturno.setRecursos(recursosSaturno);
        tatooine.setRecursos(recursosTatooine);

        //act
        List<Recurso> recursosDaNave = milleniumFalcon.explorar(planetas);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        //assert
        Assert.assertFalse(recursosDaNave.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }


}
