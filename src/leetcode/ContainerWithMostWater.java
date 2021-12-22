package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        int width;
        while (left < right) {
            width = right - left;
            max = Math.max(max, width * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;

            } else {
                right--;

            }
        }

        return max;
    }

    @Test
    void test() {
        int answer = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        Assertions.assertThat(answer).isEqualTo(49);
    }

    @Test
    void test2() {
        int answer = maxArea(new int[]{1,1});
        Assertions.assertThat(answer).isEqualTo(1);
    }
}
