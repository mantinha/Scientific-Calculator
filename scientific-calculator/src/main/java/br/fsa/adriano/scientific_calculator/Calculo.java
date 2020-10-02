package br.fsa.adriano.scientific_calculator;

public class Calculo {

	private String operador;
	private String a;
	private String b;
	private String resultado;
	private boolean inteiro;
	
	public Calculo(String a, String operador, String b) {		
		this.a = a;
		this.operador = operador;
		this.b = b;
		
		verificaTipo();
		verificaOperacao();
	}
	
	public Calculo(String operador, String b) {
		this.operador = operador;
		this.b = b;
		
		setResultado(b);
	}
	
	private void verificaTipo() {
		if(getA().contains(",") || getB().contains(","))
			setInteiro(false);
		else
			setInteiro(true);
	}
	
	private void verificaOperacao() {
		switch(getOperador()) {
		case "+":
			soma();
			break;
		case "-":
			subtrai();
			break;
		case "*":
			multiplica();
			break;
		case "/":
			divide();
			break;		
		}
	}

	private String getOperador() {
		return operador;
	}

	private void setOperador(String operador) {
		this.operador = operador;
	}

	public String getA() {
		return a;
	}

	private void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	private void setB(String b) {
		this.b = b;
	}

	public String getResultado() {
		return resultado;
	}

	private void setResultado(String resultado) {
		this.resultado = resultado;
	}	
	
	private boolean isInteiro() {
		return inteiro;
	}

	private void setInteiro(boolean inteiro) {
		this.inteiro = inteiro;
	}

	private void soma() {
		if(isInteiro())
			setResultado(String.valueOf((Integer.valueOf(getA()) + 
										 Integer.valueOf(getB()))));
		else
			setResultado(String.valueOf((Float.valueOf(getA()) + 
										 Float.valueOf(getB()))));
	}
	
	private void subtrai() {
		if(isInteiro())
			setResultado(String.valueOf((Integer.valueOf(getA()) - 
										 Integer.valueOf(getB()))));
		else
			setResultado(String.valueOf((Float.valueOf(getA()) - 
										 Float.valueOf(getB()))));
	}
	
	private void multiplica() {
		if(isInteiro())
			setResultado(String.valueOf((Integer.valueOf(getA()) * 
										 Integer.valueOf(getB()))));
		else
			setResultado(String.valueOf((Float.valueOf(getA()) * 
										 Float.valueOf(getB()))));
	}
	
	private void divide() {
		if(isInteiro())
			setResultado(String.valueOf((Integer.valueOf(getA()) / 
										 Integer.valueOf(getB()))));
		else
			setResultado(String.valueOf((Float.valueOf(getA()) / 
										 Float.valueOf(getB()))));
	}
	
}
