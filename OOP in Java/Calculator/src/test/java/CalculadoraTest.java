import org.Calculadora;
import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemInteiros(){
        //Arrange
        int valor1 = 3;
        int valor2 = 2;
        double resultadoEsperado = 5;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.soma(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int valor1 = 6;
        int valor2 = 2;
        double resultadoEsperado = 3;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.divisao(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int valor1 = 10;
        int valor2 = 2;
        double resultadoEsperado = 20;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.multiplicacao(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosPossuemPontosFlutuantes(){
        //Arrange
        double valor1 = 10;
        double valor2 = 4;
        double resultadoEsperado = 2.5;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.divisao(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveSubtrairCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int valor1 = 10;
        int valor2 = 4;
        double resultadoEsperado = 6;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.subtracao(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveCalcularRaizCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int valor1 = 144;
        double resultadoEsperado = 12;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.raiz(valor1);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveCalcularPotenciaCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int valor1 = 2;
        int valor2 = 4;
        double resultadoEsperado = 16;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.exponenciacao(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }

    @Test
    public void deveCalcularSomaDasRaizesQuandoNumerosForemInteiros(){
        //Arrange
        int valor1 = 4;
        int valor2 = 8;
        double resultadoEsperado = -2;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.bhaskara(valor1, valor2);

        //Arrange
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.01);
    }
}
