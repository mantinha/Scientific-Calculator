package br.fsa.adriano.scientific_calculator;

/**
 * JavaFX API
 * (A*) https://openjfx.io/javadoc/11/javafx.graphics/javafx/application/Application.html
 * (B*) https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/Scene.html
 * (C*) https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/Parent.html
 * (D*) https://openjfx.io/javadoc/11/javafx.graphics/javafx/stage/Stage.html
 * (E*) https://openjfx.io/javadoc/11/javafx.fxml/javafx/fxml/FXMLLoader.html
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Classe Principal inicia, configura e carrega a view calculadora
 * @author adriano 737679
 *
 */
public class CalcPrincipal extends Application {

	/**
	 * A classe principal precisa de um container(conteudo) que vai receber todos os
	 * componentes gráficos ver (B*)
	 */
    private static Scene conteudo;
    
    /**
     * Inicio padrao
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }    
    
    /**
     * Método que implementa Application ver (A*)
     * Carrego a view no meu conteúdo que está numa janela definindo um título, largura e
     * altura e exibindo ela.
     * @param janela que terá todo meu conteúdo ver (D*)
     * @throws IOException
     */
    @Override
    public void start(Stage janela) throws IOException {
        conteudo = new Scene(loadFXML("CalcView"), 600, 400);
        janela.setTitle("Calculadora");
        janela.setScene(conteudo);
        janela.show();
    }
    
    /**
     * Método que carrega a view ver (E*)
     * @param fxml (nome do arquivo da view)
     * @return (view)
     * @throws IOException (Passível de dar erro de entrada e saída de arquivo)
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalcPrincipal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}