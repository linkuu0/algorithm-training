package programmers.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class LargestNumber {

    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));
        return String.join("", strNumbers);
    }

    @Test
    void test() {
        String answer = solution(new int[]{6, 10, 2});
        Assertions.assertThat(answer).isEqualTo("6210");
    }

    @Test
    void test2() {
        String answer = solution(new int[]{3, 30, 34, 5, 9});
        Assertions.assertThat(answer).isEqualTo("9534330");
    }
}
