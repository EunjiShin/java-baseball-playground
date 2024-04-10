package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private int strike;
    private int ball;
    private boolean nothing;

    public Result() {}

    public Result(Answer answer, Input input) {
        Map<Type, Integer> compareResult = compare(answer, input);
        this.strike = compareResult.get(Type.STRIKE);
        this.ball = compareResult.get(Type.BALL);
        this.nothing = checkIsNothing(compareResult);
    }

    private boolean checkIsNothing(Map<Type, Integer> compareResult) {
        Integer nothingCnt = compareResult.get(Type.NOTHING);
        return nothingCnt == 3;
    }

    private Map<Type, Integer> compare(Answer answer, Input input) {
        Map<Type, Integer> result = initResultMap();
        for (int i = 0; i < Answer.TOTAL_DIGIT_SIZE; i++) {
            Type type = checkType(answer, input, i);
            result.merge(type, 1, Integer::sum);
        }
        return result;
    }

    private Map<Type, Integer> initResultMap() {
        Map<Type, Integer> result = new HashMap<>();
        result.put(Type.STRIKE, 0);
        result.put(Type.BALL, 0);
        result.put(Type.NOTHING, 0);
        return result;
    }

    private Type checkType(Answer answer, Input input, int index) {
        boolean isStrike = isStrike(answer, input, index);
        boolean isBall = isBall(answer, input, index);

        if (isStrike) {
            return Type.STRIKE;
        }

        if (isBall) {
            return Type.BALL;
        }

        return Type.NOTHING;
    }

    private boolean isStrike(Answer answer, Input input, int index) {
        int[] answerValues = answer.getValues();
        int[] inputValues = input.getValues();
        return answerValues[index] == inputValues[index];
    }

    private boolean isBall(Answer answer, Input input, int index) {
        int[] answerValues = answer.getValues();
        int[] inputValues = input.getValues();
        int target = inputValues[index];
        return contains(answerValues, target);
    }

    // FIXME: depth 2임!
    private boolean contains(int[] array, int target) {
        for (int value : array) {
            if (target == value) {
                return true;
            }
        }
        return false;
    }

}
