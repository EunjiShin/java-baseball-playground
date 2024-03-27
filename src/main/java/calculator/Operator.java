package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

  PLUS("+") {
    int calculate(final int a, final int b) { return a + b; }
  },
  SUBTRACT("-") {
    int calculate(final int a, final int b) { return a - b; }
  },
  MULTIPLY("*") {
    int calculate(final int a, final int b) { return a * b; }
  },
  DIVIDE("/") {
    int calculate(final int a, final int b) {
      if (b == 0) throw new ArithmeticException();
      return a / b;
    }
  };

  abstract int calculate(final int a, final int b);

  private final String symbol;

  private static final Map<String, Operator> operatorMap =
      Collections.unmodifiableMap(
          Stream.of(values()).collect(
              Collectors.toMap(Operator::getSymbol, Function.identity())
          )
      );

  public static Operator getOperator(final String symbol) {
    Operator operator = operatorMap.get(symbol);
    if (operator == null) throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
    return operator;
  }

  Operator(final String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

}
