package br.fsa.adriano.scientific_calculator;

/**
 * Analisa quantidade de operacoes em parenteses
 * Analisa quantidade de operacoes em geral
 * @author adriano
 *
 */
public class AnalisaExpressao {

	private String expressao;
	private int ocorrencia;
	
	public AnalisaExpressao(String expressao) {
		setExpressao(expressao);
	}
	
	public int priorParenteses() {
		setOcorrencia(0);
		for(int indice = 0; indice < getExpressao().length(); indice++) {
			if(getExpressao().charAt(indice) == '(') {
				setOcorrencia(getOcorrencia() + 1);
			}
		}		
		return getOcorrencia();
	}
	
	public int priorOperadores() {
		setOcorrencia(0);
		for(int indice = 0; indice < getExpressao().length(); indice++) {			
			if(getExpressao().charAt(indice) == '/' || 
			   getExpressao().charAt(indice) == '*' || 
			   getExpressao().charAt(indice) == '-' || 
			   getExpressao().charAt(indice) == '+') {
				setOcorrencia(getOcorrencia() + 1);
			}
		}		
		return getOcorrencia();
	}

	private String getExpressao() {
		return expressao;
	}

	private void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	private int getOcorrencia() {
		return ocorrencia;
	}

	private void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
}
