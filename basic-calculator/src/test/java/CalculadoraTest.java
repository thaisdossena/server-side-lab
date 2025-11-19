import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemInteiros(){
        //Arrange
        double valor1 = 2;
        double valor2 = 2;
        double resultadoEsperado = 4;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.somar(valor1, valor2);

        //Assert
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0);
    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        double valor1 = 3;
        double valor2 = 3;
        double resultadoEsperado = 9;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.multiplicar(valor1, valor2);

        //Assert
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        double valor1 = 2;
        double valor2 = 2;
        double resultadoEsperado = 1;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.dividir(valor1, valor2);

        //Assert
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosPossuemPontosFlutuantes(){
        //Arrange
        double valor1 = 10.0;
        double valor2 = 3.0;
        double resultadoEsperado = 3.333;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.dividir(valor1, valor2);

        //Assert
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.001);
    }

    @Test
    public void deveRetornarExcecaoQuandoDivisorForZero() {
        //Arrange
        double valor1 = 2;
        double valor2 = 0;
        String resultadoEsperado = "Não pode dividir por zero!";
        Calculadora calculadora = new Calculadora();

        //Act
        ArithmeticException exception = Assert.assertThrows(ArithmeticException.class, () -> calculadora.dividir(valor1, valor2));

        //Assert
        Assert.assertEquals(resultadoEsperado, exception.getMessage());
    }

    @Test
    public void deveCalcularHipotenusaCorretamente() {
        //Arrange
        double valor1 = 1;
        double valor2 = -3;
        double valor3 = -54;
        double[] resultadoEsperado = new double[] {9, -6};
        Calculadora calculadora = new Calculadora();

        //Act
        double[] valorCalculado = calculadora.bhaskara(valor1, valor2, valor3);

        //Assert
        Assert.assertArrayEquals(resultadoEsperado, valorCalculado, 0.001);
    }

    @Test
    public void deveLancarExcecaoQuandoValorNegativoInformado() {
        //Arrange
        double valor1 = 1;
        double valor2 = 2;
        double valor3 = 3;
        String resultadoEsperado = "A equação não tem raízes reais!";
        Calculadora calculadora = new Calculadora();

        //Act
        ArithmeticException exception = Assert.assertThrows(ArithmeticException.class, () -> calculadora.bhaskara(valor1, valor2, valor3));

        //Assert
        Assert.assertEquals(resultadoEsperado, exception.getMessage());
    }

    @Test
    public void deveSubtrairCorretamenteQuandoOsValoresForemInteiros(){
        //Arrange
        double valor1 = 2;
        double valor2 = 2;
        double resultadoEsperado = 0;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.subtrair(valor1, valor2);

        //Assert
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0);
    }

    @Test
    public void deveCalcularExponenciacaoCorretamente() {
        //Arrange
        double valor1 = 2;
        double valor2 = 3;
        double resultadoEsperado = 8;
        Calculadora calculadora = new Calculadora();

        //Act
        double valorCalculado = calculadora.elevar(valor1, valor2);

        //Assert
        Assert.assertEquals(resultadoEsperado, valorCalculado, 0.0001);
    }
}