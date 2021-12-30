package programmers.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 입국심사 / 이분탐색
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 */
public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length-1] * n;

        while (left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;

            for (int time: times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    @Test
    void test() {
        Assertions.assertThat(solution(6, new int[]{7,10})).isEqualTo(28);
    }
}
