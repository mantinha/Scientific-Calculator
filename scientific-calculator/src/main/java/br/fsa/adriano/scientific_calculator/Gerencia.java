package br.fsa.adriano.scientific_calculator;

/**
 * Define os objetos de calculo
 * Executa os métodos os objetos
 * Retorna getExpressao()
 * 
 * @author adriano
 *
 */
public class Gerencia {
	
	private int quantidade;
	private String retorno;
	private String resultado;
	private AnalisaExpressao analise;
	private Expressao[] expressao;
	private CalculadoraSimples calculadora;
	
	public Gerencia(String expressao) {
		setRetorno(expressao);				
		analise = new AnalisaExpressao(getRetorno());		
		setQuantidade(analise);
	}
	
	public String resolver() {
		if(analise.priorOperadores() > 0) {			
			expressao = new Expressao[analise.priorOperadores()];			
			calculadora = new CalculadoraSimples();			
			for(int indice = 0; indice < analise.priorOperadores(); indice++) {
				expressao[indice] = new Expressao(getRetorno());				
				resultado = calculadora.opera( expressao[indice].getOperandoA(), 
											   expressao[indice].getOperador(), 
											   expressao[indice].getOperandoB());				
				setRetorno(expressao[indice].refatorar(getRetorno(), resultado));
			}
			
		}
		return getRetorno();
	}

	public int getQuantidade() {
		return quantidade;
	}

	private void setQuantidade(AnalisaExpressao quantidade) {
		this.quantidade = quantidade.priorOperadores();
	}
	
	public AnalisaExpressao getQtd() {
		return analise;
	}
	
	private String getRetorno() {
		return retorno;
	}
	
	private void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
}
