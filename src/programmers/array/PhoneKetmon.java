package programmers.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PhoneKetmon {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        boolean[] arr = new boolean[200000];

        while (n > 0) {
            for (int p : nums) {
                if (!arr[p - 1]) {
                    answer++;
                    arr[p - 1] = true;
                    break;
                }
            }
            n--;
        }
        return answer;
    }

    public int solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int number: nums)
            set.add(number);

        return Math.min(set.size(), nums.length / 2);
    }

    @Test
    void test() {
        PhoneKetmon s = new PhoneKetmon();

        int answer1 = s.solution2(new int[]{3, 1, 2, 3});
        Assertions.assertThat(answer1).isEqualTo(2);

        int answer2 = s.solution2(new int[]{3, 3, 3, 2, 2, 4});
        Assertions.assertThat(answer2).isEqualTo(3);

        int answer3 = s.solution2(new int[]{3, 3, 3, 2, 2, 2});
        Assertions.assertThat(answer3).isEqualTo(2);
    }
}
