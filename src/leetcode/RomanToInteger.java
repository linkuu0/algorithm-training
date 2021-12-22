package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> map = new HashMap<>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};


    public int romanToInt(String s) {
        int answer = 0;

        for (int i=0; i<s.length() - 1; i++) {
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));

            answer = curr < next ? answer - curr : answer + curr;

        }
        answer += map.get(s.charAt(s.length()-1));

        return answer;
    }

    @Test
    void test() {
        int answer = romanToInt("III");
        Assertions.assertThat(answer).isEqualTo(3);
    }

    @Test
    void test2() {
        int answer = romanToInt("LVIII");
        Assertions.assertThat(answer).isEqualTo(58);
    }

    @Test
    void test3() {
        int answer = romanToInt("MCMXCIV");
        Assertions.assertThat(answer).isEqualTo(1994);
    }
}
