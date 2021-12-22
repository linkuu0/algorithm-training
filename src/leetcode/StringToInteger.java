package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringToInteger {

    public int myAtoi(String s) {
        double answer = 0;

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        boolean isNegative = false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.charAt(0) == '-')
                isNegative = true;

            s = s.substring(1);
        }

        for (int i=0; i<s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }

            answer = answer * 10 + (s.charAt(i) - '0');
        }

        return isNegative ? (int) Math.max(answer * -1, Integer.MIN_VALUE) : (int) Math.min(answer, Integer.MAX_VALUE);
    }

    @Test
    void test() {
        int answer = myAtoi("9223372036854775808");
        Assertions.assertThat(answer).isEqualTo(42);
    }

    @Test
    void test2() {
        int answer = myAtoi("    -42");
        Assertions.assertThat(answer).isEqualTo(-42);
    }

    @Test
    void test3() {
        int answer = myAtoi("4193 with words");
        Assertions.assertThat(answer).isEqualTo(4193);
    }

    @Test
    void test4() {
        int answer = myAtoi("words and 987");
        Assertions.assertThat(answer).isEqualTo(987);
    }
}
