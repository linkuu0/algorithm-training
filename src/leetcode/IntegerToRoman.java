package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerToRoman {
    private static String[] symbols = new String[] {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    private static int[] values = new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        for (int i=0; i<symbols.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                answer.append(symbols[i]);
            }
        }

        return answer.toString();
    }

    @Test
    void test1() {
        String answer = intToRoman(3);
        Assertions.assertThat(answer).isEqualTo("III");
    }

    @Test
    void test2() {
        String answer = intToRoman(58);
        Assertions.assertThat(answer).isEqualTo("LVIII");
    }

    @Test
    void test3() {
        String answer = intToRoman(1994);
        Assertions.assertThat(answer).isEqualTo("MCMXCIV");
    }
}
