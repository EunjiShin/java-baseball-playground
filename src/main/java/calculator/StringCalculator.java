package calculator;

public class StringCalculator {

  private final String[] inputs;
  private Operator operator = null;

  private static final String BLANK = " ";

  StringCalculator(final String expression) {
    checkExpression(expression);
    inputs = expression.split(BLANK);
  }

  private void checkExpression(final String expression) {
    if (expression == null || expression.isEmpty() || expression.equals(BLANK)) {
      throw new IllegalArgumentException("수식을 입력해주세요.");
    }
  }

  public int calculate() {
    int result = 0;
    for (String input: inputs) {
      if (Operand.isNotOperand(input)) {
        operator = Operator.findBySymbol(input);
        continue;
      }
      result = operate(result, input);
    }
    return result;
  }

  private int operate(int result, final String input) {
    Operand operand = new Operand(input);
    final int value = operand.getValue();
    if (operator != null) {
      return operator.calculate(result, value);
    }
    return value;
  }

}
