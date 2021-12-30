package programmers.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 징검다리
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 */
public class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;

        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for (int rock: rocks) {
                if (rock - prev < mid) {
                    cnt++;

                    if (cnt > n)
                        break;

                } else {
                    prev = rock;

                }
            }

            if (cnt > n) {
                right = mid - 1;

            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);

            }
        }

        return answer;
    }

    @Test
    void test() {
        int answer = solution(25, new int[]{2, 14, 11, 21, 17}, 2);
        Assertions.assertThat(answer).isEqualTo(4);
    }
}
