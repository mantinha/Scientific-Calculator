package br.fsa.adriano.scientific_calculator;

public class TrataParenteses {
	
	private String expressao;
	private String operandoA;
	private String operandoB;
	private String operador;
	
	public void extraiOperacao(String expressao) {
		
		String[] corte;
		
		for(int indice = 0; indice < expressao.length(); indice++) {
			if(expressao.charAt(indice) == '(') {
				corte = expressao.split("\\(");
				extraiOperacao(corte[1]);
				break;
			}
			if(expressao.charAt(indice) == ')') {
				corte = expressao.split("\\)");
				setExpressao(corte[0]);
				break;
			}
		}
		
		extraiOperandos(expressao);
	}
	
	private void extraiOperandos(String expressao) {
		
		boolean ocorrencia = false;
		
		for(int indice = 0; indice < getExpressao().length(); indice++) {
			if (getExpressao().charAt(indice) >= '0' &&
				getExpressao().charAt(indice) <= '9' || 
				getExpressao().charAt(indice) == ',') {
				
				if(!ocorrencia) {
					setOperandoA(String.valueOf(getExpressao().charAt(indice)));
					ocorrencia = !ocorrencia;
				}else
					setOperandoB(String.valueOf(getExpressao().charAt(indice)));
				
			}else if(getExpressao().charAt(indice) == '/' || 
					 getExpressao().charAt(indice) == '*' || 
					 getExpressao().charAt(indice) == '-' || 
					 getExpressao().charAt(indice) == '+') {

				setOperador(String.valueOf(getExpressao().charAt(indice)));
			}
		}
	}
	
	public String refatoraExpressao(String expressao, String resultado) {
		String corte = "";
		String novaExpressao = "";
		
		for(int indice = 0; indice < expressao.length(); indice++) {
			if(expressao.charAt(indice) == '(') {
				corte = expressao.substring(0, indice) + resultado;
			}
			if(expressao.charAt(indice) == ')') {
				novaExpressao = corte + expressao.substring(indice + 1, expressao.length());				
				break;
			}
		}
		return novaExpressao;
	}

	public String getExpressao() {
		return expressao;
	}

	private void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public String getOperandoA() {
		return operandoA;
	}

	private void setOperandoA(String operandoA) {
		this.operandoA = operandoA;
	}

	public String getOperandoB() {
		return operandoB;
	}

	private void setOperandoB(String operandoB) {
		this.operandoB = operandoB;
	}

	public String getOperador() {
		return operador;
	}

	private void setOperador(String operador) {
		this.operador = operador;
	}
	
	
}
