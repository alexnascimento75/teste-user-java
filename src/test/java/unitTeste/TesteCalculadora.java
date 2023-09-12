package unitTeste;// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteCalculadora {
    // Atributos
// Funções e Métodos
    @Test
    public void testeSomarDoisNumeros() {
// Configurão - Execução - Validação
// Valores de entrada
        double num1 = 7;
        double num2 = 5;
        double resultadoEsperado = 12;
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);
// Validação
        assertEquals(resultadoAtual, resultadoEsperado);
    }


    // Este é um teste de unidade data driven - direcionados por dados
    @ParameterizedTest
    @CsvSource(value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "20, 30, 50.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    public void testeSomarDoisNumeroslendolista(String txtnum1, String txtnum2, String resultadoEsperado) {
// Configurão - Execução - Validação
// Valores de entrada
        // Os dados de entrada e o resultado vem da lista

        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtnum1), Integer.valueOf(txtnum2));
// Validação
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumeroslendoArquivo(String txtnum1, String txtnum2, String resultadoEsperado) {
// Configurão - Execução - Validação
// Valores de entrada
        // Os dados de entrada e o resultado vem da lista

        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtnum1), Integer.valueOf(txtnum2));
// Validação
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


    @Test
    public void testeSubtrairDoisNumeros() {
// Configurão - Execução - Validação
// Valores de entrada
        double num1 = 25;
        double num2 = 15;
        double resultadoEsperado = 10;
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeMultiplicarDoisNumeros(){
// Configurão - Execução - Validação
// Valores de entrada
        double num1 = 30;
        double num2 = 10;
        double resultadoEsperado = 300;
        double resultadoAtual = Calculadora.multiplicarDoisNUmeros(num1, num2);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testDividirDoisNumerosInteiros(){
        int numA = 8;
        int numB = 0;
        String resultadoEsperado = "Não é possível dividir por zero";
        String resultadoAtual = String.valueOf(Calculadora.dividirDoisNumerosInteiros(numA, numB));
        assertEquals(resultadoEsperado, resultadoAtual );
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.println("O resultado esparado: " + resultadoEsperado);
    }

    @Test
    public void testeDividirDoisNumeros(){
// Configurão - Execução - Validação
// Valores de entrada
        double num1 = 10;
        double num2 = 4;
        double resultadoEsperado = 2.5;
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);
        assertEquals(resultadoAtual, resultadoEsperado);
    }
}
