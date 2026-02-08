module org.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.calculator to javafx.fxml;
    exports org.example.calculator;
}