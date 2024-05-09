package mvc;

public class CalculatorModel {
    private String leftOperand;
    private String rightOperand;
    private String operation;
    private String result;

    public void setLeftOperand(String operand) {
        this.leftOperand = operand;
    }

    public void setRightOperand(String operand) {
        this.rightOperand = operand;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {

        return result;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public String getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }

}
