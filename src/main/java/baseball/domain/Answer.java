package baseball.domain;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// 사용자 입력값과 Answer은 동일한 조건을 갖는다. 하나의 클래스로 관리하는 것이 더 간편할까?
// 일단은 서로 다른 성격의 데이터니 별도의 클래스로 관리해보자.
public class Answer {

    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;
    public static final int TOTAL_DIGIT_SIZE = 3;

    private static final Random rand = new SecureRandom();

    private int[] values;

    public Answer() {
        init();
    }

    public int[] getValues() {
        return this.values;
    }

    private void init() {
        Set<Integer> randomValues = new HashSet<>();
        while(randomValues.size() <= TOTAL_DIGIT_SIZE) {
            int randomValue = rand.nextInt(MAX_DIGIT) + MIN_DIGIT;
            randomValues.add(randomValue);
        }
        this.values = convertSetToArray(randomValues);
    }

    private int[] convertSetToArray(Set<Integer> set) {
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
