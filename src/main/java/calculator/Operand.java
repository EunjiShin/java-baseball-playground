package calculator;

public class Operand {

  private final int value;

  Operand(final String input) {
    try {
      value = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new NumberFormatException("숫자가 아닙니다.");
    }
  }

  public int getValue() {
    return value;
  }

  public static boolean isNotOperand(final String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return true;
    }

    return false;
  }

}
