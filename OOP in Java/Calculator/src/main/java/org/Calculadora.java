package org;

public class Calculadora {
    public double soma(double valor1, double valor2){
        return valor1 + valor2;
    }

    public double subtracao(double valor1, double valor2){
        return valor1 - valor2;
    }

    public double multiplicacao(double valor1, double valor2){
        return valor1 * valor2;
    }

    public double divisao(double valor1, double valor2){
        return valor1 / valor2;
    }

    public double raiz(double valor1){
        return Math.sqrt(valor1);
    }

    public double exponenciacao(double valor1, double expoente){
        return Math.pow(valor1, expoente);
    }

    public double bhaskara(double a, double b){
        return (-b) / a;
    }
}
