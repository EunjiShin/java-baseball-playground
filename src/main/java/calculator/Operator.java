package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

  PLUS("+", (a, b) -> a + b),
  SUBTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> {
    if (b == 0) throw new ArithmeticException();
    return a / b;
  });

  private final String symbol;
  private final BiFunction<Integer, Integer, Integer> formula;

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

  Operator(final String symbol, final BiFunction<Integer, Integer, Integer> formula) {
    this.symbol = symbol;
    this.formula = formula;
  }

  public String getSymbol() {
    return symbol;
  }

  public Integer calculate(final Integer a, final Integer b) {
    return formula.apply(a, b);
  }

}
