package programmers;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Crane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            // 인형 찾기
            for (int j = 0; j < board.length; j++) {
                int doll = board[j][move-1];
                if (doll != 0) {
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;  // 두개 사라짐

                    } else
                        stack.push(doll);

                    board[j][move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    void test() {
        Crane crane = new Crane();
        int answer = crane.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 5, 3}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});

        assertThat(answer).isEqualTo(4);

    }

}
