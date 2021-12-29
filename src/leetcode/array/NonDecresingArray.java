package leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonDecresingArray {

    public boolean checkPossibility(int[] nums) {
        boolean flag = false;

        for (int i=0; i<nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                if (flag) return false;
                flag = true;

                if (i > 0 && nums[i-1] > nums[i+1]) {
                    nums[i+1] = nums[i];
                }
            }
        }

        return true;

    }

    @Test
    void test() {
        Assertions.assertThat(checkPossibility(new int[] {4,2,3})).isEqualTo(true);
    }

    @Test
    void test2() {
        Assertions.assertThat(checkPossibility(new int[] {4,2,1})).isEqualTo(false);
    }
}
