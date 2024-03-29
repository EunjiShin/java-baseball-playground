package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  private StringCalculator createCalculator(String expression) {
    return new StringCalculator(expression);
  }

  @ParameterizedTest
  @CsvSource(value = {"1 + 3:4", "23 + 14:37"}, delimiter = ':')
  @DisplayName("덧셈을 할 수 있다.")
  void plus(String expression, int result) {
    assertThat(createCalculator(expression).calculate()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"3 - 1:2", "21 - 16:5"}, delimiter = ':')
  @DisplayName("뺄셈을 할 수 있다.")
  void subtract(String expression, int result) {
    assertThat(createCalculator(expression).calculate()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4 * 8:32", "11 * 5:55"}, delimiter = ':')
  @DisplayName("곱셈을 할 수 있다.")
  void multiply(String expression, int result) {
    assertThat(createCalculator(expression).calculate()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"6 / 2:3", "42 / 12:3"}, delimiter = ':')
  @DisplayName("나눗셈을 할 수 있다.")
  void divide(String expression, int result) {
    assertThat(createCalculator(expression).calculate()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2:10", "4 - 2 * 5 / 3 + 2:5"}, delimiter = ':')
  @DisplayName("둘 이상의 연산을 할 수 있다.")
  void calculate(String expression, int result) {
    assertThat(createCalculator(expression).calculate()).isEqualTo(result);
  }

  @ParameterizedTest
  @ValueSource(strings = {"3 / 0", "2 + 4 / 0"})
  @DisplayName("[예외] 0으로 나눌 경우 예외를 반환한다.")
  void divideZero(String input) {
    assertThrows(
        ArithmeticException.class,
        () -> createCalculator(input).calculate()
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " "})
  @DisplayName("[예외] 입력값이 없다면 예외를 반환한다.")
  void emptyInput(String input) {
    assertThrows(
        IllegalArgumentException.class,
        () -> createCalculator(input).calculate()
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"4 / 3 % 3", "2 & 4 + 3"})
  @DisplayName("[예외] 지원하지 않는 연산자를 입력하면 예외를 반환한다.")
  void invalidOperator(String input) {
    assertThrows(
        IllegalArgumentException.class,
        () -> createCalculator(input).calculate()
    );
  }

}
