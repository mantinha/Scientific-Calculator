package br.fsa.adriano.scientific_calculator;

/**
 * Define os objetos de calculo
 * Executa os métodos os objetos
 * Retorna getExpressao()
 * 
 * @author adriano
 *
 */
public class ResolvePrioridade {
	
	private int quantidade;
	private String expressao;
	private String resultado;
	private AnalisaExpressao analise;
	private TrataParenteses[] tp;
	private CalculadoraSimples calc;

	public ResolvePrioridade(String expressao) {
		setExpressao(expressao);				
		analise = new AnalisaExpressao(getExpressao());		
		setQuantidade(analise);
	}
	
	public String resolve() {
		if(analise.priorParenteses() > 0) {
						
			tp = new TrataParenteses[analise.priorParenteses()];
			calc = new CalculadoraSimples();			
			for(int indice = 0; indice < analise.priorParenteses(); indice++) {
				tp[indice] = new TrataParenteses();
				
				tp[indice].extraiOperacao(getExpressao());
				resultado = calc.opera( tp[indice].getOperandoA(), 
										tp[indice].getOperador(), 
										tp[indice].getOperandoB());
				
				setExpressao(tp[indice].refatoraExpressao(getExpressao(), resultado));
			}
			
		}
		return getExpressao();
	}

	public int getQuantidade() {
		return quantidade;
	}

	private void setQuantidade(AnalisaExpressao quantidade) {
		this.quantidade = quantidade.priorParenteses();
	}

	public AnalisaExpressao getQtd() {
		return analise;
	}	

	private String getExpressao() {
		return expressao;
	}

	private void setExpressao(String expressao) {
		this.expressao = expressao;
	}
	
}
