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
import javafx.event.ActionEvent;

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
public class CalculadoraController {    
    
	private boolean virgula;
	
	@FXML
    private TextField campo;
	
    @FXML
    private Button limpa;

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
    private Button btnVirgula;
    
    @FXML
    private Button mais;
    
    @FXML
    private Button menos;
    
    @FXML
    private Button multiplica;
    
    @FXML
    private Button divide;
    
    @FXML
    private Button igual;
    
    private boolean isVirgula() {
    	return virgula;
    }
    
    private void setVirgula(boolean virgula) {
    	this.virgula = virgula;
    }
    
    /**
     * Se o campo conter somente '0' o campo é limpo para escrita
     * O método escreve e controla para que somente uma vírgula seja escrita
     * por operando
     * @param evento
     */
	@FXML
	private void mapeiaBotao(ActionEvent evento) {
		if(campo.getText().equals("0"))
			campo.setText("");
		
		if(!isVirgula() && evento.toString().charAt(evento.toString().length()-3) != ',')
			campo.setText(campo.getText() + evento.toString().charAt(evento.toString().length()-3));
		else if(!isVirgula() && evento.toString().charAt(evento.toString().length()-3) == ',') {
			campo.setText(campo.getText() + evento.toString().charAt(evento.toString().length()-3));
			setVirgula(true);
		}else if(isVirgula() && evento.toString().charAt(evento.toString().length()-3) != ',')
			campo.setText(campo.getText() + evento.toString().charAt(evento.toString().length()-3));
		
		if(	evento.toString().charAt(evento.toString().length()-3) == '+' ||
			evento.toString().charAt(evento.toString().length()-3) == '-' ||
			evento.toString().charAt(evento.toString().length()-3) == '*' ||
			evento.toString().charAt(evento.toString().length()-3) == '/')
			setVirgula(false);
	}
	
	/**
	 * Substitui todo o campo da calculadora para '0'
	 * Reseta o controle de vírgula
	 */
	@FXML
	private void apaga() {		
		campo.setText("0");
		setVirgula(false);
	}
	
	/**
	 * Processa todas as operações contendo parênteses
	 * Filtra o texto separando os operadores do operando
	 * @param x = contador
	 * @param y = quantidade de operandos
	 * @param z = quantidade de operadores  
	 */
	@FXML
	private void lerExpressao() {
		
//		ResolvePrioridade prioridade = new ResolvePrioridade(campo.getText());
//		if(prioridade.getQuantidade() > 0 ) {			
//			campo.setText(prioridade.resolve());
//		}
		
		Gerencia gerencia = new Gerencia(campo.getText());
		if(gerencia.getQuantidade() > 0 ) {
			campo.setText(gerencia.resolver().substring(1));
		}
	}
	
}
