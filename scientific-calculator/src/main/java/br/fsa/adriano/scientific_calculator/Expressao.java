package br.fsa.adriano.scientific_calculator;

import java.util.regex.Pattern;

public class Expressao {

	private String expressaoGeral;
	private String expressao;
	private String operador;
	private String operandoA;
	private String operandoB;
	CalcSimples calculadora;
	
	public Expressao(String expressao) {
		setExpressaoGeral(expressao);
		setExpressao(expressao);
		setOperador("?");
		setOperandoA("");
		setOperandoB("");
		calculadora = new CalcSimples();
	}
	
	public String priorizar() {
		int contas = 0;		
		/**
		 * Define quantidade de contas à realizar
		 */				
		for(int indice = 0; indice < getExpressaoGeral().length(); indice++) {
			if(getExpressaoGeral().charAt(indice) == '/' || getExpressaoGeral().charAt(indice) == '*' || 
					getExpressaoGeral().charAt(indice) == '-' || getExpressaoGeral().charAt(indice) == '+') {
				contas++;
			}
		}
		/**
		 * Controla contas à realizar
		 */
		for(int indice = 0; indice < contas; indice++) {
			System.out.println("controlar: expressaoGeral = [ " + getExpressaoGeral() + " ]");
			
			/**
			 * pivo = operador que será usado para realizar a conta
			 */
			if( getExpressaoGeral().contains("/") ) {
				for(int pivo = 1; pivo < getExpressaoGeral().length(); pivo++) {				
					if( getExpressaoGeral().charAt(pivo) == '/') {
						extrair(pivo);
						calcular(calculadora);
						break;
					}
				}
			}else if( getExpressaoGeral().contains("*") ) {
				for(int pivo = 1; pivo < getExpressaoGeral().length(); pivo++) {				
					if( getExpressaoGeral().charAt(pivo) == '*') {
						extrair(pivo);
						calcular(calculadora);
						break;
					}
				}
			}else if( getExpressaoGeral().contains("+") ) {
				for(int pivo = 1; pivo < getExpressaoGeral().length(); pivo++) {				
					if( getExpressaoGeral().charAt(pivo) == '+') {
						extrair(pivo);
						calcular(calculadora);
						break;
					}
				}
			}else if( getExpressaoGeral().contains("-") ) {
				for(int pivo = 1; pivo < getExpressaoGeral().length(); pivo++) {				
					if( getExpressaoGeral().charAt(pivo) == '-') {
						extrair(pivo);
						calcular(calculadora);
						break;
					}
				}
			}						
		}
		return getExpressaoGeral().substring(1);
	}
	
	/**
	 * Extrai os operandos e operador para cálculo
	 */
	private void extrair(int pivo) {
		int recua, avanca;
		/**
		 * recua substitui pivo varrendo até a posição 0
		 */
		for(recua = pivo - 2; recua >= 0; recua--) {
			if(recua <= 0 || 
				getExpressaoGeral().charAt(recua) == '/' || getExpressaoGeral().charAt(recua) == '*' || 
				getExpressaoGeral().charAt(recua) == '-' || getExpressaoGeral().charAt(recua) == '+') {
				break;
			}
		}
		/**
		 * avanca substitui pivo varrendo até a última posição
		 */
		for(avanca = pivo + 2; avanca < getExpressaoGeral().length(); avanca++) {
			if(avanca >= getExpressaoGeral().length() || 
				getExpressaoGeral().charAt(avanca) == '/' || getExpressaoGeral().charAt(avanca) == '*' || 
				getExpressaoGeral().charAt(avanca) == '-' || getExpressaoGeral().charAt(avanca) == '+') {
				break;
			}					
		}
		/**
		 * FIX - recua < 0
		 * Se recua é < 0 pode ocorrer erro java.lang.StringIndexOutOfBoundsException
		 */
		if(recua < 0)
			recua = 0;
		/**
		 * Analisa o primeiro caractere identificado
		 */
		if(getExpressaoGeral().substring(recua, avanca).charAt(0) == '/' || getExpressaoGeral().substring(recua, avanca).charAt(0) == '*')
			recua++;
		
		setExpressao(getExpressaoGeral().substring(recua, avanca));
		setOperador( getExpressaoGeral().substring(pivo, pivo + 1) );
		setOperandoA( getExpressaoGeral().substring(recua, pivo) );
		setOperandoB( getExpressaoGeral().substring(pivo + 1, avanca) );					
		System.out.println("extrair: expressao = [ " + getExpressao() + " ]");
		System.out.println("extrair: a = [ " + getOperandoA() + " ][ " + getOperador() + " ] b = [ " + getOperandoB() + " ]");		
	}
	
