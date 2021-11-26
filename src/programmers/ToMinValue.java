package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * [프로그래머스] Lv.2 최솟값 만들기
 * @link https://programmers.co.kr/learn/courses/30/lessons/12941
 */
public class ToMinValue {
    static int solution(int[] a, int[] b) {
        int answer = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i=0; i<a.length; i++) {
            answer += (a[i] * b[a.length - i - 1]);
        }

        return answer;
    }

    @Test
    void test() {
        int answer = solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        Assertions.assertThat(answer).isEqualTo(29);
    }

    @Test
    void test2() {
        int answer = solution(new int[]{1, 2}, new int[]{3, 4});
        Assertions.assertThat(answer).isEqualTo(10);
    }
}
