package mvc;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Add button handlers
        view.addButton.setOnAction(e -> handleOperationButton("+"));
        view.subtractButton.setOnAction(e -> handleOperationButton("-"));
        view.multiplyButton.setOnAction(e -> handleOperationButton("*"));
        view.divideButton.setOnAction(e -> handleOperationButton("/"));

        view.equalsButton.setOnAction(e -> handleEqualsButton());
        view.clearButton.setOnAction(e -> handleClearButton());
        view.clearEntryButton.setOnAction(e -> handleClearEntryButton());

        // Add button handlers for number buttons
        view.button0.setOnAction(e -> handleNumberButton("0"));
        view.button1.setOnAction(e -> handleNumberButton("1"));
        view.button2.setOnAction(e -> handleNumberButton("2"));
        view.button3.setOnAction(e -> handleNumberButton("3"));
        view.button4.setOnAction(e -> handleNumberButton("4"));
        view.button5.setOnAction(e -> handleNumberButton("5"));
        view.button6.setOnAction(e -> handleNumberButton("6"));
        view.button7.setOnAction(e -> handleNumberButton("7"));
        view.button8.setOnAction(e -> handleNumberButton("8"));
        view.button9.setOnAction(e -> handleNumberButton("9"));
    }

    private void handleNumberButton(String number) {
        String input = view.getInputText();
        view.setInputText(input + number);
    }

    private void handleOperationButton(String operation) {
        String input = view.getInputText();
        model.setLeftOperand(input);
        model.setOperation(operation);
        view.setInputText("");
    }

    private void handleEqualsButton() {
        String input = view.getInputText();
        model.setRightOperand(input);

        String operation = model.getOperation();
        String leftOperand = model.getLeftOperand();
        String rightOperand = model.getRightOperand();

        // Perform the corresponding calculation based on the operation
        // Set the result in the model
        String result = performCalculation(operation, leftOperand, rightOperand);
        model.setResult(result);

        // Update the input field in the view
        view.setInputText(result);
    }

    private void handleClearButton() {
        String input = view.getInputText();
        if (!input.isEmpty()) {
            // Remove the last digit
            input = input.substring(0, input.length() - 1);
            view.setInputText(input);
        }
    }

    private void handleClearEntryButton() {
        view.setInputText("");
    }

    // Method to perform calculation based on the operation
    private String performCalculation(String operation, String leftOperand, String rightOperand) {
        double left = Double.parseDouble(leftOperand);
        double right = Double.parseDouble(rightOperand);
        double result = 0;

        switch (operation) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                if (right != 0) {
                    result = left / right;
                } else {
                    return "Error: Division by zero";
                }
                break;
            case"=":
                return Double.toString(result);

            default:
                return "Error: Invalid operation";
        }

        return Double.toString(result);
    }
}
