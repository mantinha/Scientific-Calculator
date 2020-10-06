package br.fsa.adriano.scientific_calculator;

public class CalcCientifica {
	
	public double seno(double angulo) {		
		System.out.println("seno: angulo = " + angulo);
		return Math.sin(angulo);
	}
	
	public double cosseno(double angulo) {		
		System.out.println("cosseno: angulo = " + angulo);
		return Math.cos(angulo);
	}
	
	public double tangente(double angulo) {		
		System.out.println("tangente: angulo = " + angulo);
		return Math.tan(angulo);
	}
	
}
