package baseball.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String readInputNumber() {
        return scanner.nextLine();
    }

}
