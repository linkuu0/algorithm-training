package programmers.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [프로그래머스] Lv.2 가장 큰 정사각형 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 * TODO DP 문제 다시 확인!
 */
public class SmallestSquare {
    public int solution(int[][] board) {
        if (board.length == 1 && board[0].length == 1)
            return board[0][0];

        int answer = 0;
        int max = 0;

        for (int i=1; i<board.length; i++) {
            for (int j=1; j<board[i].length; j++) {
                if (board[i][j] == 1) {
                    int min = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]));
                    board[i][j] = min + 1;

                    max = Math.max(max, min+1);


                }
            }

        }
        answer = max * max;
        return answer;
    }

    @Test
    void test() {
        int answer = solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});
        Assertions.assertThat(answer).isEqualTo(9);

        int answer2 = solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}});
        Assertions.assertThat(answer2).isEqualTo(4);
    }
}
