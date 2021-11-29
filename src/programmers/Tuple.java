package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Tuple {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();

        String[] arr = s.substring(1, s.length() - 1)
                .replaceAll("[{}]", " ").trim()
                .split(" ,");

//        Arrays.sort(arr, ((o1, o2) -> (o1.length() - o2.length())));
        Arrays.sort(arr, (Comparator.comparingInt(String::length)));

        int[] answer = new int[arr.length];
        int index = 0;

        for (String tuple: arr) {
            for (String ss : tuple.split(",")) {
                int e = Integer.parseInt(ss.trim());

                if (set.contains(e))
                    continue;

                set.add(e);
                answer[index++] = e;
            }
        }

        return answer;
    }

    @Test
    void test1() {
        int[] answer = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        Assertions.assertThat(answer).isEqualTo(new int[] {2, 1, 3, 4});
    }

    @Test
    void test2() {
        int[] answer = solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        Assertions.assertThat(answer).isEqualTo(new int[] {2, 1, 3, 4});
    }

    @Test
    void test3() {
        int[] answer = solution("{{20,111},{111}}");
        Assertions.assertThat(answer).isEqualTo(new int[] {111,20});
    }

    @Test
    void test4() {
        int[] answer = solution("{{123}}");
        Assertions.assertThat(answer).isEqualTo(new int[] {123});
    }

    @Test
    void test5() {
        int[] answer = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        Assertions.assertThat(answer).isEqualTo(new int[] {3,2,4,1});
    }
}
