package calculator;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class InputValue {

  private final Deque<String> inputs = new LinkedList<>();

  InputValue() {
    Scanner scanner = new Scanner(System.in);
    String[] strs = scanner.nextLine().split(" ");
    Collections.addAll(inputs, strs);
    scanner.close();
  }

  public Deque<String> getInputs() {
    return inputs;
  }

}
