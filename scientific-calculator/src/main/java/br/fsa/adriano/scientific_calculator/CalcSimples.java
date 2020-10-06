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
	
	public String dividir(double a, double b) {
		System.out.println("dividir: a = " + a + " b = " + b);
		DecimalFormat decimal = new DecimalFormat("#0.0");
		return decimal.format(a / b);
	}
	
}
