package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * [프로그래머스] Lv.2 최댓값과 최솟값
 * @link https://programmers.co.kr/learn/courses/30/lessons/12939
 */
public class MaxAndMin {
    static public String solution(String s) {
        String answer = "";
        int[] arr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        answer += String.valueOf(Arrays.stream(arr).min().getAsInt()) + " ";
        answer += String.valueOf(Arrays.stream(arr).max().getAsInt());

        return answer;
    }

    @Test
    void test1() {
        String answer = solution("1 2 3 4");
        Assertions.assertThat(answer).isEqualTo("1 4");
    }

    @Test
    void test2() {
        String answer = solution("-1 -2 -3 -4");
        Assertions.assertThat(answer).isEqualTo("-4 -1");
    }

    @Test
    void test3() {
        String answer = solution("-1 -1");
        Assertions.assertThat(answer).isEqualTo("-1 -1");
    }
}
