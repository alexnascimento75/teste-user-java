// Pacote: Conjunto de classes
package br.com.iterasys;
// Bibliotecas
//
public class Calculadora {
    // Atributos - Características - Campos
// Funções e Métodos
    public static double somarDoisNumeros(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtrairDoisNumeros(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicarDoisNUmeros(double num1, double num2) {
        return num1 * num2;
    }




    public static double dividirDoisNumeros(double num1, double num2) {
        return num1 / num2;
    }

    public static String dividirDoisNumerosInteiros( int numA, int numB){
        try {
            return String.valueOf(numA / numB);
        }
        catch (Exception e) {
            return "Não é possível dividir por zero";

        }
    }

}
