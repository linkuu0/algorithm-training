package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int number = x;

        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }

        return reverse == x;
    }

    @Test
    void test() {
        boolean answer = isPalindrome(121);
        Assertions.assertThat(answer).isTrue();
    }

    @Test
    void test2() {
        boolean answer = isPalindrome(-121);
        Assertions.assertThat(answer).isFalse();
    }

    @Test
    void test3() {
        boolean answer = isPalindrome(10);
        Assertions.assertThat(answer).isFalse();
    }
}
