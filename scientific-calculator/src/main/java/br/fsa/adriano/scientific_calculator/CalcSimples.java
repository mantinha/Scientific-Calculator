package br.fsa.adriano.scientific_calculator;

import java.text.DecimalFormat;

public class CalcSimples {

	public int somar(int a, int b) {
		System.out.println("somar: a = " + a + " b = " + b);
		return a + b;
	}
	
	public double somar(double a, double b) {
		System.out.println("somar: a = " + a + " b = " + b);
		return a + b;
	}
	
	public int subtrair(int a, int b) {
		System.out.println("subtrair: a = " + a + " b = " + b);
		return a - b;
	}
	
	public double subtrair(double a, double b) {
		System.out.println("subtrair: a = " + a + " b = " + b);
		return a - b;
	}
	
	public int multiplicar(int a, int b) {
		System.out.println("multiplicar: a = " + a + " b = " + b);
		return a * b;
	}
	
	public double multiplicar(double a, double b) {
		System.out.println("multiplicar: a = " + a + " b = " + b);
		return a * b;
	}
	
	public String dividir(double numerador, double denominador) {
		System.out.println("dividir: numerador = " + numerador + " denominador = " + denominador);
		DecimalFormat decimal = new DecimalFormat("#0.0");
		return decimal.format(numerador / denominador);
	}
	
	public double potencializar(double base) {
		double expoente = 2;
		System.out.println("potencializar: base = " + base + " expoente = " + expoente);
		return Math.pow(base, expoente);
	}
	
	public double radicalizar(double radicando) {		
		System.out.println("radicalizar: índice = " + 2 + " radicando = " + radicando);
		return Math.sqrt(radicando);
	}
	
	public double fatorar(double numero) {		
		double fatorial = numero;
		if(fatorial == 0) {
			fatorial++;
		}
		while(numero > 1 && numero < 999999999) {
			fatorial *= --numero;
			System.out.println("fatorar: numero = " + numero + " fatorial = " + fatorial);
		}		
		return fatorial;
	}
}
