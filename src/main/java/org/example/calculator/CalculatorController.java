package org.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    public Label resultLabel;
    public TextField num1Field;
    public TextField num2Field;

    @FXML
    public void onAddButtonClick() {
        performOperation('+');
    }
    @FXML
    public void onSubtractButtonClick() {
        performOperation('-');
    }
    @FXML
    public void onMultiplyButtonClick() {
        performOperation('*');
    }
    @FXML
    public void onDivideButtonClick() {
        performOperation('/');
    }

    private void performOperation(char operator) {
        String num1Text = num1Field.getText();
        String num2Text = num2Field.getText();

        if ( !(isValidNumber(num1Text) && isValidNumber(num2Text)) ) {
            resultLabel.setText("Result: Invalid input!");
            return;
        }

        double num1 = Double.parseDouble(num1Text);
        double num2 = Double.parseDouble(num2Text);
        double result = 0.0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultLabel.setText("Result: Error!(Division by zero)");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                break;
        }
        num1Field.setText("");
        num2Field.setText("");
        resultLabel.setText("Result: " + result);
    }
    private boolean isValidNumber(String number) {
        return number.matches("-?\\d*\\.?\\d+");
    }
}
