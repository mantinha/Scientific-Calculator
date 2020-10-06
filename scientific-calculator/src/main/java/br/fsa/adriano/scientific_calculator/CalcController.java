package br.fsa.adriano.scientific_calculator;

/**
 * JavaFX API
 * (F*) https://openjfx.io/javadoc/12/javafx.fxml/javafx/fxml/FXML.html
 * (G*) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
 * (H*) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
 * (I*) https://openjfx.io/javadoc/11/javafx.base/javafx/event/ActionEvent.html
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * O controller mapeia os atributos e métodos pela annotation @FXML ver (F*)
 * A instância da classe é feita somente se o caminho dela estiver
 * na tag VBox do FXML.
 * Os métodos serão executados se estiverem mencionados na tag
 * do componente.
 * 
 * @author adriano 737679
 *
 */
public class CalcController {
	
	@FXML
    private TextField campo;
	
	@FXML
    private Button btnApagar;
	
	@FXML
    private Button btnVoltar;
	
	@FXML
    private Button btnSimetria;

    @FXML
    private Button parentEsq;

    @FXML
    private Button parentDir;

    @FXML
    private Button btnUm;

    @FXML
    private Button btnDois;

    @FXML
    private Button btnTres;

    @FXML
    private Button btnQuatro;

    @FXML
    private Button btnCinco;

    @FXML
    private Button btnSeis;

    @FXML
    private Button btnSete;

    @FXML
    private Button btnOito;

    @FXML
    private Button btnNove;
    
    @FXML
    private Button btnZero;
    
    @FXML
    private Button btnPonto;
    
    @FXML
    private Button btnMais;
    
    @FXML
    private Button btnMenos;
    
    @FXML
    private Button btnMultiplica;
    
    @FXML
    private Button btnDivide;
    
    @FXML
    private Button btnIgual;
    
    @FXML
    private Button btnPotenciaDeDois;
    
    @FXML
    private Button btnRaiz;
    
    @FXML
    private Button btnInverso;
    
    @FXML
    private Button btnFatorial;
    
    @FXML
    private Button btnPotencia;
    
    @FXML
    private Button btnResto;
    
    @FXML
    private Button btnSeno;
    
    @FXML
    private Button btnCosseno;
    
    @FXML
    private Button btnTangente;
    
    @FXML
    private Button btnLog;
    
    /**
     * Metodo utilitario
	 * Reseta todo o campo da calculadora para '0'
	 */
	@FXML
	private void apagar() {		
		campo.setText("0");
	}
	
	/**
     * Metodo utilitario
	 * Deleta ultimo caractere até sobrar 1
	 */
	@FXML
	private void voltar() {
		if(campo.getText().length() != 1)
			campo.setText(campo.getText().substring(0, campo.getText().length() - 1));		
	}
	
	/**
     * Metodo utilitario
	 * Altera sinal positivo e negativo
	 */
	@FXML
	private void simetria() {
		if(campo.getText().charAt(0) == '0') {			
		}else if(campo.getText().charAt(0) == '-')
			campo.setText(campo.getText().replace('-', '+'));
		else if(campo.getText().charAt(0) == '+')
			campo.setText(campo.getText().replace('+', '-'));
		else
			campo.setText("-" + campo.getText());
	}
	
	@FXML
	private void abrirParenteses() {
		if(campo.getText().equals("0"))
			campo.setText("");
		
		campo.setText(campo.getText() + "(");		
	}
	
	@FXML
	private void fecharParenteses() {
		if(campo.getText().equals("0"))
			campo.setText("");
		
		campo.setText(campo.getText() + ")");		
	}
	
	@FXML
	private void escreverUm() {
		if(campo.getText().equals("0"))
			campo.setText("");
	
		campo.setText(campo.getText() + "1");		
	}
	
	@FXML
	private void escreverDois() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "2");		
	}
	
	@FXML
	private void escreverTres() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "3");		
	}
	
	@FXML
	private void escreverQuatro() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "4");		
	}
	
	@FXML
	private void escreverCinco() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "5");		
	}
	
	@FXML
	private void escreverSeis() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "6");		
	}
	
	@FXML
	private void escreverSete() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "7");		
	}
	
	@FXML
	private void escreverOito() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "8");		
	}
	
	@FXML
	private void escreverNove() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "9");		
	}
	
	@FXML
	private void escreverZero() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "0");		
	}
	
	@FXML
	private void escreverSoma() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "+");		
	}
	
	@FXML
	private void escreverSubtracao() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "-");		
	}
	
	@FXML
	private void escreverMultiplicacao() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "*");		
	}
	
	@FXML
	private void escreverDivisao() {
		if(campo.getText().equals("0"))
			campo.setText("");

		campo.setText(campo.getText() + "/");		
	}
	
	@FXML
	private void escreverPonto() {
		if(campo.getText().length() > 0 && campo.getText().charAt( campo.getText().length() - 1 ) != '.')
			campo.setText(campo.getText() + ".");		
	}
	
	/**
	 * Processa todas as operações aritmeticas  
	 */
	@FXML
	private void lerExpressao() {
		
		Expressao expressao = new Expressao(campo.getText());		
		campo.setText(expressao.priorizar());
		
	}
	
	@FXML
	private void potenciaDeDois() {
		
		CalcSimples calculadora = new CalcSimples();
		String resultado = String.valueOf( calculadora.potencializar( Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
	@FXML
	private void raizQuadrada() {
		
		CalcSimples calculadora = new CalcSimples();
		String resultado = String.valueOf( calculadora.radicalizar( Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
	@FXML
	private void inverso() {
		
		CalcSimples calculadora = new CalcSimples();
		String resultado = String.valueOf( calculadora.dividir( 1.0, Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
	/**
	 * Calcula o fatorial de um número
	 */
	@FXML
	private void fatorial() {
		
		CalcSimples calculadora = new CalcSimples();
		campo.setText( String.valueOf( calculadora.fatorar( Double.valueOf( campo.getText() ) ) ) );
		
	}
	
	@FXML
	private void elevadoA() {
		
		if(campo.getText().length() > 0 && campo.getText().charAt( campo.getText().length() - 1 ) != '^')
			campo.setText(campo.getText() + "^");

	}
	
	@FXML
	private void resto() {
		
		if(campo.getText().length() > 0 && campo.getText().charAt( campo.getText().length() - 1 ) != 'm')
			campo.setText(campo.getText() + "m");
		
	}
	
	@FXML
	private void calculaSeno() {
		
		CalcCientifica calculadora = new CalcCientifica();
		String resultado = String.valueOf( calculadora.seno( Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
	@FXML
	private void calculaCosseno() {
		
		CalcCientifica calculadora = new CalcCientifica();
		String resultado = String.valueOf( calculadora.cosseno( Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
	@FXML
	private void calculaTangente() {
		
		CalcCientifica calculadora = new CalcCientifica();
		String resultado = String.valueOf( calculadora.tangente( Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
	@FXML
	private void calculaLogaritmo() {
		
		CalcCientifica calculadora = new CalcCientifica();
		String resultado = String.valueOf( calculadora.logaritmo( Double.valueOf( campo.getText() ) ) );
		
		if(resultado.contains(".0"))
			resultado = resultado.replaceAll(".0", "");
		campo.setText( resultado );
		
	}
	
}
