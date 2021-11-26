package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [프로그래머스] Lv.2 피보나치 수
 * @link https://programmers.co.kr/learn/courses/30/lessons/12945
 */
public class Fibonacci {
    public int solution(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int[] fibo = new int[n+1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i=3; i<=n; i++) {
            // Int 범위 초과!
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }

        return fibo[n];
    }

    @Test
    void test1() {
        int answer = solution(3);
        Assertions.assertThat(answer).isEqualTo(2);
    }

    @Test
    void test2() {
        int answer = solution(5);
        Assertions.assertThat(answer).isEqualTo(5);
    }

    @Test
    void test3() {
        int answer = solution(5);
        Assertions.assertThat(answer).isEqualTo(5);
    }
}
