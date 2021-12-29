package programmers.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * K번째 수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++) {
            int[] slices = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(slices);

            answer[i] = slices[commands[i][2] - 1];
        }

        return answer;
    }

    @Test
    void test() {
        int[] answer = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        Assertions.assertThat(answer).isEqualTo(new int[]{5,6,3});
    }
}
