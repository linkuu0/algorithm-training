package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] rows = new String[numRows];
        Arrays.fill(rows, "");

        int index = 0;
        boolean reverse = false;
        for (int i=0; i<s.length(); i++) {
            rows[index] += s.charAt(i);

            if (index == 0) {
                reverse = false;

            } else if (index == numRows - 1) {
                reverse = true;
            }

            if (!reverse) {
                index++;

            } else {
                index--;
            }

        }

        return String.join("", rows);
    }

    @Test
    void test() {
        String answer = convert("PAYPALISHIRING", 3);
        Assertions.assertThat(answer).isEqualTo("PAHNAPLSIIGYIR");
    }

    @Test
    void test1() {
        String answer = convert("PAYPALISHIRING", 4);
        Assertions.assertThat(answer).isEqualTo("PINALSIGYAHRPI");
    }

    @Test
    void test2() {
        String answer = convert("A", 1);
        Assertions.assertThat(answer).isEqualTo("A");
    }

    @Test
    void test3() {
        String answer = convert("AB", 1);
        Assertions.assertThat(answer).isEqualTo("AB");
    }
}
