package calculator;

public class StringCalculator {

  private final String[] inputs;
  private Operator operator;

  StringCalculator(final String expression) {
    inputs = expression.split(" ");
  }

  public int calculate() {
    int result = 0;
    for (String input: inputs) {
      result = operate(result, input);
    }
    return result;
  }

  private int operate(int result, final String input) {
    if (isOperator(input)) {
      operator = Operator.getOperator(input);
      return result;
    }

    int value = Integer.parseInt(input);
    if (operator != null) {
      result = operator.calculate(result, value);
    }
    return result;
  }

  private boolean isOperator(final String input) {
    char token = input.charAt(0);
    return !Character.isDigit(token);
  }

}
