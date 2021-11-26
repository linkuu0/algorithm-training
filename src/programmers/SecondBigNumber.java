package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 *
 * 제한 사항. n은 1,000,000 이하의 자연수 입니다.
 */
public class SecondBigNumber {

    static public int solution(int n) {
        int answer = n;
//        int count = Integer.toBinaryString(n).replace("0", "").length();
         int count = Integer.bitCount(n);

        while (true) {
//            int next = Integer.toBinaryString(++answer).replace("0", "").length();
             int next = Integer.bitCount(++answer);

            if (count == next) {
                break;
            }
        }
        return answer;
    }


    @Test
    void test1() {
        int answer = solution(78);
        Assertions.assertThat(answer).isEqualTo(83);
    }

    @Test
    void test2() {
        int answer = solution(15);
        Assertions.assertThat(answer).isEqualTo(23);
    }
}
