package br.fsa.adriano.scientific_calculator;

public class CalculadoraSimples {

	private String operador;
	private String a;
	private String b;
	private String resultado;
	private boolean inteiro;
	
	public String opera(String a, String operador, String b) {		
		this.a = a;
		this.b = b;
		this.operador = operador;
				
		verificaTipo();
		verificaOperacao();
		
		return getResultado();
	}

	private void verificaTipo() {
		if(a.contains(",") || b.contains(","))
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

	private String getA() {
		return a;
	}

	private void setA(String a) {
		this.a = a;
	}

	private String getB() {
		return b;
	}

	private void setB(String b) {
		this.b = b;
	}

	private String getResultado() {
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
