package br.fsa.adriano.scientific_calculator;

import java.util.regex.Pattern;

public class Expressao {

	private String expressao;
	private String operador;
	private String operandoA;
	private String operandoB;
	
	public Expressao(String expressao) {
		setExpressao(expressao);
		setOperador("?");
		setOperandoA("");
		setOperandoB("");		
		explorar();
		extrair();
	}
	
	/**
	 * Prioridade de extracao de operacao 
	 * 1 - "DIVISAO"
	 * 2 - "MULTIPLICACAO"
	 * 3 - "SUBTRACAO" / "SOMA"
	 */
	private void explorar() {
		
		char[] prioridade = {'/','*','-','+'};
		int recua = 0, avanca = 0;
		
		System.out.println("explorar -> EXPRESSAO -> "+ getExpressao());
		
		for(int indice = 0; indice < prioridade.length; indice++) {
			for(int pivo = 1; pivo < getExpressao().length(); pivo++) {
				
				if(getExpressao().charAt(pivo) == prioridade[indice]) {					
					
					for(recua = pivo - 1; recua >= 0; recua--) {
						if(recua <= 0 || 
								getExpressao().charAt(recua) == '/' ||
								getExpressao().charAt(recua) == '*' || 
								getExpressao().charAt(recua) == '-' || 
								getExpressao().charAt(recua) == '+') {
							break;
						}
					}
					
					for(avanca = pivo + 2; avanca < getExpressao().length(); avanca++) {
						if(avanca >= getExpressao().length() - 1 || 
								getExpressao().charAt(avanca) == '/' ||
								getExpressao().charAt(avanca) == '*' || 
								getExpressao().charAt(avanca) == '-' || 
								getExpressao().charAt(avanca) == '+') {
							break;
						}					
					}
					
					if(getExpressao().substring(recua, avanca).charAt(0) == '/') {
						recua++;
					}
					
					setExpressao(getExpressao().substring(recua, avanca));										
				}
				
			}
		}
		
	}
	
	/**
	 * Extrai e atribui os operandos e o operador
	 */
	private void extrair() {
		
		for(int indice = 0; indice < getExpressao().length(); indice++) {
			if(indice == 0 && getExpressao().charAt(indice) == '-' ||
			   indice == 0 && getExpressao().charAt(indice) == '+') {
				
				setOperandoA(getOperandoA() + String.valueOf(getExpressao().charAt(indice)));
				
			}else if (getExpressao().charAt(indice) >= '0' &&
					  getExpressao().charAt(indice) <= '9' || 
				      getExpressao().charAt(indice) == ',') {
				
				if(getOperador().equals("?"))
					setOperandoA(getOperandoA() + String.valueOf(getExpressao().charAt(indice)));					
				else
					setOperandoB(getOperandoB() + String.valueOf(getExpressao().charAt(indice)));				
			
			}else if(getExpressao().charAt(indice) == '/' || 
				 	 getExpressao().charAt(indice) == '*' || 
				 	 getExpressao().charAt(indice) == '-' || 
			 		 getExpressao().charAt(indice) == '+') {				
				
				setOperador(String.valueOf(getExpressao().charAt(indice)));
				
			}else if(getExpressao().charAt(indice) == '-' ||
					 getExpressao().charAt(indice) == '+') {
				
				setOperandoB(getOperandoB() + String.valueOf(getExpressao().charAt(indice)));
			}
		}
	}
	
	/**
	 * Refatora expressao baseado no resultado
	 * @param expressao
	 * @param resultado
	 * @return
	 */
	public String refatorar(String expressao, String resultado) {		
		if(resultado.charAt(0) != '-' && resultado.charAt(0) != '+') {
			resultado = "+" + resultado;
		}

		String novaExpressao = expressao.replaceFirst(Pattern.quote(getOperandoA()) + 
													  Pattern.quote(getOperador()) + 
													  Pattern.quote(getOperandoB()), 
													  resultado);		
		return novaExpressao;
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
