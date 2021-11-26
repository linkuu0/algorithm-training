package programmers.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 숫자의 표현 Lv.2
 * @link https://programmers.co.kr/learn/courses/30/lessons/12924
 */
public class NumberPresent {
    static public int solution(int n) {
        int answer = 0;
        for (int i=1; i<=n; i += 2) {
            if (n % i == 0) {
                answer++;
            }
        }

        return answer;
    }

    static public int solution2(int n) {
        int answer = 0;

        int d = 1;
        while (n / d != 0) {
            if (n % 2 == 1 && n % d == 0) {
                System.out.println("n = " + n);
                System.out.println("d = " + d);
                answer++;
            }

            // 짝수는 못하겠네 ㅎㅎ;

            d++;
        }

        return answer;
    }

    @Test
    void test1() {
        int answer = solution(15);
        Assertions.assertThat(answer).isEqualTo(4);
    }

    @Test
    void test2() {
        int answer = solution(9);
        Assertions.assertThat(answer).isEqualTo(3);
    }

    @Test
    void test3() {
        int answer = solution(10);
        Assertions.assertThat(answer).isEqualTo(2);
    }

}
