package baseball.domain;

import java.util.List;

public class Input {

    /*
    * TODO
    * (E) 각 자리수는 중복될 수 없다.
    * (E) 각 자리수는 1~9 사이의 정수여야 한다.
    * (E) 입력값은 3자리의 수여야 한다.
    * (E) 입력값은 양수여야 한다.
    *
    * */

    private List<Integer> values;

    public Input() {}

    public Input(String str) {
        this.values = values;
    }

    public List<Integer> getValues() {
        return this.values;
    }

}
