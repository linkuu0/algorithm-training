package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int solution(String s) {
        if ("".equals(s)) return 0;

        int answer = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            while (set.contains(c)) {
                set.remove(s.charAt(j++));
            }

            set.add(c);
            answer = Math.max(answer, set.size());
        }

        return answer;
    }

    @Test
    void test() {
        int answer = solution("abcabcbb");
        Assertions.assertThat(answer).isEqualTo(3);
    }
}
