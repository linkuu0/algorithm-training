package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseInteger {

    public int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            reverse = (reverse * 10) + x % 10;
            x /= 10;
        }

        if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) reverse;
    }

    @Test
    void test() {
        int answer = reverse(123);
        Assertions.assertThat(answer).isEqualTo(321);
    }

    @Test
    void test2() {
        int answer = reverse(-123);
        Assertions.assertThat(answer).isEqualTo(-321);
    }

    @Test
    void test3() {
        int answer = reverse(120);
        Assertions.assertThat(answer).isEqualTo(21);
    }

    @Test
    void test4() {
        int answer = reverse(1534236469);
        Assertions.assertThat(answer).isEqualTo(0);
    }
}