	/**
	 * Calcula os operandos extraídos
	 * @param calculadora
	 */
	public void calcular(CalcSimples calculadora) {
		double decimal = 0;
		int inteiro = 0;
		String resultado = null;
		if(getOperandoA().contains(",") || getOperandoA().contains(".") ||
				getOperandoB().contains(",") || getOperandoB().contains(".")) {			
			switch(getOperador()) {
			case "+":
				decimal = calculadora.somar( Double.valueOf(getOperandoA()), Double.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( decimal ) ) );
				break;
			case "-":
				decimal = calculadora.subtrair( Double.valueOf(getOperandoA()), Double.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( decimal ) ) );
				break;
			case "*":
				decimal = calculadora.multiplicar( Double.valueOf(getOperandoA()), Double.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( decimal ) ) );
				break;
			case "/":
				resultado = calculadora.dividir( Double.valueOf(getOperandoA()), Double.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( resultado ) ) );
				break;		
			}				
		}else {
			switch(getOperador()) {
			case "+":
				inteiro = calculadora.somar( Integer.valueOf(getOperandoA()), Integer.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( inteiro ) ) );					
				break;
			case "-":
				inteiro = calculadora.subtrair( Integer.valueOf(getOperandoA()), Integer.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( inteiro ) ) );
				break;
			case "*":
				inteiro = calculadora.multiplicar( Integer.valueOf(getOperandoA()), Integer.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( inteiro ) ) );
				break;
			case "/":
				resultado = calculadora.dividir( Double.valueOf(getOperandoA()), Double.valueOf(getOperandoB()) );
				setExpressaoGeral( refatorar( String.valueOf( resultado ) ) );
				break;
			}				
		}
		/**
		 * FIX - expressaoGeral
		 * Altera ',' para '.' se o caractere existir
		 */
		if(getExpressaoGeral().contains(","))
			setExpressaoGeral(getExpressaoGeral().replaceAll(",", "."));
	}
	
	/**
	 * Refatora expressao baseado no resultado
	 * @param expressao
	 * @param resultado
	 * @return
	 */
	public String refatorar(String resultado) {
		System.out.println("refatorar: resultado = [ " + resultado + " ]");
		/**
		 * FIX - resultado
		 * 1. Insere sinal '+' se o primeiro algarismo não possui sinal
		 * 2. Deleta ",0" se o resultado é um decimal sem resto
		 */ 
		if(resultado.charAt(0) != '-' && resultado.charAt(0) != '+')
			resultado = "+" + resultado;
		if(resultado.contains(",0"))
			resultado = resultado.replaceAll(",0", "");
		else if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");		

		String novaExpressao = getExpressaoGeral().replaceFirst(Pattern.quote(getOperandoA()) + 
													  			Pattern.quote(getOperador()) + 
													  			Pattern.quote(getOperandoB()), 
													  			resultado);		
		return novaExpressao;
	}	
	
	private String getExpressaoGeral() {
		return expressaoGeral;
	}

	private void setExpressaoGeral(String expressaoGeral) {
		this.expressaoGeral = expressaoGeral;
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public String getOperandoA() {
		return operandoA;
	}

	public void setOperandoA(String operandoA) {
		this.operandoA = operandoA;
	}

	public String getOperandoB() {
		return operandoB;
	}

	public void setOperandoB(String operandoB) {
		this.operandoB = operandoB;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}		
	
}
