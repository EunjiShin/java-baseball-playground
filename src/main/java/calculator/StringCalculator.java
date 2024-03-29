package calculator;

public class StringCalculator {

  private final String[] inputs;
  private Operator operator = null;

  StringCalculator(final String expression) {
    checkExpression(expression);
    inputs = expression.split(" ");
  }

  public int calculate() {
    int result = 0;
    for (String input: inputs) {
      result = operate(result, input);
    }
    return result;
  }

  private void checkExpression(final String expression) {
    if (expression == null || expression.isEmpty() || expression.equals(" ")) {
      throw new IllegalArgumentException("수식을 입력해주세요.");
    }
  }

  private int operate(int result, final String input) {
    if (isOperator(input)) {
      operator = Operator.getOperator(input);
      return result;
    }

    int value = Integer.parseInt(input);
    return partialOperate(result, value);
  }

  private int partialOperate(final int result, final int value) {
    if (operator != null) {
      return operator.calculate(result, value);
    } else {
      return value;
    }
  }

  private boolean isOperator(final String input) {
    char token = input.charAt(0);
    return !Character.isDigit(token);
  }

}
