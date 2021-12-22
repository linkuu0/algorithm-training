package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int j = i+1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff == 0)
                    return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }

                if (sum <= target) {
                    j++;

                } else {
                    k--;

                }
            }

        }

        return result;
    }

    @Test
    void test1() {
        int answer = threeSumClosest(new int[] {-1, 2, 1, -4}, 1);
        Assertions.assertThat(answer).isEqualTo(2);
    }

    @Test
    void test2() {
        int answer = threeSumClosest(new int[] {0,0,0}, 1);
        Assertions.assertThat(answer).isEqualTo(0);
    }
}
