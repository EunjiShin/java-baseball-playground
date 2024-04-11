package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Result {

    private int strike;
    private int ball;
    private boolean isNothing;
    private boolean isAnswer;

    public Result() {}

    public Result(Answer answer, Input input) {
        Map<Type, Integer> compareResult = compare(answer, input);
        this.strike = compareResult.get(Type.STRIKE);
        this.ball = compareResult.get(Type.BALL);
        this.isNothing = checkIsNothing(compareResult);
        this.isAnswer = checkIsAnswer(compareResult);
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public boolean isNothing() {
        return this.isNothing;
    }

    public boolean isAnswer() {
        return this.isAnswer;
    }

    private boolean checkIsNothing(Map<Type, Integer> compareResult) {
        Integer nothingCnt = compareResult.get(Type.NOTHING);
        return nothingCnt == Answer.TOTAL_DIGIT_SIZE;
    }

    private boolean checkIsAnswer(Map<Type, Integer> compareResult) {
        Integer strikeCnt = compareResult.get(Type.STRIKE);
        return strikeCnt == Answer.TOTAL_DIGIT_SIZE;
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
        List<Integer> answerValues = answer.getValues();
        List<Integer> inputValues = input.getValues();
        return Objects.equals(answerValues.get(index), inputValues.get(index));
    }

    private boolean isBall(Answer answer, Input input, int index) {
        List<Integer> answerValues = answer.getValues();
        List<Integer> inputValues = input.getValues();
        int target = inputValues.get(index);
        return answerValues.contains(target);
    }

}
