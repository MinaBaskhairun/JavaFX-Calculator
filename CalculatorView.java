package mvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculatorView extends BorderPane {

    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button0 = new Button("0");
    Button button3 = new Button("3");
    Button button4 = new Button("4");
    Button button5 = new Button("5");
    Button button6 = new Button("6");
    Button button7 = new Button("7");
    Button button8 = new Button("8");
    Button button9 = new Button("9");

    Button addButton = new Button("+");
    Button subtractButton = new Button("-");
    Button multiplyButton = new Button("*");
    Button divideButton = new Button("/");

    Button equalsButton = new Button("=");
    Button clearButton = new Button("C");
    Button clearEntryButton = new Button("CE");

    private TextField inputField;

    public CalculatorView() {
        inputField = new TextField();
        inputField.setEditable(false);


        HBox topRow = new HBox(5, button7, button8, button9, divideButton);
        HBox middleRow = new HBox(5, button4, button5, button6, multiplyButton);
        HBox bottomRow = new HBox(5, button1, button2, button3, subtractButton);
        HBox lastRow = new HBox(5, clearEntryButton, button0, clearButton, addButton);
        HBox resultRow = new HBox(5, equalsButton);

        VBox buttonBox = new VBox(6, topRow, middleRow, bottomRow, lastRow, resultRow);
        setCenter(buttonBox);

        setTop(inputField);
        BorderPane.setAlignment(inputField, Pos.CENTER);
    }

    public String getInputText() {
        return inputField.getText();
    }

    public void setInputText(String text) {
        inputField.setText(text);
    }

}

