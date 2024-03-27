package calculator;

import java.util.Deque;

public class StringCalculator {

  public String calculate(final Deque<String> inputs) {
    while (inputs.size() >= 3) {
      // FIXME: a, operator, b를 생성하는 순서가 섞이면 제대로 동작하지 않을텐데, 어떻게 개선할 수 있지?
      final int a = Integer.parseInt(inputs.removeFirst());
      final Operator operator = Operator.getOperator(inputs.removeFirst());
      final int b = Integer.parseInt(inputs.removeFirst());
      final String resultStr = operate(a, b, operator);
      inputs.addFirst(resultStr);
    }
    return inputs.poll();
  }

  private String operate(final int a, final int b, final Operator operator) {
    int result = operator.calculate(a, b);
    return String.valueOf(result);
  }

}
