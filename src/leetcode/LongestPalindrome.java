package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPalindrome {

    public String solution(String s) {
        String answer = "";

        for (int i=0; i<s.length(); i++) {
            int odd = lengthOfPalidromeString(s, i, i);
            int even = lengthOfPalidromeString(s, i, i + 1);

            int length = Math.max(odd, even);
            if (answer.length() < length) {
                int beginIndex = i - (length - 1) / 2;
                int endIndex = i + length / 2 + 1;
                answer = s.substring(beginIndex, endIndex);
            }
        }

        return answer;
    }

    public int lengthOfPalidromeString(String str, int start, int end) {
        if (start < 0 || end >= str.length()) return 0;
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;

    }

    @Test
    void test() {
        String answer = solution("babad");
        Assertions.assertThat(answer).isEqualTo("bab");
    }
}
