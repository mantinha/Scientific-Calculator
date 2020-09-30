module br.fsa.adriano.scientific_calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.fsa.adriano.scientific_calculator to javafx.fxml;
    exports br.fsa.adriano.scientific_calculator;
}