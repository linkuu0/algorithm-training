package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private List<List<Integer>> list;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();

        list = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));

        for (int i=0; i<nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;

                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;

                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                }
            }
        }

        return list;
    }

    @Test
    void test() {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, 4});
        Assertions.assertThat(lists).isEqualTo(Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1)));
    }

    @Test
    void test2() {
        List<List<Integer>> lists = threeSum(new int[]{});
        Assertions.assertThat(lists).isEqualTo(new ArrayList<>());
    }

    @Test
    void test3() {
        List<List<Integer>> lists = threeSum(new int[]{0});
        Assertions.assertThat(lists).isEqualTo(new ArrayList<>());
    }
}
