package calculator;

public class MainApplication {

  public static void main(String[] args) {
    InputValue inputValue = new InputValue();
    StringCalculator calculator = new StringCalculator();

    String result = calculator.calculate(inputValue.getInputs());
    System.out.print(result);
  }

}
