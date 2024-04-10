package baseball.view;

import baseball.domain.Result;

public class ResultView {

    public ResultView() {}

    public void printResult(Result result) {
        boolean isNothing = result.isNothing();
        boolean isAnswer = result.isAnswer();
        int strikeCnt = result.getStrike();
        int ballCnt = result.getBall();

        if (isNothing) {
            System.out.println("낫싱");
            return;
        }

        if (isAnswer) {
            System.out.println(strikeCnt+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (ballCnt > 0) {
            System.out.print(ballCnt+"볼 ");
        }

        if (strikeCnt > 0) {
            System.out.println(strikeCnt+"스트라이크");
        }
    }

}
