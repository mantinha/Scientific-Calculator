module br.fsa.adriano.scientific_calculator {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.swing;

    opens br.fsa.adriano.scientific_calculator to javafx.fxml;
    exports br.fsa.adriano.scientific_calculator;
}